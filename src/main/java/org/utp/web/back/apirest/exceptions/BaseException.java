package org.utp.web.back.apirest.exceptions;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final int codigoInterno;

    public BaseException(int codigoInterno, String message) {
        super(message);
        this.codigoInterno = codigoInterno;
    }

}
