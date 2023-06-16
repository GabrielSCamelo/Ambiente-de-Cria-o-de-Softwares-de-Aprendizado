#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include<time.h>
#define TAM 4

//funções:
int inversaolinhamatriz(int Mtz1[TAM][TAM],int l1,int l2,int i,int t);
void elementmatriz(int Mtz1[TAM][TAM]);
void visualizar(int Mtz1[TAM][TAM]);
int validade(int Mtz1[TAM][TAM],int l1,int l2);

int main()
{
	int l1,l2,Mtz1[TAM][TAM]={4,5,1,3,9,7,8,1,0,2,9,4,4,7,2,8};
	//exemplo para teste: Mt [TAM][TAM]={1,2,3,4,0,9,2,7,4,6,9,1,2,9,2,3};
	/*
	1 2 3 4      1 2 3 4
	0 9 2 7  ->  3 2 9 2
	4 6 9 1      1 9 6 4
	2 9 2 3      7 2 9 0
	*/
	elementmatriz(Mtz1);
	
	printf("digite a linha de inicio de inversao: ");
	scanf("%d",&l1);
	
	printf("digite a linha de final de inversao: ");
	scanf("%d",&l2);
	
		if(validade(Mtz1,l1,l2)==1)
		{
			inversaolinhamatriz(Mtz1,l1-1,l2-1,0,TAM-1);
			visualizar(Mtz1);
			printf("\n\tta funcionando!\n");
		}
		else
		{
			visualizar(Mtz1);
			printf("\n\tnao ta funcionando!\n");
		}
}
int inversaolinhamatriz(int Mtz1[TAM][TAM],int l1,int l2,int i,int t)
{
	int temp1,temp2;
	
	if(i!=TAM-2 && t!=i)
	{
	temp1=Mtz1[l1][t];
	temp2=Mtz1[l1][i];
	Mtz1[l1][i]=Mtz1[l2][t];
	Mtz1[l1][t]=Mtz1[l2][i];
	Mtz1[l2][i]=temp2;
	Mtz1[l2][t]=temp1;
	
	return inversaolinhamatriz(Mtz1,l1,l2,i+1,t-1);
	}
	else
	{
		if(t==i) //para no caso do tamanho do vetor ser impar
		{
		temp1=Mtz1[l1][t];
		Mtz1[l1][i]=Mtz1[l2][i];
		Mtz1[l2][i]=temp1;
		}
	}
}
void elementmatriz(int Mtz1[TAM][TAM]) //usada para preencher e visualizar o vetor antes e depois da alteração
{
	int i,t;
	
	//srand(time(NULL)); caso deseja valores aleatorios retirar o (//)
	printf("\n\t|");
	for(i=0;i<TAM;i++)
	{
		for(t=0;t<TAM;t++)
		{
			//Mt[i][t]=rand() % 10; (mesma coisa)
			printf("%d|",Mtz1[i][t]);
		}
		if(i!=TAM-1)
		{
			printf("\n\t|");
		}
	}
	printf("\n\n");
}
void visualizar(int Mtz1[TAM][TAM])
{
	int i,t;
	
	printf("\n\t|");
	for(i=0;i<TAM;i++)
	{
		for(t=0;t<TAM;t++)
		{
			printf("%d|",Mtz1[i][t]);
		}
		if(i!=TAM-1)
		{
			printf("\n\t|");
		}
	}
	printf("\n\n");
}
int validade(int Mtz1[TAM][TAM],int l1,int l2)
{
	if(l1!=l2 && TAM>=l1 && TAM>=l2 && 0<l1 && 0<l2 )
	{
		return 1;
	}
	else
	{
		return 0;
	}
}
