//importa��o de bibliotecas
#include <stdio.h>
#include <stdlib.h>   //malloc

//constantes
#define TRUE 1
#define FALSE 0

//defini��o de tipos
typedef struct No {
	int valor;	
	struct No* prox;
} TNo;

typedef TNo* TLista;

//prot�tipos das fun��es
int inserir (TLista *L, int numero);
int remover (TLista *L, int numero);
int removerporposition (TLista *L,int Position);
int alterar (TLista L, int velho, int novo);
void exibir (TLista L);
TLista buscar (TLista L, int numero);
int integridade(TLista L,int numero);
int menu ();

//main
int main ()
{
	//declara��o de vari�veis
	TLista aux,L1 = NULL;		//lista inicialmente vazia
	int opcao, num1, num2;
	int *p1;
	
	do
	{
		//exibindo o menu ao usu�rio
		opcao = menu ();
		
		switch (opcao)
		{
			//inser��o
			case 1: 
				    printf ("Entre com o numero a ser inserido: ");
			        scanf ("%d", &num1);
			        if(integridade(L1,num1)!=1 && num1>0)
			        {	
			        if (inserir (&L1, num1) != NULL) //ou apenas inserir (&L1, num1)
			        {
			        	printf ("O numero %d foi inserido na lista!\n", num1);
					}
					else
					{
						printf ("ERRO: o numero %d nao foi inserido na lista!\n", num1);
					}
				    }
					else
					{
						if(num1>0)
						{
							printf ("ERRO: o numero %d Ja existe na lista!\n", num1);
						}
						else
						{
							printf("ERRO: o numero %d nao e positivo!\n",num1);
						}
					}
					break;
				
			//remo��o
			case 2: printf ("Entre com o n�mero a ser removido: ");
			        scanf ("%d", &num1);
			        
			        if (remover (&L1, num1)!= 0)
			        {
			        	printf ("o numero %d foi removida da lista!\n", num1);
					}
					else
					{
						printf ("ERRO: o numero %d n�o encontra-se na lista!\n", num1);
					}
					break;
					
			case 3:printf ("Entre com a posicao que deseja que remover da lista: ");
			        scanf ("%d", &num1);
			        
			        
			        if(removerporposition(&L1,num1) != NULL)
			        {
			        	printf ("o numero na posicao (%d) foi removido da Lista! \n", num1);
					}
					else
					{
						printf ("ERRO: Esta posicao (%d) nao existe na lista!\n", num1);
					}
					break; 
				
			//alterar
			case 4: printf ("Entre com o n�mero a ser alterado: ");
			        scanf ("%d", &num1);
			        
				    printf ("Entre com o novo elemento: ");
			        scanf ("%d", &num2);
			            
			        if(integridade(L1,num2)==1 && num2>0)
			        {
			        	if(num2>0)
						{
							printf ("ERRO: o numero %d Ja existe na lista!\n", num2);
						}
						else
						{
			        	    printf ("ERRO: o numero %d n�o e positivo!\n", num2);
			            }
					}
					else
					{
			        if (alterar (L1, num1, num2) != 0)
			        {
			        	printf ("o numero %d foi alterado por %d!\n",num1, num2);
					}
					else
					{
							printf ("ERRO: o numero %d n�o encontra-se na lista!\n", num1);
					}
					}
					break;
				
			//pesquisar
			case 5: printf ("Entre com o n�mero a ser buscado: ");
			        scanf ("%d", &num1);
			        
			        aux=buscar(L1,num1);
			        
			        if (aux != NULL )   //ou    if (buscar (L1, num1))
			        {
			        	printf ("O numero %d foi encontrado na lista no Endereco: %p\n", num1,aux);
					}
					else
					{
						printf ("O numero %d nao foi encontrado na lista!\n", num1);
					}
					break;
				
			//exibir
			case 6: exibir (L1);
			        break;
				
			//sa�da
			case 7: printf ("Fim do programa!\n");
			        break;
			        
			//op��o inv�lida
			default: printf ("Op��o inv�lida! Tente novamente.\n");
		}
		
		system ("pause");
	}
	while (opcao != 7);
}

//implementa��o das fun��es
int inserir (TLista *L, int numero)
{
	//Declara��o de vari�veis
	TLista aux;
	
	//Passo1: alocar mem�ria para o novo elemento
	aux = (TLista) malloc (sizeof(TNo));

	//verificando se a mem�ria solicitada n�o foi alocada
	if (aux == NULL)
	{
		return FALSE;
	}
	else
	{
		//Passo2: armazenar o novo valor na mem�ria rec�m alocada
		aux->valor = numero;
		
		//Passo3: fazer o novo n� apontar para o n� que, at� ent�o, era o primeiro da lista.
		aux->prox = *L;
		
		//Passo4: fazer com que o L aponte para o novo elemento
		*L = aux;
		
		return TRUE;
	}

}

