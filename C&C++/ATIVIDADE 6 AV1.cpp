//bibliotecas utilizadas
#include <stdio.h> //utilizado para criação padrão basica.
#include <stdlib.h> // utilizado para limpar o programa 
#include <time.h> //utilizada para ter sementes aleatorias
#include <string.h> //utilizada para definir as informações da struct

//struct
typedef struct
{
	int Status,Periodo; //Periodos (1o/2o/3o/4o/5o) 5 Periodos e Status (Livre/Manutenção/Alocada) 3 Statos; obs: caso esteja livre curso = N/A Periodo=0.
	//caso esteja em manutenção curso = MRO
	char Curso[3]; //curso definido pro siglas (CAL/REQ/TPH/SOP/MPA/FPR) 6 CURSOS DEFINIDIDOS.
} InfoSala;

//funções
void definindoinfo(InfoSala P[8][10][3]);
void exibirinfo(InfoSala P[8][10][3]);
void Cursos();

int main()
{
	
	InfoSala Predio[8][10][3];
	definindoinfo(Predio);
	exibirinfo(Predio);
	
}
void definindoinfo(InfoSala P[8][10][3]) // (A)ndares / (S)alas / (T)urnos definindo tamanhos até onde deve-se repetir.
{
	int i1,i2,i3,temp; //variaveis para a repetição. (i) variavel para aleatorio (temp)
	
	srand(time(NULL));
	
	for(i1=0;i1<8;i1++) // andares
	{
		for(i2=0;i2<10;i2++) // salas
		{
			for(i3=0;i3<3;i3++) //periodos
			{
				P[i1][i2][i3].Status=rand() % 3; //acrescentando 2 numeros para dar porcentagem de aparecer mais salas de cursos.
				
				if(P[i1][i2][i3].Status==1)
				{
					P[i1][i2][i3].Periodo=1+rand() % 5; //definição de Periodo
					
					temp=rand() % 6; //definindo curso
					
					switch(temp)
					{
						case 0: {
							strcpy(P[i1][i2][i3].Curso,"CAL");
							break;
						}
						case 1: {
							strcpy(P[i1][i2][i3].Curso,"REQ");
							break;
						}
						case 2: {
							strcpy(P[i1][i2][i3].Curso,"TPH");
							break;
						}
						case 3: {
							strcpy(P[i1][i2][i3].Curso,"SOP");
							break;
						}
						case 4: {
							strcpy(P[i1][i2][i3].Curso,"MPA");
							break;
						}
						case 5: {
							strcpy(P[i1][i2][i3].Curso,"FPR");
						}
					}
				}
				else
				{
					P[i1][i2][i3].Periodo=0;
					if(P[i1][i2][i3].Status==0) // 0 para sala livre | 2 para sala manutenção.
					{
						strcpy(P[i1][i2][i3].Curso,"N/A"); //LIVRE
					}
					else
					{
					    strcpy(P[i1][i2][i3].Curso,"MRO");	//MANUTENÇÃO
					}
				}
			}
		}
	}
}
void exibirinfo(InfoSala P[8][10][3])
{
	int i1,i2,i3,temp=1,cont;
	char C[3];
	
	do
	{
		system("cls");
		cont=0;
		Cursos();
		
		fflush(stdin);
		printf("\tInforme o Curso que deseja Visualizar ou A situacao de sala: "); //pergunta qual curso vc deseja visualizar, informar tanto maiusculo quanto minusculo
		gets(C);
		strupr(C);//passa a string para miausculo
		system("cls"); //retira as informações desnecessarias naquele momento.
		
		printf("\tSalas do Curso (%s) /\tPeriodo\n\n",C);
		
	    for(i1=0;i1<8;i1++) // andares
     	{
	     	for(i2=0;i2<10;i2++) // salas
	     	{
		    	for(i3=0;i3<3;i3++) //periodos
		    	{
			    	if(strcmp(P[i1][i2][i3].Curso,C)==0)
			    	{
			    		cont++;
			    		switch(i3)
			    		{
			    			case 0: {
			    				printf("\tM%d%d - %d ",i2,i1,P[i1][i2][i3].Periodo);
			    				break;
							}
							case 1: {
								printf("\tT%d%d - %d ",i2,i1,P[i1][i2][i3].Periodo);
								break;
							}
							case 2: {
								printf("\tN%d%d - %d ",i2,i1,P[i1][i2][i3].Periodo);
							}
						}
						if(cont==5)
						{
							printf("\n");
							cont=0;
						}
			    	}
		    	}
	    	}
    	}
	
	printf("\n\n\tDeseja visualizar mais alguma informacao ?\n\t1-Sim\n\t2-Nao\n\tR:");
	scanf("%d",&temp);
	
	while(temp!=1 && temp!=2)
	{
		system("cls");
		printf("\topcao desconhecida..Informe uma valida.");
		printf("\n\t1-Sim\n\t2-Nao\n\tR: ");
		scanf("%d",&temp);
		
	}
    }while(temp!=2);
}
void Cursos()
{
	printf("\n\tCursos e situacoes:\n\n");
	printf("\t(N/A) - Sala livre.\n");
	printf("\t(MRO) - Manutencao.\n");
	printf("\t(CAL) - Calculo.\n");
	printf("\t(REQ) - Engenharia de Requisitos.\n");
	printf("\t(TPH) - Tecnicas e Paradigmas Humanos.\n");
	printf("\t(SOP) - .Fundamentos de Sistemas Operacionais\n");
	printf("\t(MPA) - . Metodos e Processos Administrativos\n");
	printf("\t(FPR) - .Fundamentos de Programacao\n\n");
}
