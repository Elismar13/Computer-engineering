#include <stdio.h>
#include <stdlib.h>
#include "Lista_encadeada.h"

List* criaLista() {
    List* L = (List*) malloc(sizeof(List));
    if(L == NULL) return NULL;

    L->begin = NULL;
    return L;
}

//============================= Inserindo Elementos ===============================
int insereInicio(List* Inicio, int valor) {
    Node* no = (Node*) malloc(sizeof(Node));
    if(no == NULL) return NULL;

    no->v = valor;
    if(Inicio->begin == NULL)  { //Lista esta vazia
        Inicio->begin = no;
        no->Next = NULL;
    }
    else {                      //Lista tiver mais de um elemento elemento
        no->Next = Inicio->begin;
        Inicio->begin = no;
    }
    return 1;
}

int insereQualquerLugar(List* Inicio, int posicao, int valor) {
    Node* newNo = (Node*) malloc(sizeof(Node));
    Node* p;
    if(newNo == NULL) return NULL;

    //Atribuindo o valor ao no criado
    newNo->v = valor;

    //Atribuindo a P o inicio da lista
    p = Inicio->begin;

    for(i = 0; p->Next != NULL; i++) {
        if(i == posicao) {
            newNo->Next = p->Next;
            p->Next = newNo;
            return 1;
        }
    }
    return 0;
}

//============================== Buscando Elementos ===============================
List* buscaSequencial(List* Inicio, int buscado) {
    Node* p = Inicio->Next;
    while(p != NULL) {
        if(p->v == buscado) return p;
    }
    return NULL;
}

//============================= Removendo Elementos ===============================
void removeElemento(List* Inicio, int valorASerRemovido) {
    Node* p;
    p = Inicio->begin;

    while(p != NULL) {
        if(p->Next->v == valorASerRemovido) {
            p->Next = p->Next->Next;
            free(p->Next)
        }
        p = p->Next;
    }

    free(p);
}
