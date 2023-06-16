#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
/*Professor demorei para aplicar a formula de if que o senhor forneceu, não consegui aplicar de maneira eficiente e fiquei em duvida sobre identificar numero
do lado de numero, mais acredito que seria usando um string auxiliar e verificando se ambos são numeros ou se ambos são letras no caso seria
necessario o uso de 2-3 string auxiliar 2 para compor repetidos e 1 para compor a copia da  string e ver se ambos são numeros*/


int validade(char s[],int i,int z,int y,int x);

int main()
{
	char ST[10];
	int v;
	
	fflush(stdin);
	printf("informe sua senha: ");
	gets(ST);
	if(validade(ST,0,0,0,0)==1)
	{
		printf("\nSenha Registrada Com Sucesso");
	}
	else
	{
		printf("\na Senha Esta fora Dos Padroes Exigidos");
	}	
}
int validade(char s[],int i,int z,int y,int x)
{
	if(i<6 && s[i]=='\0')
	{
		return 0;
    }
    else
    {
    if (('0' <= s[i]) && (s[i] <= '9'))
	{
		z++;
	}
	if (('A' <= s[i] && s[i] <= 'Z')) 
	{
		y++;
	}
	if (('a' <= s[i]) && (s[i] <= 'z'))
	{
		x++;
	}
    }
    
	if(s[i]!='\0')
	{
		validade(s,i+1,z,y,x);
	}
	else
	{
		if(x==0 || y==0 || (3>z && z<0))
		{
			return 0;
		}
		return 1;
	}
}
