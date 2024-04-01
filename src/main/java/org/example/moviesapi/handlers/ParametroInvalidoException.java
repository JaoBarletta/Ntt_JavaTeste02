package org.example.moviesapi.handlers;

public class ParametroInvalidoException extends RuntimeException {

    public ParametroInvalidoException(String mns) {
        super(mns);
    }

    public ParametroInvalidoException(String mns, Throwable causa) {
        super(mns, causa);
    }
}
