package top.ctong.learn.utils.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * █████▒█      ██  ▄████▄   ██ ▄█▀     ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒      ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░      ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄      ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄     ██████╔╝╚██████╔╝╚██████╔╝
 * ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒     ╚═════╝  ╚═════╝  ╚═════╝
 * ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 * ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 * ░     ░ ░      ░  ░
 * Copyright 2021 Clover.
 * <p>
 * mybatis自定义类型处理器
 * </p>
 * @author Clover
 * @version V1.0
 * @class MyTypeHandler
 * @create 2021-08-11 3:37 下午
 */
public class MyTypeHandler extends BaseTypeHandler<MyEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, MyEnum myEnum, JdbcType jdbcType)
            throws SQLException {

    }

    @Override
    public MyEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public MyEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public MyEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }

}

enum MyEnum {
    ADMIN,
    USER
}