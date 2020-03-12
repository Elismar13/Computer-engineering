package br.edu.ifpb;

public class Funcionario {
    int matricula;
    String nome;
    int idade;
    double salarioBase;

    public Funcionario() {
        this (0, "--- Sem Nome --", 0, 990.99);
    }

    public Funcionario(int matricula, String nome, int idade, double salarioBase) {
        setMatricula(matricula);
        setNome(nome);
        setIdade(idade);
        setSalarioBase(salarioBase);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if(matricula > 0)
            this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0)
            this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade > 0)
            this.idade = idade;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if(salarioBase <= 990.99)
            this.salarioBase = 990.99;
        else
            this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return
                "matricula= " + getMatricula() +
                ", nome= " + getNome() +
                ", idade=" + getIdade() +
                ", salarioBase=" + getSalarioBase();
    }
}
