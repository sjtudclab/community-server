package cn.edu.sjtu.se.dclab.server.entity.converter;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by Huiyi on 2015/3/29.
 */
public class ContentHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
    	ByteArrayInputStream stream = new ByteArrayInputStream(s.getBytes());
        preparedStatement.setBlob(i, stream);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if (resultSet.wasNull())
            return null;

        Blob blob = resultSet.getBlob(s);
        return convertBlobToString(blob);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if (resultSet.wasNull())
            return null;

       return convertBlobToString(resultSet.getBlob(i));
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        if (callableStatement.wasNull())
            return null;
        return convertBlobToString(callableStatement.getBlob(i));
    }
    
    private String convertBlobToString(Blob blob) throws SQLException{
    	String content = null;
    	if (blob == null || blob.length() == 0)
			content = "";
		else {
            try {
                content = new String(blob.getBytes(1, (int) blob.length()), "utf-8");
            } catch (UnsupportedEncodingException ex) {

            }
		}

    	return content;
    }
    
}

