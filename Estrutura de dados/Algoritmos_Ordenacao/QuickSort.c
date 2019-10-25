/* ELISMAR SILVA PEREIRA */

#include <stdio.h>
#include <stdlib.h>

int Partition(int v[], int i, int f) {
	int d = i-1, p, j, aux;
	p = v[f];

	for(j = i; j < f-1; j++) {
		if(v[j]	<= p) {
			d++;
			aux = v[d];
			v[d] = v[j];
			v[j] = aux;
		}	
	}
	aux = v[d];
	v[d] = v[f];
	v[f] = aux;

	return d;
}

void QuickSort (int vetor[], int i, int f) {
	if(f>i) {
		int p = Partition(vetor, i, f);
		QuickSort(vetor, i, p-1);
		QuickSort(vetor, p+1, f);
	}
}

int main (void) {
	int vetor [10] = {10, 10, 20, 50, 40, 60, 80, 90, 100, 30};
	
	printf("Vetor inicial: ");
	for(int i = 0; i < 10; i++) {
		printf("%.d ", vetor[i]);
	}	
	QuickSort(vetor, 0, 9);
	printf("\nVetor final: ");
	for(int i = 0; i < 10; i++) {
	printf("%.d ", vetor[i]);
	}
	return 0;
}	
	
