package com.hexelan.mims.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {
private  static String SECRET_KEY = "3979244226452948404D635166546A576E5A7234753777217A25432A462D4A61 ";
    public String extractUserEmail(String token) {
        return extractClaim(token , Claims::getSubject);
    }

    public  String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ){}
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final  Claims claims = extractAllClaims(token);
       return claimsResolver.apply(claims);
    }
     private Claims extractAllClaims(String token ){
        return Jwts.parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
     }

     private Key getSigninKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
     }
}
