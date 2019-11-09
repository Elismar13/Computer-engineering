#include <stdio.h>
#include <stdlib.h>
#include "listaDupla_Encadeada.h"

int main() {
	list* lista = createList();

	add_normal(lista, 10);
	add_normal(lista, 20);
	add_normal(lista, 30);
	add_normal(lista, 40);

	become_circular(lista);

	printCircular(lista);

	removeElementCircular(lista, 30);
	printCircular(lista);

	removeElementCircular(lista, 70);
	printCircular(lista);

	removeElementCircular(lista, 10);
	printCircular(lista);

	removeElementCircular(lista, 20);
	printCircular(lista);

}