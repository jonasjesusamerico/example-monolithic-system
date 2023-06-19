package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.facade.AddProductFacadeInputDto;
import br.com.jonasdev.gateway.LancamentoGateway;
import org.springframework.stereotype.Service;

@Service
class AddLancamentoUseCase {

    private final LancamentoGateway lancamentoRepository;

    public AddLancamentoUseCase(LancamentoGateway lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    public Lancamento execute(AddProductFacadeInputDto inputDto) {
        return this.lancamentoRepository.add(Lancamento.builder()
                .data(inputDto.getData())
                .descricao(inputDto.getDescricao())
                .pessoaDescricao(inputDto.getPessoaDescricao())
                .modalidade(inputDto.getModalidade())
                .formaPagamento(inputDto.getFormaPagamento())
                .valor(inputDto.getValor())
                .status(inputDto.getStatus())
                .build());
    }
}
