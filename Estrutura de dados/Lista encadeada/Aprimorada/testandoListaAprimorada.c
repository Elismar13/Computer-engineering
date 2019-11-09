#include <stdio.h>
#include <stdlib.h>
#include "Lista_encadeada.h"

int main (void) {
    List *lista = createList();
    insertPosition(lista, 50, 0);
    printList(lista);
    insertPosition(lista, 40, 0);
    printList(lista);
    insertPosition(lista, 30, 0);
    printList(lista);
    insertPosition(lista, 20, 0);
    printList(lista);
    insertPosition(lista, 10, 0);
    printList(lista);

    if(insertPosition(lista, 100, -1)) printf("Falha ao inserir na posicao -1\n");
    printList(lista);
    if(insertPosition(lista, 100, 6)) printf("Falha ao inserir na posicao 6\n");
    printList(lista);

    printf("O elemento 40 esta na posicao %d\n", hasElement(lista, 40));
    printf("O elemento 60 esta na posicao %d\n", hasElement(lista, 60));

    printf("Removendo\n\n");
    removePosition(lista, 2);
    printList(lista);
    removePosition(lista, 6);
    printList(lista);
    removePosition(lista, 0);
    printList(lista);

    removeElement(lista, 40);
    printList(lista);
    removeElement(lista, 60);
    printList(lista);

    int valor;
    get(lista, 1, &valor);
    printf("Pegando o elemento da posicao 1: %d\n", valor);

    get(lista, 3, &valor);
    printf("Pegando o elemento da posicao 3: %d", valor);
}

