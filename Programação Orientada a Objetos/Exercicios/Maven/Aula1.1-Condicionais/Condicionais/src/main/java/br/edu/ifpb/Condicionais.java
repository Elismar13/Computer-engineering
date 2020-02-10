package br.edu.ifpb;

import java.util.Scanner;

public class Condicionais 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);

        int n1, n2;

        System.out.println("======== Welcome ========");

        System.out.print("Enter the first number: ");
        n1 = input.nextInt();

        System.out.print("Enter the secound number: ");
        n2 = input.nextInt();

        if(n1 == n2) System.out.printf("%d == %d\n", n1, n2);
        if(n1 != n2) System.out.printf("%d != %d\n", n1, n2);
        if(n1 < n2) System.out.printf("%d < %d\n", n1, n2);
        if(n1 > n2) System.out.printf("%d > %d\n", n1, n2);
        if(n1 <= n2) System.out.printf("%d <= %d\n", n1, n2);
        if(n1 >= n2) System.out.printf("%d >= %d\n", n1, n2);
    }
}
