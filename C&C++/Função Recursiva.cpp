#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <iostream>
int recursiva(char s1[],char s2[],int i,int x,int comum);

int main()
{
	char s1[] = "portugues|"; 
	char s2[] = "matematica|"; 
	printf("a palavra |%s e a palavra |%s tem %d caracteres comuns entre si",s1,s2,recursiva(s1,s2,0,0,0));
	
	return 0;	
}
int recursiva(char s1[],char s2[],int i,int x,int comum)
{
	if(s1[i]=='|')
	{
	  return comum; // finalizando a procura na string 1 sendo buscada os caracter da string 2 juntamente com finalizamento '|' do ciclo e entregando resultado para a main
	}
	else
	{
		if(s1[i]==s2[x]) // achou comum, receta o contador da string 2 e aumenta da string 1 em "+1"
	    {
		    comum++; //comuns
		    i++; //contador da string 1
		    x=0; //contador da string 2
			recursiva (s1,s2,i,x,comum);//realizando a operação denovo até varrer todo o vetor string 1 e fechar o ciclo no '|'
	    }
	    else
	    {
	    	x++; //não achou comum aumenta procura de string 2
	    if(s2[x]=='|') // verifica se chegou no limite da string 2
		{
			i++; //chegou no limite aumentou "+1" NA STRING 1
			x=0; //resetou string 2
		}
		recursiva (s1,s2,i,x,comum);//reiniciou a função para continuar a procura com o aumento da string 2
	    }	    		
	}
}
