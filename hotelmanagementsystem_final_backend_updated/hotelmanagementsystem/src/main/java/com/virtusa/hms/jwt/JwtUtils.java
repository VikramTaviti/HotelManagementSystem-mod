package com.virtusa.hms.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.virtusa.hms.exceptions.JwtTokenExpiredException;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtUtils{
private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

@Value("${spring.app.jwtSecret}") 
private String jwtSecret;

@Value("${spring.app.jwtExpirationMs}")
private long jwtExpirationMs;

public String getJwtFromHeader(HttpServletRequest request){
	String bearerToken = request.getHeader("Authorization");
	logger.debug("Authorization Header: {}",bearerToken);
	if(bearerToken !=null && bearerToken.startsWith("Bearer ")){
		return bearerToken.substring(7); // Remove Bearer prefix
	}
	return null;
}

public String generateTokenFromUsername(UserDetails userDetails){
	String username = userDetails.getUsername();
	Instant now = Instant.now();
    
    // Calculate the future date
    Instant futureInstant = now.plus(Duration.ofMillis(jwtExpirationMs));
    
    // Convert to Date
    Date futureDate = Date.from(futureInstant);
    
	return Jwts.builder()
						.subject(username)
						.issuedAt(Date.from(now))
						.expiration(futureDate)
						.signWith(key())
						.compact();
}

public String getUserNameFromJwtToken(String token){
	return Jwts.parser()
							.verifyWith((SecretKey) key())
							.build()
							.parseSignedClaims(token)
							.getPayload()
							.getSubject();
}

private Key key(){
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
}

public boolean validateJwtToken(String authToken) throws JwtTokenExpiredException{
		try{
			logger.debug("validated");
			Jwts.parser()
						.verifyWith((SecretKey)key())
						.build().parseSignedClaims(authToken);
			return true;
		}catch(MalformedJwtException e){
				logger.error("Invalid JWT token: {}",e.getMessage());
		}catch(ExpiredJwtException e){
			logger.error("JWT token is expired: {}",e.getMessage());
			throw new JwtTokenExpiredException("JWT token is expired");
				
		}catch(UnsupportedJwtException e){
				logger.error("JWT token is Unsupported: {}",e.getMessage());
		}catch(IllegalArgumentException e){
				logger.error("JWT Claims String is empty: {}",e.getMessage());
		}
		return false;
}

}

