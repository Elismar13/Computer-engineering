package br.edu.ifpb;

public class Calculadora {
    protected String descricao;
    protected double memoria;

    Calculadora(){
        alterarDescricao("Knigth13-tb898");
        gravarMemoria(0.00);
    }

    //Métodos
    public double somar (double umNumero, double outroNumero) {
        double soma = umNumero + outroNumero;
        return soma;
    }

    public double subtrair (double umNumero, double outroNumero) {
        double subtracao = umNumero - outroNumero;
        return subtracao;
    }

    public double multiplicar (double umNumero, double outroNumero) {
        double multiplicacao = umNumero * outroNumero;
        return multiplicacao;
    }

    public double dividir (double umNumero, double outroNumero) {
        double divisao = umNumero / outroNumero;
        return divisao;
    }

    public void gravarMemoria (double umNumero) {
        memoria = umNumero;
    }

    public double lerMemoria () {
        return memoria;
    }

    void alterarDescricao (String descricao) {
        if(descricao.length() > 0) {
            this.descricao = descricao;
        }
    }

    String consultarDescricao() {
        return descricao;
    }
}
