#include <stdio.h>
#include <stdlib.h>
#include<time.h>

#define TRUE 1
#define FALSE 0
//definição de tipos
typedef struct No {
	int valor;
	struct No* prox;
} TNo;

typedef TNo* TLista;

int inserir (TLista *L, int numero);
void exibir (TLista L);
void multiplo(TLista *L,int numero,int quantidade);


int main()
{
	TLista L1=NULL;
	int numero,quantidade;
	
	printf("informe um numero para colocar seus multiplos na Lista encadeada: ");
	scanf("%d",&numero);
	
	printf("informe quantos primeiros multiplos deseja na lista: ");
	scanf("%d",&quantidade);
	
	multiplo(&L1,numero,quantidade);
	exibir(L1);
}

void multiplo(TLista *L,int numb,int quant)
{
	int i;
	
	for(i=0;i<quant;i++)
	{
		inserir(&*L,(i*numb));
	}
}
void exibir (TLista L)
{
    TLista aux;

    if (L == NULL)   //if (!L)
	{
		printf ("\n\nLista Vazia!\n");
	}
	else
	{
		printf ("\nLista: ");
		
		//inicializando 'aux' de forma que aponte para o primeiro nó da lista
		aux = L;
		
		//percorrendo todos os nós da lista
		while (aux != NULL) //while (aux) 
		{
			//exibindo o valor apontado pelo 'aux'
			printf ("%d ", aux->valor);
			
			//andar com o 'aux' de forma que ele aponte para o próximo nó
			aux = aux->prox;
		}		
	}
}

int inserir (TLista *L, int numero)
{
	//Declaração de variáveis
	TLista aux;
	
	//Passo1: alocar memória para o novo elemento
	aux = (TLista) malloc (sizeof(TNo));

	//verificando se a memória solicitada não foi alocada
	if (aux == NULL)
	{
		return FALSE;
	}
	else
	{
		//Passo2: armazenar o novo valor na memória recém alocada
		aux->valor = numero;
		
		//Passo3: fazer o novo nó apontar para o nó que, até então, era o primeiro da lista.
		aux->prox = *L;
		
		//Passo4: fazer com que o L aponte para o novo elemento
		*L = aux;
		
		return TRUE;
	}

}
