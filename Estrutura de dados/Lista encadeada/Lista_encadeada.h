#include <stdio.h>
#include <stdlib.h>

typedef struct {
    Node* begin;
} List;

typedef struct {
    Node* Next;
    int16_t v;
} Node;

List* criaLista();

int insereInicio(List* Inicio, int valor);

int insereQualquerLugar(List* Inicio, int posicao, int valor);

List* buscaSequencial(List* Inicio, int buscado);

void removeElemento(List Inicio, int valorASerRemovido);
