package br.edu.ifpb;

public class Calculadora {
    protected String descricao;
    protected double memoria;

    public double somar ( double umNumero, double outroNumero ) {
        return (umNumero + outroNumero);
    }

    public double subtrair ( double umNumero, double outroNumero ) {
        return (umNumero - outroNumero);
    }

    public double multiplicar ( double umNumero, double outroNumero ) {
        return (umNumero * outroNumero);
    }

    public double dividir ( double umNumero, double outroNumero ) {
        return (umNumero/outroNumero);
    }

    public void gravarMemoria ( double umNumero ) {
        memoria = umNumero;
    }

    public double lerMemoria () {
        return memoria;
    }

    public void alterarDescricao ( String descricao ) {
        if(descricao.length() > 0)
            this.descricao = descricao;
    }

    public String consultarDescricao () {
        return this.descricao;
    }
}
