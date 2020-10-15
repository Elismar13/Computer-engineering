package br.ifpb.edu.exception;

public class SaldoInuficienteException extends Exception {
    public SaldoInuficienteException() {
        super("Saldo insuficiente.")
    }

    public SaldoInuficienteException(String message) {
        super(message);
    }
}
