#include <stdio.h>
#include <stdlib.h>

struct node
{
	int data;
	struct node *next;
	struct node *bef;
};
typedef struct node node;

typedef struct {
	node* begin;
	node* end;
} list;

//=============== Funções ===============
list* createList();

void add_normal(list* l, int v);

void become_circular(list* l);

void printCircular(list *l);

void removeElementCircular(list* l, int v);
