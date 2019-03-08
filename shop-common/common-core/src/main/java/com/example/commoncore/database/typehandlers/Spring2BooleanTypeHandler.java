package com.example.commoncore.database.typehandlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 将数据库中的“Y”和“N”类型转为boolean类型
 */
public class Spring2BooleanTypeHandler implements TypeHandler<Object>{
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        boolean flag;
        if (resultSet.getString(s).equals("Y")) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        boolean flag;
        if(resultSet.getString(i).equals("Y")){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }
}
