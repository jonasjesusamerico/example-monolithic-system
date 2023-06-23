package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoUseCase {

    public Lancamento save(Lancamento inputDto);

    public Lancamento findById(Long id);

    public Page<Lancamento> findAllPageable(Pageable page);

    void delete(Long id);

    Lancamento update(Lancamento update);
}
