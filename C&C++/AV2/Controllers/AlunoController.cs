using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ORM5SBD.Data;
using ORM5SBD.Models;

[Route("api/[controller]")]
[ApiController]
public class AlunoController : ControllerBase
{
    private readonly Contexto _context;

    public AlunoController(Contexto context)
    {
        _context = context;
    }

    // GET: api/Aluno
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Aluno>>> GetAlunos()
    {
        return await _context.alunos.ToListAsync();
    }

    // GET: api/Aluno/5
    [HttpGet("{id}")]
    public async Task<ActionResult<Aluno>> GetAluno(int id)
    {
        var aluno = await _context.alunos.FindAsync(id);

        if (aluno == null)
        {
            return NotFound();
        }

        return aluno;
    }

    // POST: api/Aluno
    [HttpPost]
    public async Task<ActionResult<Aluno>> PostAluno(Aluno aluno)
    {
        _context.alunos.Add(aluno);
        await _context.SaveChangesAsync();

        return CreatedAtAction(nameof(GetAluno), aluno);
    }

    // PUT: api/Aluno/5
    [HttpPut("{id}")]
    public async Task<IActionResult> PutAluno(int id, Aluno aluno)
    {
        if (id != aluno.id)
        {
            return BadRequest();
        }

        _context.Entry(aluno).State = EntityState.Modified;

        try
        {
            await _context.SaveChangesAsync();
        }
        catch (DbUpdateConcurrencyException)
        {
            if (!AlunoExists(id))
            {
                return NotFound();
            }
            else
            {
                throw;
            }
        }

        return NoContent();
    }

    // DELETE: api/Aluno/5
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteAluno(int id)
    {
        var aluno = await _context.alunos.FindAsync(id);
        if (aluno == null)
        {
            return NotFound();
        }

        _context.alunos.Remove(aluno);
        await _context.SaveChangesAsync();

        return NoContent();
    }

    private bool AlunoExists(int id)
    {
        return _context.alunos.Any(e => e.id == id);
    }
}

