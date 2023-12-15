using Microsoft.EntityFrameworkCore;
using ORM5SBD.Data;

var builder = WebApplication.CreateBuilder(args);

// Adiciona serviços ao contêiner.
builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// Configuração do DbContext
builder.Services.AddDbContext<Contexto>(options =>
    options.UseSqlServer("Data Source=GABRIEL\\SQLEXPRESS;Initial Catalog=AV2_5SBD;Integrated Security=True;TrustServerCertificate=True"));

var app = builder.Build();

// Configuração do pipeline HTTP.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();
app.UseAuthorization();
app.MapControllers();
app.Run();

