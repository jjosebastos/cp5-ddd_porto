package org.motins.exception.dao;

public class PessoaFisicaDaoException extends Exception {
    public PessoaFisicaDaoException(String message) {
        super(message);
    }

    public PessoaFisicaDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}