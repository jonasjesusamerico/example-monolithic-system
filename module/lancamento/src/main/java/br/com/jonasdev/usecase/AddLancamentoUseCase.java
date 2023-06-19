package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.gateway.LancamentoGateway;
import org.springframework.stereotype.Service;

@Service
class AddLancamentoUseCase {

    private final LancamentoGateway lancamentoRepository;

    public AddLancamentoUseCase(LancamentoGateway lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento execute(Lancamento inputDto) {
        return this.lancamentoRepository.save(inputDto);
    }
}
