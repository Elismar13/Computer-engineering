#include <stdio.h>
#include <stdlib.h>
#include "listaDupla_Encadeada.h"


list* createList() {
	list* l = (list*)malloc(sizeof(list));
	if(l == NULL) return NULL;

	l->begin = NULL;
	l->end = NULL;
	return l;
} 

void add_normal(list* l, int v) {
	node* no = (node*)malloc(sizeof(node));
	no->data = v;

	if(l->begin == NULL || l->end == NULL) {	//Se estiver vazia
		l->begin = no;
		l->end = no;
		no->bef = NULL;
		no->next = NULL;
	}
	else {		//Se nao
		l->end->next = no;
		no->bef = l->end;
		l->end = no;
		no->next = NULL;
	}
}

void become_circular(list* l) {
	if(l->begin != NULL && l->end != NULL && l->begin->bef == NULL && l->end->next == NULL) {
		l->begin->bef = l->end;
		l->end->next = l->begin;
	}
}

void printCircular(list *l) {
	node *p;
	p = l->begin;
	if(p != NULL) {
		do {
			printf("%d ", p->data);
			p = p->next;
		} while(p != l->begin && p != NULL);
	}
	printf("\n");
}

void removeElementCircular(list* l, int v) {
	node* p, *a;
	p = a = l->begin;

	do {
		if(p->data == v) {
			if(p == l->end && p == l->begin) {
				l->begin = l->end = NULL;
			}
			else if(p == l->begin) {
				l->begin = l->begin->next;
				l->begin->bef = l->end;
				l->end->next = l->begin;
			}	
			else if (p == l->end) {
				l->end = l->end->bef;
				l->end->next = l->begin;
				l->begin->bef = l->end;
			}			
			a->next = p->next;
			p->next->bef = a;
			free(p);	
		}
		a = p;
		p = p->next;
	} while(p != l->begin && p != NULL);
}
