package br.edu.ifpb;

public class Professor extends Funcionario{
    private int numHoras;

    Professor() {
        this(0, "--- sem nome ---", 10, 999.88, 4);
    }

    public Professor(int matricula, String nome, int idade, double salarioBase, int numHoras) {
        super(matricula, nome, idade, salarioBase);
        setNumHoras( numHoras );
    }

    public double getSalario() {
        return this.salarioBase * 1.3;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        if(numHoras > 4)
            this.numHoras = numHoras;
        else
            this.numHoras = 4;
    }

    @Override
    public String toString() {
        return super.toString()
        + ", numero de horas= " + getNumHoras();
    }
}
