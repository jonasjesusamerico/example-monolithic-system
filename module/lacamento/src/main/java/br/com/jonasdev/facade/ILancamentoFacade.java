package br.com.jonasdev.facade;

import java.util.List;

public interface ILancamentoFacade {

    LancamentoFacadeDto add(LancamentoFacadeDto input);

    LancamentoFacadeDto findById(Long id);

    List<LancamentoFacadeDto> findAll();
}
