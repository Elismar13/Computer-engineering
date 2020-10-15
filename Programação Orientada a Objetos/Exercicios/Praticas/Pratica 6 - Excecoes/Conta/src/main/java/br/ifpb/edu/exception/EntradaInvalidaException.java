package br.ifpb.edu.exception;

public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException() {
        super("Entrada inválida.")
    }

    public EntradaInvalidaException(String message) {
        super(message);
    }
}
