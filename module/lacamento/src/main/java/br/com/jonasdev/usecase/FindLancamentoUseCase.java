package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.gateway.LancamentoGateway;
import org.springframework.stereotype.Service;

@Service
class FindLancamentoUseCase {

    private final LancamentoGateway lancamentoRepository;

    public FindLancamentoUseCase(LancamentoGateway lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento execute(Long id) {
        return lancamentoRepository.find(id);
    }
}
