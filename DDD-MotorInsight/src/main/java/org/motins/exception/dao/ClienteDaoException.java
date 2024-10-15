package org.motins.exception.dao;

public class ClienteDaoException extends Exception {
    public ClienteDaoException(String message) {
        super(message);
    }

    public ClienteDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
