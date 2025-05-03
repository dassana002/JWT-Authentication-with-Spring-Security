package org.jwtspringsecurity.jwtauthentication.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {

    private final SecretKey secretKey;

    // Generate a Secret Key
    public JWTService() {
        try {
            SecretKey k = KeyGenerator.getInstance("HmacSHA256").generateKey();
            secretKey = Keys.hmacShaKeyFor(k.getEncoded());
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }

    // Generate Token
    public String generateToken() {
        return Jwts.builder()
                .subject("Dassana")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration((new Date(new Date().getTime() + 1000 * 60 * 60 * 24 * 7)))
                .signWith(secretKey)
                .compact();
    }

    // Get User Name On Token
    public String getUsername(String token) {
        return Jwts
                .parser()
                .verifyWith(secretKey).build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
