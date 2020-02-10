package br.edu.ifpb;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        //cria um Scanner para obter entrada a partir da janela de comando
        Scanner input = new Scanner(System.in);

        int Number1;
        int Number2;
        int sum;

        System.out.print("Enter first input number: ");
        Number1 = input.nextInt();
        
        System.out.print("Enter second input number: ");
        Number2 = input.nextInt();

        sum = Number1 + Number2;
        System.out.printf("Sum is %d\n", sum);
        
    }
}
