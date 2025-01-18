package com.hotela.Hotela.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // Tạo secret key an toàn có kích thước >= 256 bit
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);  // HS256 yêu cầu secret key >= 256 bit

    // Hàm tạo token
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Token hết hạn sau 1 giờ
                .signWith(secretKey)
                .compact();
    }

    // Hàm lấy username từ token
    public String extractEmail(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }

    // Kiểm tra nếu token hợp lệ
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Lấy ngày hết hạn từ token
    private Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
