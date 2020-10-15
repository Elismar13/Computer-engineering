package br.ifpb.edu.exception;

public class QuantiaNaoNegativaException extends Exception {
    public QuantiaNaoNegativaException() {
    }

    public QuantiaNaoNegativaException(String message) {
        super(message);
    }
}
