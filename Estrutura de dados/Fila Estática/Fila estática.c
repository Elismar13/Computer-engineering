#include <stdio.h>
#include <stdlib.h>

#define max 10

typedef struct {
    int n;
    int inicio;
    int vetor[max];
} fila;

fila* criaFila() {
    fila *f = (fila*) malloc(sizeof(fila));
    f->n = 0;
    f->inicio = 0;
    return f;
}

int insereFila (fila *f, int valor) {
    int fim = 0;
    if(f->n < max) {
        fim = (f->inicio + f->n)%max;
        printf("\nTamanho final: %d", fim);
        f->vet[fim] = v;
        f->n++;
        return 1;
    }
    return 0;
}

int remover(fila *f) {
    int retirado;
    if(f->n > 0) {
        ret = f->vetor[f->inicio];
        f->inicio = ((f->inicio)+1)%max;
        f->n--;
    }
    return retirado;
}

int size(fila *p) {
    return f->n;
}

int is_empty(file *f) {
    return f->n == max;
}

void printa(fila *p) {

}
int main (void) {
    fila *p = criaFila();


    return 0;
}
