package org.utp.web.back.apirest.exceptions;

import lombok.Getter;

@Getter
public class APIException extends BaseException{

    private final int codigoHttp;

    public APIException(int codigoInterno, String message){
        super(codigoInterno, message);
        this.codigoHttp = 500;
    }

    public APIException(String message){
        super(-1, message);
        this.codigoHttp = 500;
    }

    public APIException(int codigoHttp, int codigoInterno, String message){
        super(codigoInterno, message);
        this.codigoHttp = codigoHttp;
    }

}
