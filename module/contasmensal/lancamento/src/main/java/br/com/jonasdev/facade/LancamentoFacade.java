package br.com.jonasdev.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoFacade {

    LancamentoFacadeDto findById(Long id);

    Page<LancamentoFacadeDto> findAllPageable(Pageable page);

    LancamentoFacadeDto save(LancamentoFacadeDto input);

    LancamentoFacadeDto update(LancamentoFacadeDto input);

    boolean delete(Long id);

}
