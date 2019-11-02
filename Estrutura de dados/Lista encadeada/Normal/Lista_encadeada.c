#include <stdio.h>
#include <stdlib.h>
#include "Lista_encadeada.h"

List* createList() {
    List* L = (List*) malloc(sizeof(List));
    if(L == NULL) return NULL;

    L->begin = NULL;
    return L;
}

void add(List* l, int valor) {
    Node* no = (Node*) malloc(sizeof(Node));
    Node *a, *p;

    no->v = valor;
    if(l->begin == NULL)  {     //Lista esta vazia
        l->begin = no;
        no->Next = NULL;
    }

    else {                      //Lista tiver mais de um elemento elemento
        p = l->begin;
        a = p;
        while(p != NULL) {
            a = p;
            p = p->Next;
        }
        a->Next = no;
        no->Next = NULL;
    }
}

void printList(List* l) {
    Node* p = l->begin;
    if(p != NULL) {
        do {
            printf("%d ", p->v);
            p = p->Next;
        } while(p != NULL);
        printf("\n");
    }
}

int isEmpty(List* l){
    return (l->begin == NULL);
}

void removeBack(List* l) {
    Node *p, *a; 
    p = l->begin;
    a = p;
    
    //Se eu quiser remover o ultimo elemento
    if(p->Next == NULL) {
        l->begin = NULL;
        return;
    }

    while(p->Next != NULL) {
        a = p;
        p = p->Next;
    }
    a->Next = NULL;
    free(p);
}

int size(List* l) {
    Node* p = l->begin;
    int length = 0;
    
    //printf("%p\n", l->begin); 
    if(l->begin == NULL) return 0;

    while(p != NULL) {
        p = p->Next;
        length++;
    }
    return length;
    
}

