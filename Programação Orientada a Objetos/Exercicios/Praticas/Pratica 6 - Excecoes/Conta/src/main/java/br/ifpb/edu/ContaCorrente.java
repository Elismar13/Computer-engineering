package br.ifpb.edu;

import br.ifpb.edu.exception.EntradaInvalidaException;
import br.ifpb.edu.exception.QuantiaNaoNegativaException;

import java.math.BigDecimal;

public class ContaCorrente {
    private Long numero;
    private String titular;
    private BigDecimal saldo;

    public ContaCorrente(Long numero, String titular) {
        this(numero, titular, BigDecimal.TEN);
    }

    public ContaCorrente(Long numero, String titular, BigDecimal saldo) {
        this.numero = numero;
        this.titular = titular;
        setSaldo(saldo);
    }

    private Long getNumero() {
        return numero;
    }

    private void setNumero(Long numero) {
        if(numero > 0)
            this.numero = numero;
    }

    private String getTitular() {
        return titular;
    }

    private void setTitular(String titular) {
        if(!titular.isBlank())
            this.titular = titular;
    }

    private BigDecimal getSaldo() {
        return saldo;
    }

    public double saldo() {
        return getSaldo().doubleValue();
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public boolean deposito(BigDecimal valor) throws QuantiaNaoNegativaException, EntradaInvalidaException {
        if(valor.doubleValue() > 0.00) {
            setSaldo(saldo.add(valor));
            return true;
        } else if(valor.doubleValue() == 0.00) {
            throw new EntradaInvalidaException("O valor não pode ser nulo!");
        }
        else {
            throw new QuantiaNaoNegativaException("O valor não pode ser negativo!");
        }
    }

    public BigDecimal sacar(BigDecimal valor) {
        if(valor.doubleValue() > 0.00) {
            setSaldo(saldo.subtract(valor));
        }

        return BigDecimal.ZERO;
    }

}
