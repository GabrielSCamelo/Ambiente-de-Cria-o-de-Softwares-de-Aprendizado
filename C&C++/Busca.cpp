#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include<time.h>

//prototipo
int pesquisa (char s1[], char s2[], int ordem);

int main()
{
	//variaveis 
	char s1[] = "|nome|idade|genero|"; //variavel definida para teste
	char s2[10]; //minimo
	int ordem; //ordem para prucrar a informação
	
	//pedindo as informações
	printf("qual info deseja procurar: ");
	scanf("%s",&s2);
	
	printf("informe onde deseja verificar o local de armazenamento (1a a 3a) ordem: ");
	scanf("%d",&ordem);
	//executando a função pedida
	return pesquisa(s1,s2,ordem);
}

int pesquisa (char s1[], char s2[], int ordem)
{
	int i,x,cont=1; //cont para verificar a ordem , i para ver qual a primeira palavra da ordem , X para verificar se a palavra do string s2 está em s1 com a ajuda do i
	
	for (i=1;cont!=ordem;i++)
	{
		if(s1[i]=='|') //verificando o \ e definindo a ordem da informações
		{
			cont++; //contador
		}
	}
	for(x=0,i+1;s1[i]!='|';x++,i++) //condição de parada de verificação  '|'
	{
		if(s1[i]!=s2[x])
		{
			return 0; //retornando caso nao seja
		}
	}
	return 1; //finalizando com indicação que funciona
}
