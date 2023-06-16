#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
/*
Exemplo 1:
Inicialmente:  X*7D2SFH1
Ao final:      XHFDS27*1

Exemplo 2:
Inicialmente:  1SUG47EFG
Ao final:      GSUGFE741
*/
//funções
int validadebloqueio(char str[],int TAM);
int tamanho(char str[]);
void trocaordenada(char str[],int i);

int main()
{
	int Tam=20;
	char str[Tam];
	do
	{
		
		fflush(stdin);
    	printf("entre com uma senha de ate %d caracteres: ",Tam); //pode-se alterar a quantidade de caracter contanto que altere O TAM.
        gets (str);
        system("cls");
        
        if(validadebloqueio(str,Tam)==0)
        {
        	printf("senha invalida! tente novamente.\nnao utilize o caracter '|'.\n");
        	system("pause");
        	system("cls");
		}
        
	}while(validadebloqueio(str,Tam)==0);
	
	printf("senha normal: %s\n",str);
	trocaordenada(str,0);
	printf("senha depois: %s\n",str);
	
	return 0;
}
int validadebloqueio(char str[],int Tam)
{
	int i,t=0;
	for(i=0;str[i]!='\0';i++)
	{
		if(str[i]=='|')
		{
			t=1;
		}
	}
	if(tamanho(str)<=Tam-1 && t==0)
	{
		
		return 1;
	}
	else
	{
		return 0;
	}
}
void trocaordenada(char str[],int i) //recursividade aplicada
{
	int x;
	char temp;
	
	if(i==0)
	{
		str[tamanho(str)+1]=str[tamanho(str)];
    	str[tamanho(str)]='|';	
    }
	
	if(str[i]!='|') //caracter nao disponivel para utilização
	{
	
	if((toupper(str[i]) >= 'A') && (toupper(str[i]) <= 'Z')) //é letra
	{
		return trocaordenada(str,i+1); //andando com a string e verificando o proximo caracter utilizando recursividade
    }
    else //não é letra
    {
    	temp=str[i]; //salvando o numero
    	for(x=i;str[x+1]!='\0';x++) //movendo para frente os caracter 
    	{
    		str[x]=str[x+1];
		}
		str[x]=temp; //jogando antes do '\0'
    	return trocaordenada(str,i); //ta sem i++ para verificar a msm posição novamente depois do deslocamento das letras no lugar do numero.
	}
    }
    else
    {
    	for(i;str[i]!='\0';i++) //colocando os numeros e tirando limitador
	{
		str[i]=str[i+1];
	}	
	}
}
int tamanho(char str[]) //função da biblioteca string.h com erro (não funcional para este programa) , implementada uma para a situação
{
	int i;
	
	for(i=0;str[i]!='\0';i++)
	{
	}
	return i;
}
