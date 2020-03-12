package br.edu.ifpb.poo;

public class Empregado {
    int matricula;
    String endereco;
    String nome;
    double salarioBase;

    Empregado() {
        this( 0, "---", "---", 0.00 );
    }
    Empregado(int matricula, String endereco, String nome, double salario) {
        this.setMatricula(matricula);
        this.setEndereco(endereco);
        this.setNome(nome);
        this.setSalarioBase(salario);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if(matricula > 0)
            this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(!endereco.isEmpty())
            this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty())
            this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if(salarioBase >= 0.00)
            this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "matricula=" + matricula +
                ", endereco='" + endereco +
                ", nome='" + nome +
                ", salarioBase=" + salarioBase;
    }
}
