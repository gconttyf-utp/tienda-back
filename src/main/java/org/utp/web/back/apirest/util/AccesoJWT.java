package org.utp.web.back.apirest.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.constraints.NotNull;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccesoJWT {

    public static final int EXPIRATION_IN_MINUTES = 30;
    public static final String SECRET_KEY = "CURSO INTEGRADOR I UTP NORTE 2026";

    public static void datos() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "Nombre y Apellido");
        params.put("codigo", "123");

        Map<String, Object> extraClaims = buildExtraClaims(params);

        String jwt = buildJws("CLIENTE", extraClaims);

        System.out.println("jwt= " + jwt);

        try {
            Claims payLoad = verifyJws(jwt);
            System.out.println("payLoad.getSubject()= " + payLoad.getSubject());
            System.out.println("payLoad.getIssuedAt()= " + payLoad.getIssuedAt());
            System.out.println("payLoad.getExpiration()= " + payLoad.getExpiration());

            String name = payLoad.get("name", String.class);
            String codigo = payLoad.get("codigo", String.class);

            System.out.println("Nombre validado: " + name);
            System.out.println("Código validado: " + codigo);

        } catch (JwtException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String generaToken(String subject, Map<String, Object> params) {
        Map<String, Object> extraClaims = buildExtraClaims(params);
        String jwt = buildJws(subject, extraClaims);
        System.out.println("jwt= " + jwt);
        return jwt;
    }

    public static Claims validaToken(String jwt) {
        try {
            Claims payLoad = verifyJws(jwt);
            return payLoad;
        } catch (JwtException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static Claims verifyJws(String jwt) {
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

    private static String buildJws(String subject, Map<String, Object> extraClaims) {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + (EXPIRATION_IN_MINUTES * 60 * 1000));

        String jwt = Jwts.builder()

                .header()
                .type("JWT")
                .and()

                .subject(subject)
                .expiration(expiration)
                .issuedAt(issuedAt)
                .claims(extraClaims)

                .signWith(generateKey(), Jwts.SIG.HS256)

                .compact();
        return jwt;
    }

    private static @NotNull Map<String, Object> buildExtraClaims(Map<String, Object> params) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.putAll(params);
        //extraClaims.put("name", "Nombre del Usuario");
        return extraClaims;
    }

    private static SecretKey generateKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

}