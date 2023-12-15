using System.ComponentModel.DataAnnotations.Schema;

namespace ORM5SBD.Models
{
    [Table("Inscricao")]
    public class Inscricao
    {
        [Column("InscricaoId")]
        public int? Id { get; set; }
        [Column("AlunoId")]
        public int UsuarioId { get; set; }
        public virtual Aluno? Usuario { get; set; }
        [Column("TurmaId")]
        public int TurmaId { get; set; }
        public virtual Turma? Turma { get; set; }
        [Column("Frequencia")]
        public int? Frequencia { get; set; } //Contador de faltas. 
        [Column("AV1")]
        public decimal? AV1 { get; set; }
        [Column("AV2")]
        public decimal? AV2 { get; set; }
        [Column("AVF")]
        public decimal? AVF { get; set; }
        [Column("InicioPeriodo")]
        public DateTime InicioPeriodo { get; set; }
        [Column("FinalPeriodo")]
        public DateTime FinalPeriodo { get; set; }

    }
}
