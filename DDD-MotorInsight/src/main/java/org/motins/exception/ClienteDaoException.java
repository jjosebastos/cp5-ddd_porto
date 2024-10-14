package org.motins.exception;

public class ClienteDaoException extends Exception {
    public ClienteDaoException(String message) {
        super(message);
    }

    public ClienteDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
