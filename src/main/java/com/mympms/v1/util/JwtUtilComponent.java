package com.mympms.v1.util;

import com.mympms.v1.entity.Customer;
import com.mympms.v1.enumeration.AuthorityType;
import com.mympms.v1.service.CustomerService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Component
public class JwtUtilComponent {
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.expireInMs}")
    private long expirationTime;

    @Autowired
    private CustomerService customerService;

    public String generateToken(int customerId, String username, List<String> roles) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
            .setSubject(Integer.toString(customerId))
            .claim("username", username)
            .claim("roles", roles)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, secretKey)
            .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .getBody();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();

        int userId = Integer.parseInt(claims.getSubject());

        String username = claims.get("username", String.class);
        List<String> roles = claims.get("roles", List.class);

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(
                new SimpleGrantedAuthority(AuthorityType.ROLE_SUPER_ADMIN.name()) // in dev
        );

        Optional<Customer> customer = customerService.getOneById(userId);

        return new UsernamePasswordAuthenticationToken(customer, null, authorities);
    }
}
