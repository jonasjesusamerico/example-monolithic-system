package br.com.jonasdev.domain;

import br.com.jonasdev.repository.ILancamentoModel;

public class LancamentoFactory {

    public static Lancamento New() {
        return new LancamentoImpl();
    }

    public static Lancamento byModel(ILancamentoModel lancamentoModel) {
        return LancamentoImpl.builder()
                .id(lancamentoModel.getId())
                .data(lancamentoModel.getData())
                .descricao(lancamentoModel.getDescricao())
                .pessoaDescricao(lancamentoModel.getPessoaDescricao())
                .modalidade(lancamentoModel.getModalidade())
                .formaPagamento(lancamentoModel.getFormaPagamento())
                .valor(lancamentoModel.getValor())
                .status(lancamentoModel.getStatus())
                .build();
    }

    public static LancamentoImpl.LancamentoImplBuilder builder() {
        return LancamentoImpl.builder();
    }
}
