package com.unifacisa.ads.rango.infrastructure.exceptions;

public class AlreadyExistsException extends BusinessException {

    public AlreadyExistsException(String resourceName, Object identifier) {
        super(resourceName + " com identificador " + identifier + " já existe no sistema.");
    }

    public AlreadyExistsException(String message) {
        super(message);
    }
}
