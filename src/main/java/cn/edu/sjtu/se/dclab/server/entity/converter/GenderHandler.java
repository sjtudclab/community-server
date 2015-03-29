package cn.edu.sjtu.se.dclab.server.entity.converter;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Huiyi on 2015/3/29.
 */
public class GenderHandler extends BaseTypeHandler<String> {

    private static final String MAN = "男";
    private static final String WOMEN = "女";

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        if (s.equals(MAN)) {
            preparedStatement.setInt(i, 0);
        } else {
            preparedStatement.setInt(i, 1);
        }
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if (resultSet.wasNull())
            return null;

        if (resultSet.getInt(s) == 0) {
            return MAN;
        } else {
            return WOMEN;
        }
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if (resultSet.wasNull())
            return null;

        if (resultSet.getInt(i) == 0) {
            return MAN;
        } else {
            return WOMEN;
        }
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        if (callableStatement.wasNull())
            return null;

        if (callableStatement.getInt(i) == 0) {
            return MAN;
        } else {
            return WOMEN;
        }
    }
}

