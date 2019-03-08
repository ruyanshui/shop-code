package com.example.securitycore.filter;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SysAccessControllerFilter extends AccessControlFilter{

    // 被提出后，重定向的url
    private String url;
    private boolean isKickoutAfter = false;
    private int maxSession = 1;

    private SessionManager sessionManager;
    private Cache<String , Deque<Serializable>> cache;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isKickoutAfter() {
        return isKickoutAfter;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        isKickoutAfter = kickoutAfter;
    }

    public int getMaxSession() {
        return maxSession;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public Cache<String, Deque<Serializable>> getCache() {
        return cache;
    }

    public void setCache(Cache<String, Deque<Serializable>> cache) {
        this.cache = cache;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        Subject subject= getSubject(servletRequest, servletResponse);
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            return true;
        }
        Session session = subject.getSession();
        String username = "";
        Serializable sessionId = session.getId();
        // 读取缓存
        Deque<Serializable> deque = cache.get(username);
        // new 一个空队列
        if (deque == null) {
            deque = new LinkedList<>();
        }
        // 如果队列里没有此sessionId,且用户没有被提出，放入队列
        if (!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
            // 将sessionId存入队列
            deque.push(sessionId);
            // 将用户的sessionId队列缓存
            cache.put(username, deque);
        }
        // 如果队列里的sessionId数超出最大会话数，开始踢人
        while(deque.size() > maxSession) {
            Serializable kickoutSessionid = null;
            // 如果踢出后者
            if (isKickoutAfter) {
                kickoutSessionid = deque.removeFirst();
                // 踢出后再更新下缓存队列
                cache.put(username, deque);
            } else {
                // 踢出前者
                kickoutSessionid = deque.removeLast();
                // 踢出后再更新下缓存队列
                cache.put(username, deque);
            }

            // 获取被提出的sessionId的sessison对象
            Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionid));
            try {
                if (kickoutSession != null) {
                    // 设置会话的kickout属性表示踢出了
                    kickoutSession.setAttribute("kickout", true);
                }
            } catch (InvalidSessionException e) {
                e.printStackTrace();
            }

            saveRequest(servletRequest);
            Map<String, String> resultMap = new HashMap<>();
            // 判断是否是ajax请求
            if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) servletRequest).getHeader("X-Requested-With"))) {
                resultMap.put("user_status", "300");
                resultMap.put("message", "您已经在其他地方登陆，请重新登录!");
                // 输出json串
                out(servletResponse, resultMap);
            } else {
                // 重定向
                WebUtils.issueRedirect(servletRequest, servletResponse, url);
            }
            return false;

        }

        return true;
    }

    private void out(ServletResponse servletResponse, Map<String, String> resultMap) {
        servletResponse.setContentType("UTF-8");
        try {
            PrintWriter out = servletResponse.getWriter();
            out.println(JSON.toJSON(resultMap));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("KickoutSessionFilter.class 输出JSON异常，可以忽略。");
        }

    }
}
