package org.utp.web.back.apirest.models.dto;

import java.util.Date;

public record LoginJWT(String accessToken, Date issuedAt, Date expiration) {
}
