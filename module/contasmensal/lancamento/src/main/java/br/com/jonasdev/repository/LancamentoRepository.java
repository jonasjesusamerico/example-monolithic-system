package br.com.jonasdev.repository;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.gateway.LancamentoGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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
    public Page<Lancamento> findAllPageable(Pageable page) {
        Page<LancamentoModel> all = repository.findAll(page);
        List<Lancamento> collect = StreamSupport.stream(all.spliterator(), false)
                .map(Lancamento::byModel)
                .collect(Collectors.toList());

        return new PageImpl<>(collect, page, all.getTotalElements());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Lancamento> findAll() {
        return repository.findAll().stream()
                .map(Lancamento::byModel)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Lancamento find(Long id) {
        return repository.findById(id)
                .map(Lancamento::byModel)
                .orElse(Lancamento.New());
    }

    @Override
    public Lancamento save(Lancamento input) {
        LancamentoModel model = LancamentoModel.builder()
                .data(input.getData())
                .descricao(input.getDescricao())
                .pessoaDescricao(input.getPessoaDescricao())
                .modalidade(input.getModalidade())
                .formaPagamento(input.getFormaPagamento())
                .valor(input.getValor())
                .status(input.getStatus())
                .build();
        model.setId(input.getId());

        return Lancamento.byModel(repository.save(model));
    }

    @Override
    public Lancamento update(Lancamento lancamento) {
        LancamentoModel model = repository.findById(lancamento.getId()).orElse(null);
        if (Objects.isNull(model)) {
            return Lancamento.New();
        }

        model.setData(lancamento.getData());
        model.setDescricao(lancamento.getDescricao());
        model.setPessoaDescricao(lancamento.getPessoaDescricao());
        model.setModalidade(lancamento.getModalidade());
        model.setFormaPagamento(lancamento.getFormaPagamento());
        model.setValor(lancamento.getValor());
        model.setStatus(lancamento.getStatus());

        return Lancamento.byModel(repository.save(model));
    }


}
