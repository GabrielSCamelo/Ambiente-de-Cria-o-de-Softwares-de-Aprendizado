using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ORM5SBD.Data;
using ORM5SBD.Models;

[Route("api/[controller]")]
[ApiController]
public class InscricaoController : ControllerBase
{
    private readonly Contexto _context;

    public InscricaoController(Contexto context)
    {
        _context = context;
    }

    // GET: api/Inscricao
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Inscricao>>> Getinscricaos()
    {
        return await _context.inscricaos.ToListAsync();
    }

    // GET: api/Inscricao/5
    [HttpGet("{id}")]
    public async Task<ActionResult<Inscricao>> GetInscricao(int id)
    {
        var inscricao = await _context.inscricaos.FindAsync(id);

        if (inscricao == null)
        {
            return NotFound();
        }

        return inscricao;
    }

    // POST: api/Inscricao
    [HttpPost]
    public async Task<ActionResult<Inscricao>> PostInscricao(Inscricao inscricao)
    {
        _context.inscricaos.Add(inscricao);
        await _context.SaveChangesAsync();

        return CreatedAtAction(nameof(GetInscricao), new { id = inscricao.UsuarioId, turmaId = inscricao.TurmaId }, inscricao);
    }

    // PUT: api/Inscricao/5
    [HttpPut("{id}")]
    public async Task<IActionResult> PutInscricao(int id, Inscricao inscricao)
    {
        if (id != inscricao.UsuarioId || id != inscricao.TurmaId)
        {
            return BadRequest();
        }

        _context.Entry(inscricao).State = EntityState.Modified;

        try
        {
            await _context.SaveChangesAsync();
        }
        catch (DbUpdateConcurrencyException)
        {
            if (!InscricaoExists(id, inscricao.TurmaId))
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

    // DELETE: api/Inscricao/5
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteInscricao(int id, int turmaId)
    {
        var inscricao = await _context.inscricaos.FindAsync(id, turmaId);
        if (inscricao == null)
        {
            return NotFound();
        }

        _context.inscricaos.Remove(inscricao);
        await _context.SaveChangesAsync();

        return NoContent();
    }

    private bool InscricaoExists(int id, int turmaId)
    {
        return _context.inscricaos.Any(e => e.UsuarioId == id && e.TurmaId == turmaId);
    }
}