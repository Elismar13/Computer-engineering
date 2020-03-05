package br.edu.ifpb;

import java.util.Scanner;

public class TestarMenu
{
    public static void main( String[] args )
    {
        Scanner s1 = new Scanner(System.in);

        MenuCalculadora menu = new MenuCalculadora();
        int Opcao;
        double[] numeros = {0,0};
        double resultado = 0.00;

        while(true) {
            menu.exibirMenu();

            Opcao = s1.nextInt();

            //Verificar opção
            if(Opcao < 0 || Opcao > 6) {
                System.out.println("Opção inválida. Digite novamente: ");
                continue;
            }

            if(Opcao <= 4) {
                System.out.print("Digite o primeiro e o segundo numero: ");
                numeros = menu.capturarNumeros();
            }

            switch (Opcao) {
                case 1:
                    resultado = menu.c1.somar( numeros[0], numeros[1] );
                    break;
                case 2:
                    resultado = menu.c1.subtrair( numeros[0], numeros[1] );
                    break;
                case 3:
                    resultado = menu.c1.multiplicar( numeros[0], numeros[1] );
                    break;
                case 4:
                    resultado = menu.c1.dividir( numeros[0], numeros[1] );
                    break;
                case 5:
                    System.out.println("Descrição : " + menu.c1.consultarDescricao());
                    return;
                case 6:
                    return;
            }

            System.out.printf("Resultado: %.2f\n", resultado) ;
        }
    }
}
