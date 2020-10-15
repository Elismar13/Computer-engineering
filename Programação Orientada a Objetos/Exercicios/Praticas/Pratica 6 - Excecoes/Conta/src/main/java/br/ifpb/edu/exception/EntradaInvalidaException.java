package br.ifpb.edu.exception;

public class EntradaInvalidaException extends RuntimeException {
    public EntradaInvalidaException() {
        super("Entrada inválida.");
    }

    public EntradaInvalidaException(String message) {
        super(message);
    }
}
