#include <stdio.h>
#include <stdlib.h>
#define TAM 15
int matriz(int Mt[TAM][TAM],int l,int c,int i,int t);
void elementmatriz(int Mt[TAM][TAM]);

int main()
{
	int t,i,C,L,Mt [TAM][TAM];
	//exemplo para teste: Mt [TAM][TAM]={1,2,3,4,0,9,2,7,4,6,9,1,2,9,2,3};
	/*
	1 2 3 4
	0 9 2 7
	4 6 9 1
	2 9 2 3
	*/
	
	elementmatriz(Mt);
	
	printf("informe a Linha: ");
	scanf("%d",&L);
	
	printf("informe a coluna: ");
	scanf("%d",&C);
	
	if(matriz(Mt,C-1,L-1,0,TAM-1)==1)
	{
		printf("foi observado a caracteristica na matriz.");
	}
	else
	{
		printf("a caracteristica nao foi observada na matriz.");
	}
	
}
int matriz(int Mt[TAM][TAM],int l,int c,int i,int t)
{
	if(Mt[l][i]==Mt[t][c])
	{
		if(i==TAM)
		{
			matriz(Mt,c,l,i+1,t-1);
		}
		return 1;
	}
	else
	{
		return 0;
	}
}
void elementmatriz(int Mt[TAM][TAM])
{
	int i,t;
	
	printf("\t\tMatriz 15x15:\n\n\t|");
	for(i=0;i<TAM;i++)
	{
		for(t=0;t<TAM;t++)
		{
			Mt[i][t]=rand() % 9;
			printf("%d|",Mt[i][t]);
		}
		if(i!=TAM-1)
		{
			printf("\n\t|");
		}
	}
	printf("\n\n");
}