int remover (TLista *L, int numero)
{
	//declara��o de vari�veis
	TLista aux1, aux2;
	int cont = 0;
	
	//removendo ocorr�ncias de 'numero' no in�cio da lista
	while ((*L != NULL) && ((*L)->valor == numero))
	{
		//Passo1: fazer um auxiliar apontar para o primeiro n�
		aux1 = *L;
		
		//Passo2: fazer 'L' apontar para o "2�" elemento
		*L = aux1->prox;   //ou *L = (*L)->prox;
		
		//Passo3: liberar a mem�ria apontada por 'aux1'
		free (aux1);
		
		//atualizar o n�mero de remo��es realizadas
		return TRUE;
	}
	
	//verificando se ainda existem elementos na lista
	if (*L != NULL)  //ou   if (*L)
	{
		//Passo1: buscar com 'aux1' o elemento a ser removido e garantir que 'aux2' apontar� sempre para o n� anterior ao apontado por 'aux1'
		
		//inicializando os ponteiros 'aux1' e 'aux2'
		aux2 = *L;
		aux1 = aux2->prox;
		
		//percorrendo toda a lista com 'aux1'
		while (aux1 != NULL)  //ou   while (aux1)
		{
			//verificando se o elemento a ser removido foi encontrado
			if (aux1->valor == numero)
			{
				//Passo2: fazer o 'prox' de 'aux2' apontar para o 'prox' do 'aux1'
				aux2->prox = aux1->prox;
				
				//Passo3: liberar a mem�ria apontada por 'aux1'
				free (aux1);

				//atualizar o n�mero de remo��es realizadas
				cont++;
				
				//Passo4: fazer com que 'aux1' aponte para o pr�ximo elemento da lista (aquele que era pontado pelo n� que acabou de ser removido)
				aux1 = aux2->prox;
				
				return TRUE;
			}
			else
			{
				//andando com os auxiliares para os pr�ximos n�s
				aux2 = aux1;     //ou   aux2 = aux2->prox;
				aux1 = aux1->prox;
			}
		}
	}
	return FALSE;
}

int alterar (TLista L, int velho, int novo)
{
	//declara��o de vari�veis
	TLista aux;
	
	//inicializando 'aux' de forma que aponte para o primeiro n� da lista
	aux = L;
		
	//percorrendo todos os n�s da lista
	while (aux != NULL) //while (aux) 
	{
		//verificando se foi encontrado o n�mero a ser alterado ('velho')
		if (aux->valor == velho)
		{
			aux->valor = novo;
			return TRUE;
		}
				
		//andar com o 'aux' de forma que ele aponte para o pr�ximo n�
		aux = aux->prox;
	}
	return FALSE;
}

void exibir (TLista L)
{
	//declara��o de vari�veis
	TLista aux;
	
	//testando se a lista est� vazia
	if (L == NULL)   //if (!L)
	{
		printf ("\nLista Vazia!\n\n");
	}
	else
	{
		printf ("\nLista: ");
		
		//inicializando 'aux' de forma que aponte para o primeiro n� da lista
		aux = L;
		
		//percorrendo todos os n�s da lista
		while (aux != NULL) //while (aux) 
		{
			//exibindo o valor apontado pelo 'aux'
			printf ("%d ", aux->valor);
			
			//andar com o 'aux' de forma que ele aponte para o pr�ximo n�
			aux = aux->prox;
		}	
	}
}

TLista buscar (TLista L, int numero)
{
	//declara��o de vari�veis
	TLista aux;
	int decision;
	//inicializando 'aux' de forma que aponte para o primeiro n� da lista
	aux = L;
		
	//percorrendo todos os n�s da lista
	while (aux != NULL) //while (aux) 
	{
		//verificando se 'numero' foi encontrado
		if (aux->valor == numero)
		{
			return aux;
		}
				
		//andar com o 'aux' de forma que ele aponte para o pr�ximo n�
		aux = aux->prox;
	}		
	
	//'numero' n�o existe na lista
	return NULL;
}

/*Exibe um menu de op��es ao usu�rio com as opera��es que podem ser realizadas sobre a 
lista. A op��o selecionada pelo usu�rio ser� retornada.*/
int menu ()
{
	int op;
	
	system ("cls");
	printf ("Menu de opcoes:\n\n");
	printf ("(1) Inserir\n(2) Remover\n(3) Remover Por Posicao\n(4) Alterar\n");
	printf("(5) Buscar\n(6) Exibir\n(7) Sair\n\n");
	printf ("Entre com a sua opcao: ");
	scanf ("%d", &op);
	
	return op;
}

int integridade(TLista L,int numero)
{
	int aux;
	while(L!=NULL)
	{
		aux=L->valor;
		if(aux==numero)
		{
			return TRUE;
		}
		L=(L)->prox;
	}
	return FALSE;
}

int removerporposition (TLista *L,int Position)
{
	//declara��o de vari�veis
	TLista aux1, aux2;
	int cont = 1;
	
	//removendo por posi��o
	while (cont == Position)
	{
		//Passo1: fazer um auxiliar apontar para o primeiro n�
		aux1 = *L;
		
		//Passo2: fazer 'L' apontar para o "2�" elemento
		*L = aux1->prox;   //ou *L = (*L)->prox;
		
		//Passo3: liberar a mem�ria apontada por 'aux1'
		free (aux1);
		
		return TRUE;
	}
	
	//verificando se ainda existem elementos na lista
	if (*L != NULL)  //ou   if (*L)
	{
		//Passo1: buscar com 'aux1' o elemento a ser removido e garantir que 'aux2' apontar� sempre para o n� anterior ao apontado por 'aux1'
		
		//inicializando os ponteiros 'aux1' e 'aux2'
		aux2 = *L;
		aux1 = aux2->prox;
		
		//percorrendo toda a lista com 'aux1'
		while (aux1 != NULL)  //ou   while (aux1)
		{
			cont++;
			//verificando se foi chegado na posi��o para remover o elemento
			if (cont == Position)
			{
				//Passo2: fazer o 'prox' de 'aux2' apontar para o 'prox' do 'aux1'
				aux2->prox = aux1->prox;
				
				//Passo3: liberar a mem�ria apontada por 'aux1'
				free (aux1);

				//Passo4: fazer com que 'aux1' aponte para o pr�ximo elemento da lista (aquele que era pontado pelo n� que acabou de ser removido)
				aux1 = aux2->prox;
				return TRUE;
			}
			else
			{
				//andando com os auxiliares para os pr�ximos n�s
				aux2 = aux1;     //ou   aux2 = aux2->prox;
				aux1 = aux1->prox;
			}
		}
	}
	return FALSE;
}
