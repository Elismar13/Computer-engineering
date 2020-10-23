package br.ifpb.edu;

import br.ifpb.edu.exception.QuantiaNaoNegativaException;
import br.ifpb.edu.exception.SaldoInuficienteException;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

public class Banco {

    private HashMap<Long, ContaCorrente> contas;
    private GeradorID geradorID;
    private NumberFormat numberFormat;

    public Banco() {
        contas = new HashMap<Long, ContaCorrente>();
        geradorID = new GeradorID(555L);
        numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
    }

    public ContaCorrente cadrastro(String nome) throws QuantiaNaoNegativaException {
        Long id = this.gerarId();
        ContaCorrente novaConta = new ContaCorrente(id, nome);
        contas.put(id, novaConta);
        return novaConta;
    }

    public ContaCorrente cadrastro(String nome, BigDecimal saldoInicial) throws QuantiaNaoNegativaException {
        Long id = this.gerarId();
        ContaCorrente novaConta = new ContaCorrente(id, nome, saldoInicial);
        contas.put(id, novaConta);
        return novaConta;
    }

    public ContaCorrente procuraContaPorId(Long id) {
        if(this.existeContaComId(id))
            return contas.get(id);
        return null;
    }

    public ContaCorrente atualizaConta(Long id, ContaCorrente conta) {
        return contas.put(id, conta);
    }

    private Long gerarId() {
        Long novoId = geradorID.gerarId();
        while(contas.containsKey(novoId)) {
            novoId = geradorID.gerarId();
        }
        return novoId;
    }

    public boolean existeContaComId(Long contaId) {
        return this.contas.containsKey(contaId);
    }

    public String consultarSaldo(Long contaId) {
        if(this.existeContaComId(contaId)) {
            ContaCorrente conta = this.procuraContaPorId(contaId);
            return numberFormat.format(conta.saldo());
        }
        return null;
    }

    public String consultarExtrato(Long contaId) {
        ContaCorrente conta = this.procuraContaPorId(contaId);
        return "\n========Seu extrato========\n"
                + conta.extrato()
                + this.consultarSaldo(conta.getNumero());
    }

    public BigDecimal sacarNaConta(Long contaId, BigDecimal valorSaque) throws SaldoInuficienteException, QuantiaNaoNegativaException {
        ContaCorrente conta = this.procuraContaPorId(contaId);
        return conta.sacar(valorSaque);
    }

    public boolean depositarNaConta(Long contaId, BigDecimal valor) throws QuantiaNaoNegativaException {
        ContaCorrente conta = this.procuraContaPorId(contaId);
        return conta.deposito(valor);
    }
}
