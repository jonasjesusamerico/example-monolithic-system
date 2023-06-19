package br.com.jonasdev.facade;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.usecase.ILancamentoUseCase;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
class LancamentoFacade implements ILancamentoFacade {

    private final ILancamentoUseCase useCase;

    public LancamentoFacade(ILancamentoUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Lancamento add(AddProductFacadeInputDto input) {
        System.out.println("Entrei dentro do facede");
        return useCase.add(input);
    }

    @Override
    @Transactional(readOnly = true)
    public Lancamento findById(Long id) {
        return Optional.ofNullable(useCase.findById(id))
                .filter(t -> Objects.nonNull(t.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Lançamento " + id + " not found"));
    }

    @Override
    public List<Lancamento> findAll() {
        return useCase.findAll();
    }

}
