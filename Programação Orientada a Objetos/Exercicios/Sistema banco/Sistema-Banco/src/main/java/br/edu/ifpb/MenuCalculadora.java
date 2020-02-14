package br.edu.ifpb;

import java.util.Scanner;

public class MenuCalculadora {

    public void exibirMenu() {

    }

    public double[] capturarNumeros () {
        Scanner s1 = new Scanner();
        double [] numeros = new double[2];

        numeros[0] = s1.nextDouble();
        numeros[1] = s1.nextDouble();

        return numeros;
    }
}
