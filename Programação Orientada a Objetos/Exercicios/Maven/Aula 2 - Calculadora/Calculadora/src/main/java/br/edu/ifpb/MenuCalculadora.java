package br.edu.ifpb;

import java.util.Scanner;   //Uso o Scanner do java

public class MenuCalculadora {
    //Variáveis de instancia
    public Calculadora c1 = new Calculadora();

    //Métodos
    void exibirMenu() {
        System.out.println("Calculadora");
        System.out.println("=============");
        System.out.println("\t1. Somar");
        System.out.println("\t2. Subtrair");
        System.out.println("\t3. Multiplicar");
        System.out.println("\t4. Dividir");
        System.out.println("\t5. Sobre a calculadora");
        System.out.println("\t6. Sair");
        System.out.print("\tDigite uma opção: ");
    }

    public double[] capturarNumeros() {
        Scanner s1 = new Scanner(System.in);

        double n1 = s1.nextDouble();
        double n2 = s1.nextDouble();

        double[] numeros = new double[] {n1, n2};

        return numeros;
    }
}
