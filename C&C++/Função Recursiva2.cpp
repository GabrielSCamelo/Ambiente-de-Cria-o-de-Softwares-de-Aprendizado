#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include<time.h>
#define quant 10
int recursiva(float vpa[],float R,int i);

int main()
{
	float v1[quant]={1,3,5,7,9,11,13,15,17,19}; //exemplo de PA
	float v2[quant]={1,3,7,9,13,15,17,19,5,11}; //exemplo de NÃO PA
	
	printf("1o vetor:"); //1o exemplo PA
	if(recursiva(v1,0,0)==1)
	{
		printf("e uma PA !!!\n");
	}
	else
	{
		printf("nao e uma PA !!!\n");
	}
	printf("2o vetor:"); //2o exemplo NÃO PA
	if(recursiva(v2,0,0)==1)
	{
		printf("e uma PA !!!\n");
	}
	else
	{
		printf("nao e uma PA !!!\n");
	}
	
}
int recursiva(float vpa[],float R,int i) //a razão não muda , sabendo que A2-A1=R então A3-A2=R E A4-A3 .... AN+1-AN=R
{
	float Q;
	
	if(R==0) //efetuando calculo para saber a razão
	{
	   R=vpa[i+1]-vpa[i];	//razão: a2-a1=R
	   i++;
	   recursiva(vpa,R,i);
	}
	Q=vpa[i+1]-vpa[i]; //verificando se a razão é igual em todos os calculos de todos os termos
		
	if(R!=Q && i+1!=10)	//verificando a razão até o ultimo termo sem pegar o lixo de memoria usando (i+1!=10) caso contrario vai ser Q=lixo memoria-ultimo termo
	{
		return 0; // não é PA
	}
	else
	{
		i++; //contando as repetições para verificar o vetor todo
	if(quant>i) //bloqueio de repetição/limite 
	{
		recursiva(vpa,R,i); //recursividade aplicada salvando a razão e o repetidor
	}
	else
	{
	    return 1;	// é PA
	}	
	}
}
