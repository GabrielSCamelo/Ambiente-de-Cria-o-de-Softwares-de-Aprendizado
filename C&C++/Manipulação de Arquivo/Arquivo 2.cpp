//importa��o de bibliotecas
#include <stdio.h>

//declara��o dos prot�tipos das fun��es
int interseccao(char ArqA[],char ArqB[],char ArqC[]);

//main
int main ()
{
	//declara��o de vari�veis
	char nomeArqA[20],nomeArqB[20],nomeArqC[20];
	
	//lendo o nome do arquivo
	printf ("Entre com o nome do arquivo (A): ");
	gets (nomeArqA);
	
	printf ("Entre com o nome do arquivo (B): ");
	gets (nomeArqB);
	
	printf ("Entre com o nome do arquivo (C): ");
	gets (nomeArqC);
	
	
	//chamando a fun��o
	if (interseccao (nomeArqA,nomeArqB,nomeArqC) == 0)
	{
		printf ("\nErro na abertura dos arquivos!\n");
	}
	else
	{
		printf ("\nArquivo %s gerado com sucesso!\n",nomeArqC);
	}
}

//implementa��o das fun��es
int interseccao (char ArqA[],char ArqB[],char ArqC[])
{
	//declara��o de vari�veis
	FILE *A,*B,*C;
	int numb1,numb2; //limite de NUMEROS.
	
	//abertura do arquivo (para leitura)
	A = fopen (ArqA, "r");
	B = fopen (ArqB, "r");
	C = fopen (ArqC, "w");
	
	//testando se o arquivo foi ou n�o aberto
	if (A == NULL || B == NULL || C==NULL)
	{
		return 0;
	}
	else
	{
		//lendo os valores do arquivo, enquanto existirem
		while (fscanf (A, "%d",&numb1) != EOF)   //end of file
		{
			while (fscanf (B, "%d",&numb2) != EOF)
			{
				if(numb1==numb2)
				{
					fprintf (C, "%d\n", numb1);
				}
			}
			fclose (B);
			B = fopen (ArqB, "r");
		}
		printf("%d",C);
		//fechar o arquivo
		fclose (A);
		fclose (B);
		fclose (C);
		
		return 1;
	}
}


