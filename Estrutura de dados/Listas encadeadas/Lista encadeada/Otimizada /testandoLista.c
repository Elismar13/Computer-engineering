#include <stdio.h>
#include <stdlib.h>
#include "Lista_encadeada.h"

int main (void) {
    List *lista = createList();
    if(isEmpty) printf("Lista vazia\n");

    add(lista, 10);
    add(lista, 20);
    add(lista, 30);
    add(lista, 40);
    add(lista, 50); 
    printList(lista);

    removeBack(lista);
    printList(lista);
    printf("Tamanho: %d\n\n", size(lista)); 

    removeBack(lista);
    printList(lista);
    printf("Tamanho: %d\n\n", size(lista)); 

    add(lista, 60);
    printList(lista);
    printf("Tamanho: %d\n\n", size(lista)); 

    removeBack(lista);
    printList(lista);
    printf("Tamanho: %d\n\n", size(lista)); 

    printList(lista);
    printf("Tamanho: %d\n\n", size(lista)); 
    removeBack(lista);

    printList(lista);
    printf("Tamanho: %d\n\n", size(lista)); 

    removeBack(lista);

    printList(lista);
    if(isEmpty(lista)) printf("Lista vazia\n");
    printf("Tamanho: %d\n\n", size(lista)); 
    return 0;
}

