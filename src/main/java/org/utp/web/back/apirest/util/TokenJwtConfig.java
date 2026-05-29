package org.utp.web.back.apirest.util;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public class TokenJwtConfig {

    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final Date ISSUEDAT = new Date(System.currentTimeMillis());
    public static final int EXPIRATION_IN_MINUTES = 30;
    public static final Date EXPIRATION_DATE = new Date(System.currentTimeMillis() + EXPIRATION_IN_MINUTES * 60 * 1000);

}
