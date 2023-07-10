package Project.Api.Emprestimo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.Api.Emprestimo.Model.BemDuravel;
import Project.Api.Emprestimo.Repository.BemDuravelRepository;

@Service
public class BemDuravelService {

    private final BemDuravelRepository bemDuravelRepository;

    @Autowired
    public BemDuravelService(BemDuravelRepository bemDuravelRepository) {
        this.bemDuravelRepository = bemDuravelRepository;
    }

    public Iterable<BemDuravel> listarBemDuraveis() {
        return bemDuravelRepository.findAll();
    }

    public BemDuravel buscarBemDuravelPorId(Long id) {
        return bemDuravelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bem durável não encontrado"));
    }
    
    public BemDuravel registrarBemDuravel(BemDuravel bemDuravel) {
        return bemDuravelRepository.save(bemDuravel);
    }

    public BemDuravel atualizarBemDuravel(Long id, BemDuravel bemDuravelAtualizado) {
        BemDuravel bemDuravel = buscarBemDuravelPorId(id);

        bemDuravel.setDescrição(bemDuravelAtualizado.getDescrição());
        bemDuravel.setValordbem(bemDuravelAtualizado.getValordbem());

        return bemDuravelRepository.save(bemDuravel);
    }

	public List<BemDuravel> listarBemDuraveisPorContrato(String codContrato) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
