package br.edu.ifpb;

public class Gerente extends Funcionario {
    private double comissao;

    public Gerente() {
        this(0, "--- sem nome ---", 0, 999.99, 0);
    }

    public Gerente(int matricula, String nome, int idade, double salarioBase, double comissao) {
        super(matricula, nome, idade, salarioBase);
        setComissao( comissao );
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
}
