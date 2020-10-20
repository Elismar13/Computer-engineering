package br.ifpb.edu;

import br.ifpb.edu.exception.QuantiaNaoNegativaException;

import java.math.BigDecimal;
import java.util.HashMap;

public class Banco {

    HashMap<Long, ContaCorrente> contas;
    GeradorID geradorID;

    public Banco() {
        contas = new HashMap<Long, ContaCorrente>();
        geradorID = new GeradorID(555L);
    }

    public ContaCorrente criaConta(String nome) throws QuantiaNaoNegativaException {
        Long id = this.gerarId();
        ContaCorrente novaConta = new ContaCorrente(id, nome);
        contas.put(id, novaConta);
        return novaConta;
    }

    public ContaCorrente criaConta(String nome, BigDecimal saldoInicial) throws QuantiaNaoNegativaException {
        Long id = this.gerarId();
        ContaCorrente novaConta = new ContaCorrente(id, nome, saldoInicial);
        contas.put(id, novaConta);
        return novaConta;
    }

    public ContaCorrente procurarContaPorId(Long id) {
        return contas.get(id);
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
}
