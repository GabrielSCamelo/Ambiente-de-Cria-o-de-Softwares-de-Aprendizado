//importação de bibliotecas
#include <stdio.h>
#include <stdlib.h>

typedef struct No {
	int valor;	
	struct No* prox;
} TNo;

typedef TNo* TLista;

int inserir (TLista *L, int numero);
void exibir (TLista L);
void copiar(TLista L1,TLista *L2);

int main()
{
	TLista L1=NULL,L2=NULL;
	
	inserir(&L1,9);
	inserir(&L1,8);
	inserir(&L1,7);
	inserir(&L1,6);
	inserir(&L1,5);
	inserir(&L1,4);
	inserir(&L1,3);
	inserir(&L1,2);
	inserir(&L1,1);
	
	exibir(L1);
	exibir(L2);
	copiar(L1,&L2);
	exibir(L1);
	exibir(L2);
}

int inserir (TLista *L, int numero)
{
	//Declaração de variáveis
	TLista aux;
	
	aux = (TLista) malloc (sizeof(TNo));

	if (aux == NULL)
	{
		return NULL;
	}
	else
	{
		aux->valor = numero;
		
		aux->prox = *L;
		
		*L = aux;
		
	}
}
void exibir (TLista L)
{
	//declaração de variáveis
	TLista aux;
	
	//testando se a lista está vazia
	if (L == NULL)   //if (!L)
	{
		printf ("\nLista Vazia!\n\n");
	}
	else
	{
		printf ("\nLista: ");
		
		aux = L;
		
		while (aux != NULL) 
		{
			printf ("%d ", aux->valor);
			
			aux = aux->prox;
		}	
	}
}
void copiar(TLista L1,TLista *L2)
{
	TLista aux;
	aux = L1;
	
	while(aux!=NULL)
	{
		inserir(&*L2,aux->valor);
		aux=aux->prox;
	}
}
