package com.br.fontana.digital.security;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	
	// EXPIRATION_TIME = 10 dias
	static final long EXPIRATION_TIME = 600000;
	static final String SECRET = "Quao bom e suave que os irmaos vivam em uniao";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";
	
	static void addAuthentication(HttpServletResponse response, String user) {
		String JWT = Jwts.builder()
				.setSubject(user)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
		
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	}
	
	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		
		if (token != null) {
			// faz parse do token
			String sub = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();
			
			if (sub != null) {
			//	String[] values = sub.split("[|]"); 
			//	SystemUser user = new SystemUser("", values[0], "", Integer.valueOf(values[1]), Collections.emptyList());
						
				return new UsernamePasswordAuthenticationToken(sub,null,Collections.emptyList());
			}
		}
		return null;
	}
	
}
