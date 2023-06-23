package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.gateway.LancamentoGateway;
import org.springframework.stereotype.Service;

@Service
class UpdateLancamentoUseCase {

    private final LancamentoGateway lancamentoRepository;

    public UpdateLancamentoUseCase(LancamentoGateway lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento execute(Lancamento inputDto) {
        return this.lancamentoRepository.update(inputDto);
    }
}
