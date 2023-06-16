<!DOCKTYPE HTML>
<html>
    <head>
    </head>
    <body>
        <h1>3DAW</h1>
            <?php
                echo "<h2>Exercicio OBJETO</h2>" ; //variaveis e seus tipos

                class Disciplina
                {
                    public $nome;
                    public $sigla;
                    public $cargah;

                    public function __construct($nome,$sigla,$cargah)
                    {
                        $this->nome = $nome;
                        $this->sigla = $sigla;
                        $this->cargah = $cargah;
                    }
                    public function getDisc()
                    {
                       return "Nome Da Disciplina: " . $this->nome .
                              "<br>Sigla Da Disciplina: " . $this->sigla .
                              "<br>Carga Horaria Da Disciplina: " . $this->cargah . "<br>";
                    }


                }
                $objDisciplina1 = new Disciplina ("Desenvolvimento Web", "3DAW", "80");
                echo $objDisciplina1->getDisc();
                echo "<br>";

                $objDisciplina2 = new Disciplina ("Algebra Linear", "3ALG", "40");
                echo $objDisciplina2->getDisc();
                echo "<br>";

                $objDisciplina3 = new Disciplina ("Redes e Sistemas Distribuidos", "3RDS", "140");
                echo $objDisciplina3->getDisc();
                echo "<br>";

            ?>
    </body>
</html>
