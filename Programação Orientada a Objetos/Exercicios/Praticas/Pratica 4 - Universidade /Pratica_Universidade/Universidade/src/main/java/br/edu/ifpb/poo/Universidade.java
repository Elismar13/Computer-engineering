package br.edu.ifpb.poo;

import java.util.ArrayList;

public class Universidade {
    private ArrayList<Empregado> listaEmpregados;
    private String nome;

    public Universidade() {
        this("---");
    }

    public Universidade(String nome) {
        setNome(nome);
        listaEmpregados = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty())
            this.nome = nome;
    }

    public boolean adicionaEmpregado( Empregado empregado ) {
        for(Empregado e1 : listaEmpregados)
            if(e1.getMatricula() == empregado.getMatricula()) return false;

        return listaEmpregados.add( empregado );
    }

    public boolean removeEmpregado( int matricula ) {
        for(Empregado e1 : listaEmpregados)
            if(e1.getMatricula() == matricula) {
                listaEmpregados.remove( e1 );
                return true;
            }

        return false;
    }

    public Empregado buscaEmpregado( int matricula ) {
        for(Empregado e1 : listaEmpregados)
            if(e1.getMatricula() == matricula) return e1;

        return null;
    }

    public String listaTodosEmpregados() {
        String empregados = "";
        for(Empregado empregado : listaEmpregados)
            empregados += empregado.toString() + '\n';

        return empregados;
    }
}
