using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ORM5SBD.Models
{
    [Table("Turma")]
    public class Turma
    {
        [Column("Id")]
        public int? Id { get; set; }
        [Column("DisciplinaId")]
        public int? DisciplinaId { get; set; } //Chave Estrangeira
        public virtual Disciplina? Disciplina { get; set; } //Caminho para Tabela
        [Column("ProfessorId")]
        public int? ProfessorId {  get; set; }
        public virtual Professor? Professor { get; set; }
    }
}
