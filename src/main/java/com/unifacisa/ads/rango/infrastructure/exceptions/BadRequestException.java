package com.unifacisa.ads.rango.infrastructure.exceptions;

public class BadRequestException extends BusinessException{


    public BadRequestException(String resourceName, Object identifier) {
        super(resourceName + " com identificador " + identifier + " não foi encontrado.");
    }

    public BadRequestException(String message) {
        super(message);
    }
}
