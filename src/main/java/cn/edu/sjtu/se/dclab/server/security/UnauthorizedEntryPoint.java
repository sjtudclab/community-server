package cn.edu.sjtu.se.dclab.server.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 *2015年1月19日 下午9:06:42
 *@author changyi yuan
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint
{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException
	{
		response.sendError(
				HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized: Authentication token was either missing or invalid.");
	}

}
