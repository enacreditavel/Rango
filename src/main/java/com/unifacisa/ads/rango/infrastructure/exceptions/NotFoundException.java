package com.unifacisa.ads.rango.infrastructure.exceptions;

public class NotFoundException extends BusinessException {

    public NotFoundException(String resourceName, Object identifier) {
        super(resourceName + " com identificador " + identifier + " não foi encontrado.");
    }

    public NotFoundException(String message) {
        super(message);
    }
}