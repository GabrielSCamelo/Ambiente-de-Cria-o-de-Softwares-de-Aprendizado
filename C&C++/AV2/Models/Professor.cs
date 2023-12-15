using Microsoft.AspNetCore.Components.Web;
using System.ComponentModel.DataAnnotations.Schema;

namespace ORM5SBD.Models
{
    [Table("Professor")]
    public class Professor : Usuario
    {
        [Column("Id")]
        public int? id { get; set; }
        public List<Turma>? turmas { get; }
        [Column("IsAdminstration")]
        public bool IsAdminstration { get; set; } 
    }
}
