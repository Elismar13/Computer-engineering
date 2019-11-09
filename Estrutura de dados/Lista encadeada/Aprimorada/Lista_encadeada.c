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


//OPERACOES ESPECIAIS
int hasElement(List* l, int v) {
    int pos = 0;
    Node *p = l->begin;
    while(p != NULL) {
        if(p->v == v) return pos;
        pos++;
        p = p->Next;
    }
    return -1;
}

int insertPosition(List *l, int v, int pos) {
    Node *no = (Node*) malloc(sizeof(Node));
    Node *p, *a;
    int count = 0;
    no->v = v;    
    p = a = l->begin;

    if(pos >= 0) {
        if(pos == 0) {
            if(l->begin == NULL) {
                l->begin = no;
                no->Next = NULL; 
            }
            else {
                l->begin = no;
                no->Next = p;
            }
        }
        else {
            while(p != NULL) {
                if(count == pos) {
                    no->Next = p;
                    a->Next = no;
                    return 0;
                }
                a = p;
                p = p->Next;
                count++;
            }
        }
    }
    return -1;
}

int removePosition(List *l, int pos) {
    Node *p, *a;
    a = p = l->begin;
    int count = 0;

    if(pos >= 0 && l->begin != NULL) {
        if(pos == 0) {
            l->begin = p->Next;
        }
        else {
            while(p != NULL) {
                if(count == pos) {
                     a->Next = p->Next;
                }         
                a = p;
                p = p->Next;
                count++;
            }
            free(p);
            return 0;
        }
    }
    return -1;
}

int removeElement(List *l, int v) {
    Node *a, *p;
    a = p = l->begin;
    int count = 0;
    
    if(l->begin != NULL) {
        while(p != NULL) {
            if(p->v == v) {
                a->Next = p->Next;
                free(p);
                return count;
            }
            a = p;
            p = p->Next;
            count++;
        }
    }
    return -1;
}

int get(List *l, int pos, int *valor) {
    Node *p;
    p = l->begin;
    int count = 0;
    
    if(pos >= 0 && l->begin != NULL) {
        if(pos == 0) {
            valor = &(l->begin->v);
        }
        else {
            while(p != NULL) {
                if(count == pos) {
                    valor = &(p->v);
                    return 0;            
                }
                p = p->Next;
                count++;
            }
        }
    }
    return -1;
}

