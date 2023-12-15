using Microsoft.EntityFrameworkCore;
using ORM5SBD.Models;

namespace ORM5SBD.Data
{
    public class Contexto : DbContext 
    {
        public Contexto(DbContextOptions<Contexto> options) : base(options) { }

        public DbSet<Aluno> alunos { get; set; }

        public DbSet<Disciplina> disciplinas { get; set; }

        public DbSet<Inscricao> inscricaos { get; set; }

        public DbSet<Turma> turmas { get; set; }

        public DbSet<Professor> professors { get; set; }
    }
}
