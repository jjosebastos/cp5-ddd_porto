package org.motins.exception;

public class PessoaJuridicaDaoException extends Exception {
    public PessoaJuridicaDaoException(String message) {
        super(message);
    }

    public PessoaJuridicaDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}