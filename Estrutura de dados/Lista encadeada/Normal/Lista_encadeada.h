#include <stdio.h>
#include <stdlib.h>

struct Node {
    struct Node* Next;
    int v;
};
typedef struct Node Node;

typedef struct {
    Node* begin;
} List;

List* createList();

void add(List* l, int valor);  //Adição no fim

void printList(List* l);

int isEmpty(List* l);

void removeBack(List* l);   //Remoção fim

int size(List* l);


