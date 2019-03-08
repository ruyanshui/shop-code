package com.example.commoncore.database.typehandlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UnixLong2DateTypeHandler implements TypeHandler<Date> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Date getResult(ResultSet resultSet, String s) throws SQLException {
        long unixlongTime = resultSet.getLong(s);
        Date date = new Date(unixlongTime*1000);
        return date;
    }

    @Override
    public Date getResult(ResultSet resultSet, int i) throws SQLException {
        long unixlongTime = resultSet.getLong(i);
        Date date = new Date(unixlongTime*1000);
        return date;
    }

    @Override
    public Date getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i);
    }
}
