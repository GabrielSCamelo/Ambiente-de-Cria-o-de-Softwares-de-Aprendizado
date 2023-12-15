
using System.ComponentModel.DataAnnotations.Schema;

namespace ORM5SBD.Models
{
    [Table("Disciplina")]
    public class Disciplina
    {
        [Column("DisciplinaId")] 
        public int? Id { get; set; }

        [Column("Nome")] 
        public string? Nome { get; set; }

        [Column("Sigla")] 
        public string? Sigla { get; set; }

        [Column("Periodo")] 
        public int? Periodo { get; set; }

        [Column("Credito")]
        public int? Credito { get; set; }

        public List<Turma>? TurmaList { get;}
    }
}

