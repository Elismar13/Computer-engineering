#include <stdio.h>
#include <stdlib.h>

/* A modificação que decidi fazer foi adicionar um contador na minha lista para quando eu adicionar ou remover algum elemento este atributo mudar conforme a ação escolhida. */

struct Node {
    struct Node* Next;
    int v;
};
typedef struct Node Node;

typedef struct {
    Node* begin;
    int contador;
} List;

List* createList();

void add(List* l, int valor);  //Adição no fim

void printList(List* l);

int isEmpty(List* l);

void removeBack(List* l);   //Remoção fim

int size(List* l);


