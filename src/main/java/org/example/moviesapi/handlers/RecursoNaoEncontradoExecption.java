package org.example.moviesapi.handlers;

public class RecursoNaoEncontradoExecption extends RuntimeException{

    public RecursoNaoEncontradoExecption(String mns) {
        super(mns);
    }

    public RecursoNaoEncontradoExecption(String mns, Throwable causa) {
        super(mns, causa);
    }
}
