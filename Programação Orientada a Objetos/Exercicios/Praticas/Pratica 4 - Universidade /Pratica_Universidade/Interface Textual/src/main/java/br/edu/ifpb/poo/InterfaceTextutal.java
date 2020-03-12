package br.edu.ifpb.poo;

import br.edu.ifpb.poo.*;

public class InterfaceTextutal {
    public static void main(String[] args) {
        Universidade IFPB = new Universidade("Rua São Joao");

    //Criando professores
    Empregado e1 = new Professor( 022, "Rua Joaquim Ala", "Vinicius", 500, 10 );
    Empregado e2 = new Professor( 555, "Rua Seu Gago", "Bruno", 900, 8 );
    Empregado e3 = new Professor();

    IFPB.adicionaEmpregado( e1 );
    IFPB.adicionaEmpregado( e2 );
    IFPB.adicionaEmpregado( e3 );

    IFPB.buscaEmpregado( 022 ).toString();

    System.out.println("Lista anterior: " + '\n' + IFPB.listaTodosEmpregados());

    IFPB.removeEmpregado(0);

    System.out.println("Lista posterior: " + '\n' + IFPB.listaTodosEmpregados());
    }
}
