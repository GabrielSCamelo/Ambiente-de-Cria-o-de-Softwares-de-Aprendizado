using System.ComponentModel.DataAnnotations.Schema;

namespace ORM5SBD.Models
{
    public class Usuario
    {
        [Column("nome")]
        public string? nome { get; set; }
        [Column("Endereco")]
        public string? Endereco { get; set; }
        [Column("Cpf")]
        public string? Cpf { get; set; }
        [Column("DataNascimento")]
        public DateTime DataNascimento { get; set; }
        [Column("isDelet")]
        public bool? isDelet { get; set; } = true; //valor Inicial True

        public void Delete_User() { isDelet = false; }
    }
}
