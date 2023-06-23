package br.com.jonasdev.usecase;

import br.com.jonasdev.gateway.LancamentoGateway;
import org.springframework.stereotype.Service;

@Service
class DeleteLancamentoUseCase {

    private final LancamentoGateway lancamentoRepository;

    public DeleteLancamentoUseCase(LancamentoGateway lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public void execute(Long id) {
        this.lancamentoRepository.delete(id);
    }
}
