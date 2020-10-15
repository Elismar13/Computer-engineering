package br.ifpb.edu;

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

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        if(numero > 0)
            this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if(!titular.isBlank())
            this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public boolean deposito(BigDecimal valor) {
        if(valor.doubleValue() > 0.00) {
            setSaldo(saldo.add(valor));
            return true;
        }
        return false;
    }

    public BigDecimal sacar(BigDecimal valor) {
        if(valor.doubleValue() > 0.00) {
            BigDecimal saque = saldo.subtract(valor);
        }
    }

}
