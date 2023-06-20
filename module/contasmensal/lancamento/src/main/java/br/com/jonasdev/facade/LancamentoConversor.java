package br.com.jonasdev.facade;

import br.com.jonasdev.domain.Lancamento;

class LancamentoConversor {

    public static Lancamento domainToDto(LancamentoFacadeDto dto) {
        return Lancamento.builder()
                .data(dto.getData())
                .descricao(dto.getDescricao())
                .pessoaDescricao(dto.getPessoaDescricao())
                .modalidade(dto.getModalidade())
                .formaPagamento(dto.getFormaPagamento())
                .valor(dto.getValor())
                .status(dto.getStatus())
                .build();
    }

    public static LancamentoFacadeDto dtoToDomain(Lancamento t) {
        return LancamentoFacadeDto.builder()
                .data(t.getData())
                .descricao(t.getDescricao())
                .pessoaDescricao(t.getPessoaDescricao())
                .modalidade(t.getModalidade())
                .formaPagamento(t.getFormaPagamento())
                .valor(t.getValor())
                .status(t.getStatus())
                .build();
    }

}
