package br.com.jonasdev.facade;

import br.com.jonasdev.domain.Lancamento;

class LancamentoConversor {

    public static Lancamento dtoToDomain(LancamentoFacadeDto dto) {
        Lancamento lancamento = Lancamento.builder()
                .data(dto.getData())
                .descricao(dto.getDescricao())
                .pessoaDescricao(dto.getPessoaDescricao())
                .modalidade(dto.getModalidade())
                .formaPagamento(dto.getFormaPagamento())
                .valor(dto.getValor())
                .status(dto.getStatus())
                .build();
        lancamento.setId(dto.getId());
        return lancamento;
    }

    public static LancamentoFacadeDto domainToDto(Lancamento t) {
        return LancamentoFacadeDto.builder()
                .id(t.getId())
                .data(t.getData())
                .descricao(t.getDescricao())
                .pessoaDescricao(t.getPessoaDescricao())
                .modalidade(t.getModalidade())
                .formaPagamento(t.getFormaPagamento())
                .valor(t.getValor())
                .status(t.getStatus())
                .build();
    }

    public static LancamentoFacadeDto update(LancamentoFacadeDto origem, LancamentoFacadeDto t) {
        return origem.toBuilder()
                .id(t.getId())
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
