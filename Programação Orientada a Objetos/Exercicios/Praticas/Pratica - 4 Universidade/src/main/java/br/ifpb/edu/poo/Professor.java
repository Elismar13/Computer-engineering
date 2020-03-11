package br.ifpb.edu.poo;

public class Professor extends Empregado {
    private int matricula;
    private int idade;
    private String endereco;
    private String nome;
    private int numeroHoras;
    private double salario;

    public Professor() {

    }
    public Professor( int matricula, int idade, String endereco, String nome, int numeroHoras, double salario ) {
        setMatricula( matricula );
        setIdade( idade );
        setEndereco( endereco );
        setNome( nome );
        setNumeroHoras( numeroHoras );
        setSalario( salario );
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if(matricula > 0)
            this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        //Professor com mais de 16 anos
        if(idade > 10)
            this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco.length() > 0)
            this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty())
            this.nome = nome;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        if(numeroHoras > 0)
            this.numeroHoras = numeroHoras;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double gratificacao) {
        if(gratificacao >= 0)
            this.salario = this.salarioBase + gratificacao * getNumeroHoras();
    }
}
