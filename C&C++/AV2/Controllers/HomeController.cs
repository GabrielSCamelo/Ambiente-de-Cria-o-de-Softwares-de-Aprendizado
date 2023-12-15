using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ORM5SBD.Data;
using ORM5SBD.Models;

[Route("api/[controller]")]
[ApiController]
public class TurmaController : ControllerBase
{
    private readonly Contexto _context;

    public TurmaController(Contexto context)
    {
        _context = context;
    }

    // GET: api/Turma
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Turma>>> Getturmas()
    {
        return await _context.turmas.ToListAsync();
    }

    // GET: api/Turma/5
    [HttpGet("{id}")]
    public async Task<ActionResult<Turma>> GetTurma(int id)
    {
        var turma = await _context.turmas.FindAsync(id);

        if (turma == null)
        {
            return NotFound();
        }

        return turma;
    }

    // POST: api/Turma
    [HttpPost]
    public async Task<ActionResult<Turma>> PostTurma(Turma turma)
    {
        _context.turmas.Add(turma);
        await _context.SaveChangesAsync();

        return CreatedAtAction(nameof(GetTurma), new { id = turma.Id }, turma);
    }

    // PUT: api/Turma/5
    [HttpPut("{id}")]
    public async Task<IActionResult> PutTurma(int id, Turma turma)
    {
        if (id != turma.Id)
        {
            return BadRequest();
        }

        _context.Entry(turma).State = EntityState.Modified;

        try
        {
            await _context.SaveChangesAsync();
        }
        catch (DbUpdateConcurrencyException)
        {
            if (!TurmaExists(id))
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

    // DELETE: api/Turma/5
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteTurma(int id)
    {
        var turma = await _context.turmas.FindAsync(id);
        if (turma == null)
        {
            return NotFound();
        }

        _context.turmas.Remove(turma);
        await _context.SaveChangesAsync();

        return NoContent();
    }

    private bool TurmaExists(int id)
    {
        return _context.turmas.Any(e => e.Id == id);
    }
}