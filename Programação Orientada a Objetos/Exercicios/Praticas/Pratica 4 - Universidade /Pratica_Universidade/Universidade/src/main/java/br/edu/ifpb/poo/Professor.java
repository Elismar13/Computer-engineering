package br.edu.ifpb.poo;

public class Professor extends Empregado {
    private int numeroHoras;
    final double quantiaPorHora = 200;

    public Professor() {
        this(0, "---", "---", 0, 4);
    }

    public Professor(int matricula, String endereco, String nome, double salario, int numeroHoras) {
        super(matricula, endereco, nome, salario);
        this.setNumeroHoras(numeroHoras);
    }


    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        if(numeroHoras > 4)
            this.numeroHoras = numeroHoras;
        else
            this.numeroHoras = 4;
    }

    public double getSalario() {
        return this.salarioBase * (this.quantiaPorHora * this.numeroHoras);
    }

    @Override
    public String toString() {
        return "Professor: " + super.toString() + "numeroHoras=" + numeroHoras;
    }
}
