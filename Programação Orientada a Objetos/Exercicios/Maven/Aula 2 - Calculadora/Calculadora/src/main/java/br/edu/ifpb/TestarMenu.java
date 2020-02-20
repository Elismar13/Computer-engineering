package br.edu.ifpb;

import java.util.Scanner;

public class TestarMenu
{
    public static void main( String[] args )
    {
        Scanner s1 = new Scanner(System.in);

        MenuCalculadora menu = new MenuCalculadora();
        int Opcao;
        double[] numeros;
        double resultado;

        menu.exibirMenu();

        Opcao = s1.nextInt();

        numeros = menu.capturarNumeros();


        switch (Opcao) {
            case 1:
                resultado = menu.c1.somar( numeros[0], numeros[1] );
                break;
            case 2:
                resultado = menu.c1.somar( numeros[0], numeros[1] );
                break;
            case 3:
                resultado = menu.c1.somar( numeros[0], numeros[1] );
                break;
            case 4:
                resultado = menu.c1.somar( numeros[0], numeros[1] );
                break;
            case 5:
                resultado = menu.c1.somar( numeros[0], numeros[1] );
                break;
            case 6:
                resultado = menu.c1.somar( numeros[0], numeros[1] );
                break;

        }
    }
}
