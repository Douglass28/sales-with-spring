package com.dsevoluction.sales;

import com.dsevoluction.sales.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    public String geraToken(User user){
        Long expString = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiraçao = LocalDateTime.now().plusMinutes(expString);
        Instant instant = dataHoraExpiraçao.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        return Jwts
                .builder()
                .setSubject(user.getUsername())
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, chaveAssinatura)
                .compact();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SalesApplication.class);
        JwtService service = context.getBean(JwtService.class);
        User user = User.builder().username("douglas").build();
        String token = service.geraToken(user);
        System.out.println(token);
    }
}
