using System.ComponentModel.DataAnnotations.Schema;

namespace ORM5SBD.Models
{
    [Table("Aluno")]
    public class Aluno : Usuario
    {
        [Column("Id")]
        public int id { get; set; }
        public List<Inscricao>? inscricoes { get;}
    }
}
