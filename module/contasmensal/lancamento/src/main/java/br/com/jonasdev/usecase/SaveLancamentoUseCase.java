package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.gateway.LancamentoGateway;
import org.springframework.stereotype.Service;

@Service
class SaveLancamentoUseCase {

    private final LancamentoGateway lancamentoRepository;

    public SaveLancamentoUseCase(LancamentoGateway lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento execute(Lancamento inputDto) {
        return this.lancamentoRepository.save(inputDto);
    }
}
