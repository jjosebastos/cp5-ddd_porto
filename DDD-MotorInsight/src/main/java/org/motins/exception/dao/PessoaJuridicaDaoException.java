package org.motins.exception.dao;

public class PessoaJuridicaDaoException extends Exception {
    public PessoaJuridicaDaoException(String message) {
        super(message);
    }

    public PessoaJuridicaDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}