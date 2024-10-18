package com.siemens.webstore.webstoreapi.configurations;

import com.siemens.webstore.webstoreapi.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWTManager {

    @Value("${jwt.secretkey}")
    private String secretKey;
    @Value("${jwt.token.validity}")
    private long expiryTime;

    public String generateToken(User user){
        Claims claims = Jwts.claims().setSubject(user.getUserName());
        claims.put("roles", user.getRoles());
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + expiryTime;
        Date exp = new Date(expMillis);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, secretKey).compact();}

}
