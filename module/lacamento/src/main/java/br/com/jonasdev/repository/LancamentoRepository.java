package br.com.jonasdev.repository;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.gateway.LancamentoGateway;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
class LancamentoRepository implements LancamentoGateway {

    private final ILancamentoRepository repository;

    public LancamentoRepository(ILancamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lancamento> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(Lancamento::toModel)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Lancamento find(Long id) {
        return repository.findById(id)
                .map(Lancamento::toModel)
                .orElse(Lancamento.toModel());
    }

    @Override
    public Lancamento add(Lancamento input) {
        LancamentoModel model = LancamentoModel.builder()
                .data(input.getData())
                .descricao(input.getDescricao())
                .pessoaDescricao(input.getPessoaDescricao())
                .modalidade(input.getModalidade())
                .formaPagamento(input.getFormaPagamento())
                .valor(input.getValor())
                .status(input.getStatus())
                .build();

        return Lancamento.toModel(repository.save(model));
    }




}
