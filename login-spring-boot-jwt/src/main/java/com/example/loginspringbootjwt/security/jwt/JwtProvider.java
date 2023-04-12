package com.example.loginspringbootjwt.security.jwt;

import com.example.loginspringbootjwt.security.userprincal.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

//tạo ra token
@Component
public class JwtProvider {
    // ghi log
    private final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    // key token
    private String jwtSecret = "trinhnamgsdfhasgdfhhjdfsgh545655464545djhfgjdfhjdf";
    //thiết lập thời gian sống trên h thống
    private int jwtExp = 86400;

    //Tạo token
    public String createToken(Authentication authentication) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrinciple.getUsername()) // set username vào
                .setIssuedAt(new Date()) //set tại thời điểm nào
                .setExpiration(new Date(new Date().getTime() + jwtExp)) // set thời gian sống
                .signWith(SignatureAlgorithm.HS256, jwtSecret).compact(); //set thuật toán
    }

    //check xem token có hợp lệ không
    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token);
        } catch (SignatureException e) {
            logger.error("invalid JWT signature -> Message: {}", e);
        } catch (MalformedJwtException e) {
            logger.error("invalid format Token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }
        return false;
    }

    //Tìm username có tên là gì
    public String getUsernameFromToken(String token) {
        String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token).getBody().getSubject();
        return username;
    }
}
