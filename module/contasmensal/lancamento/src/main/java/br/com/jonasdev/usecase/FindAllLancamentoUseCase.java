package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.gateway.LancamentoGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FindAllLancamentoUseCase {

    private final LancamentoGateway lancamentoRepository;

    public FindAllLancamentoUseCase(LancamentoGateway lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public List<Lancamento> execute() {
        return lancamentoRepository.findAll();
    }
}
