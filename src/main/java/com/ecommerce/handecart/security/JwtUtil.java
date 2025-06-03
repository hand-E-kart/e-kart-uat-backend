//package com.ecommerce.handecart.security;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//public class JwtUtil {
//
//	@Autowired
//	private Environment env;
//	
//	private String secret = "ecommerce_secret";
//
//    public String generateToken(UserDetails userDetails) {
//    	Date now = new Date();
//        Date expirationDate = new Date(now.getTime() + Integer.valueOf(env.getProperty("jwttokenexpiretime")) * 1000);
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .claim("role", userDetails.getAuthorities().toString())
//                .setIssuedAt(new Date())
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
//                .getBody().getSubject();
//    }
//
//}
