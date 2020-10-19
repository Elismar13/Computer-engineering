package br.ifpb.edu;

import br.ifpb.edu.exception.EntradaInvalidaException;
import br.ifpb.edu.exception.QuantiaNaoNegativaException;
import br.ifpb.edu.exception.SaldoInuficienteException;

import java.math.BigDecimal;

public class ContaCorrente {
    private final double CPMF = 0.01;

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

    private void setNumero(Long numero) {
        if(numero > 0)
            this.numero = numero;
        else
            throw new EntradaInvalidaException("Numero não pode ser negativo.");
    }

    private String getTitular() {
        return titular;
    }

    private void setTitular(String titular) {
        if(!titular.isBlank())
            this.titular = titular;
        else
            throw new EntradaInvalidaException("Nome não pode ser deixado em branco.");
    }

    private BigDecimal getSaldo() {
        return saldo;
    }

    private void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    private BigDecimal calculaCPMF() {
        return getSaldo().multiply(new BigDecimal(0.01) );
    }

    private void descontaCPMF() {
        BigDecimal CPMFDescontado = this.calculaCPMF();
        setSaldo(getSaldo().subtract(CPMFDescontado));
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

    public BigDecimal sacar(BigDecimal valor) throws SaldoInuficienteException {
        BigDecimal cpmf = this.calculaCPMF();
        if(valor.doubleValue() > 0.00) {
            if(valor.doubleValue() > cpmf.doubleValue()) {
                setSaldo(saldo.subtract(valor)
                              .subtract(cpmf));
                return valor;
            }
            else {
                throw new SaldoInuficienteException("Saldo insuficiente.");
            }
        }
        else {
            throw new EntradaInvalidaException("Não pode sacar valores negativos.");
        }
    }

    public double saldo() {
        return getSaldo().doubleValue();
    }

    public String extrato() {
        return "";
    }

}
