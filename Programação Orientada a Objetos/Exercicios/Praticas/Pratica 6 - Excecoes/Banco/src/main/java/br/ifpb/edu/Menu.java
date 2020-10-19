package br.ifpb.edu;

public class Menu {
    public static void exibirMenu() {
        System.out.println("Projeto Banco");
        System.out.println(contorno());
        System.out.println(opcao(1, "Criar uma conta"));
        System.out.println(opcao(2, "Deposito"));
        System.out.println(opcao(3, "Saque"));
        System.out.println(opcao(4, "Extrato"));
        System.out.println(opcao(5, "Saldo atual"));
        System.out.println(contorno());
    }

    private static String contorno() {
        String buffer = "";
        for(int i = 0; i < 30; i++) buffer += "*";
        return buffer;
    }

    private static String opcao(int numero, String texto) {
        return String.format("*\t%d.  %-18s \t*", numero, texto);
    }
}
