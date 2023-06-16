//importação de bibliotecas
#include <stdio.h>
#include <stdlib.h>

//Varivaveis constantes
#define FALSE 0
#define TRUE 1

//definição de tipos
typedef struct No {
	int valor;	
	struct No* prox;
} TNo;

typedef TNo* TLista;

//protótipos das funções
int inserirp (TLista *L, int numero,int position);
int inserir (TLista *L, int numero);
void exibir (TLista L);

int main()
{
	TLista L1 = NULL;
	int p,num;
	
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
	printf("\n\ninforme o numero que deseja colocar na lista: ");
	scanf("%d",&num);
	
	printf("\ninforme a posicao que deseja inserir esse numero na lista: ");
	scanf("%d",&p);
	
	if(inserirp(&L1,num,p-1)!=NULL)
	{
		printf("\n\no Numero %d foi inserido na lista Encadeada: ",num);
		exibir(L1);
	}
	else
	{
		printf("\nERRO:Posicao Invalida!");
	}
}

int inserirp (TLista *L, int numero,int position)
{
	//Declaração de variáveis
	TLista aux1,aux2;
	int cont=0;
	
	//Passo1: alocar memória para o novo elemento
	aux2 = (TLista) malloc (sizeof(TNo));

	//verificando se a memória solicitada não foi alocada
	if (aux2 == NULL)
	{
		return NULL;
	}
	else
	{	
		if(position==0)
		{
			inserir(&*L,numero);
			return TRUE;
		}
		
		aux1=*L;
		
		while( aux1!=NULL && cont!=position)
		{
			cont++;
			if(cont!=position)
			{
				aux1=aux1->prox;
			}
			
		}
		if(cont!=position)
		{
			return FALSE;
		}
	
		aux2->valor = numero;
		
		aux2->prox = aux1->prox;
		
		aux1->prox = aux2;
		
		return TRUE;
	}
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
