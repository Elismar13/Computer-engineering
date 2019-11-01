#include <stdio.h>
#include <stdlib.h>

#define max 10

typedef struct {
    int n;
    int lista[max];
} Lista;

Lista* criaLista(int size) {
    Lista* l = (Lista*) malloc(sizeof(Lista));
    l->lista = (int*)malloc(size*sizeof(int));
    Lista->n = 0;
    return l;
}

int insert_end (Lista* l, int v) {
    if(Lista->n < max) {
        Lista->lista[Lista->n++] = v;
        return v;
    }
    return 0;
}

int remove_end (Lista* l) {
    if(l->n > 0) {
        l->n--;
        return l->[n];
    }
    return 0;
}

int insert_pos(Lista* l, int pos, int v) {
    if(pos => 0 && pos <= l->n && l->n < max) {
        int k, aux;
        for(k = pos; k <= l->n; k++) {
            l->lista[k+1] = l->lista[k];
        }
        l->lista[pos] = v;
        l->n++;
        return 1;
    }
    return 0;
}

int remove_pos(Lista* l, int pos) {
    int a;
    if(pos >= 0 && pos <= l->n && pos < max) {
        for(a = l->n; a > pos; a--) {
            l->lista[a-1] = lista[a];
        }
        l->n--;
        return 1;
    }
    return 0;
}

int size(Lista* l) {
    return l->n;
}

int isEmpty() {
    return l->n == 0;
}

int main() {

}
