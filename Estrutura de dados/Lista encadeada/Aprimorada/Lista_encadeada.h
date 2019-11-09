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


//OPERACOES ESPECIAIS
int hasElement(List* l, int v);

int insertPosition(List *l, int v, int pos);

int removePosition(List *l, int pos);

int removeElement(List *l, int v);

int get(List *l, int pos, int *valor); 
