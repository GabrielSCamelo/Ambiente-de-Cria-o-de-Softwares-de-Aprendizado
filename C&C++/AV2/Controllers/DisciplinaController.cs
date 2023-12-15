using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ORM5SBD.Data;
using ORM5SBD.Models;

[Route("api/[controller]")]
[ApiController]
public class DisciplinaController : ControllerBase
{
    private readonly Contexto _context;

    public DisciplinaController(Contexto context)
    {
        _context = context;
    }

    // GET: api/Disciplina
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Disciplina>>> Getdisciplinas()
    {
        return await _context.disciplinas.ToListAsync();
    }

    // GET: api/Disciplina/5
    [HttpGet("{id}")]
    public async Task<ActionResult<Disciplina>> GetDisciplina(int id)
    {
        var disciplina = await _context.disciplinas.FindAsync(id);

        if (disciplina == null)
        {
            return NotFound();
        }

        return disciplina;
    }

    // POST: api/Disciplina
    [HttpPost]
    public async Task<ActionResult<Disciplina>> PostDisciplina(Disciplina disciplina)
    {
        _context.disciplinas.Add(disciplina);
        await _context.SaveChangesAsync();

        return CreatedAtAction(nameof(GetDisciplina), new { id = disciplina.Id }, disciplina);
    }

    // PUT: api/Disciplina/5
    [HttpPut("{id}")]
    public async Task<IActionResult> PutDisciplina(int id, Disciplina disciplina)
    {
        if (id != disciplina.Id)
        {
            return BadRequest();
        }

        _context.Entry(disciplina).State = EntityState.Modified;

        try
        {
            await _context.SaveChangesAsync();
        }
        catch (DbUpdateConcurrencyException)
        {
            if (!DisciplinaExists(id))
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

    // DELETE: api/Disciplina/5
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteDisciplina(int id)
    {
        var disciplina = await _context.disciplinas.FindAsync(id);
        if (disciplina == null)
        {
            return NotFound();
        }

        _context.disciplinas.Remove(disciplina);
        await _context.SaveChangesAsync();

        return NoContent();
    }

    private bool DisciplinaExists(int id)
    {
        return _context.disciplinas.Any(e => e.Id == id);
    }
}

