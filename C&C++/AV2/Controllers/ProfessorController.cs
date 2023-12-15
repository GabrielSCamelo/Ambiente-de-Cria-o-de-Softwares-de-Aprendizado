using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ORM5SBD.Data;
using ORM5SBD.Models;

[Route("api/[controller]")]
[ApiController]
public class ProfessorController : ControllerBase
{
    private readonly Contexto _context;

    public ProfessorController(Contexto context)
    {
        _context = context;
    }

    // GET: api/Professor
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Professor>>> Getprofessors()
    {
        return await _context.professors.ToListAsync();
    }

    // GET: api/Professor/5
    [HttpGet("{id}")]
    public async Task<ActionResult<Professor>> GetProfessor(int id)
    {
        var professor = await _context.professors.FindAsync(id);

        if (professor == null)
        {
            return NotFound();
        }

        return professor;
    }

    // POST: api/Professor
    [HttpPost]
    public async Task<ActionResult<Professor>> PostProfessor(Professor professor)
    {
        _context.professors.Add(professor);
        await _context.SaveChangesAsync();

        return CreatedAtAction(nameof(GetProfessor), new { id = professor.id }, professor);
    }

    // PUT: api/Professor/5
    [HttpPut("{id}")]
    public async Task<IActionResult> PutProfessor(int id, Professor professor)
    {
        if (id != professor.id)
        {
            return BadRequest();
        }

        _context.Entry(professor).State = EntityState.Modified;

        try
        {
            await _context.SaveChangesAsync();
        }
        catch (DbUpdateConcurrencyException)
        {
            if (!ProfessorExists(id))
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

    // DELETE: api/Professor/5
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteProfessor(int id)
    {
        var professor = await _context.professors.FindAsync(id);
        if (professor == null)
        {
            return NotFound();
        }

        _context.professors.Remove(professor);
        await _context.SaveChangesAsync();

        return NoContent();
    }

    private bool ProfessorExists(int id)
    {
        return _context.professors.Any(e => e.id == id);
    }
}