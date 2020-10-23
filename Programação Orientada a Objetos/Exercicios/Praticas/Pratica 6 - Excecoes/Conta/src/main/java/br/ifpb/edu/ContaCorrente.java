package br.ifpb.edu;

import br.ifpb.edu.exception.EntradaInvalidaException;
import br.ifpb.edu.exception.QuantiaNaoNegativaException;
import br.ifpb.edu.exception.SaldoInuficienteException;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class ContaCorrente {
    private final double CPMF = 0.01;

    private Long numero;
    private String titular;
    private BigDecimal saldo;

    public ContaCorrente(Long numero, String titular) throws QuantiaNaoNegativaException, EntradaInvalidaException {
        this(numero, titular, BigDecimal.TEN);
    }

    public ContaCorrente(Long numero, String titular, BigDecimal saldo) throws QuantiaNaoNegativaException, EntradaInvalidaException {
        setNumero(numero);
        setTitular(titular);
        deposito(saldo);
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

    public String getTitular() {
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
            setSaldo((saldo != null)
                    ? getSaldo().add(valor)
                    : valor);
            return true;
        } else if(valor.doubleValue() == 0.00) {
            throw new EntradaInvalidaException("O valor não pode ser nulo!");
        }
        else {
            throw new QuantiaNaoNegativaException("O valor não pode ser negativo!");
        }
    }

    public BigDecimal sacar(BigDecimal valor) throws SaldoInuficienteException, QuantiaNaoNegativaException {
        BigDecimal cpmf = this.calculaCPMF();
        BigDecimal saldo = getSaldo();
        BigDecimal disponivelPSaque = saldo.subtract(cpmf);
        if(valor.doubleValue() > 0.00) {
            if(valor.doubleValue() <= disponivelPSaque.doubleValue()) {
                setSaldo(saldo.subtract(valor)
                              .subtract(cpmf));
                return valor;
            }
            else {
                throw new SaldoInuficienteException("Saldo insuficiente.");
            }
        }
        else {
            throw new QuantiaNaoNegativaException("Não pode sacar valores negativos.");
        }
    }

    public BigDecimal saldo() {
        return getSaldo();
    }

    public String extrato() {
        return String.format("ID: %s%nTitular: %s%n", getNumero(), getTitular());
    }
}
