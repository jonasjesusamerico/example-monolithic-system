package br.com.jonasdev.facade;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.usecase.ILancamentoUseCase;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class LancamentoFacade implements ILancamentoFacade {

    private final ILancamentoUseCase useCase;

    public LancamentoFacade(ILancamentoUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public LancamentoFacadeDto save(LancamentoFacadeDto inputDto) {
        Lancamento lancamento = LancamentoConversor.domainToDto(inputDto);
        Lancamento lancamentoSaved = useCase.save(lancamento);
        return LancamentoConversor.dtoToDomain(lancamentoSaved);
    }

    @Override
    @Transactional(readOnly = true)
    public LancamentoFacadeDto findById(Long id) {
        return Optional.ofNullable(useCase.findById(id))
                .filter(t -> Objects.nonNull(t.getId()))
                .map(LancamentoConversor::dtoToDomain)
                .orElseThrow(() -> new EntityNotFoundException("Lançamento " + id + " not found"));
    }

    @Override
    public List<LancamentoFacadeDto> findAll() {
        return useCase.findAll().stream()
                .map(LancamentoConversor::dtoToDomain)
                .collect(Collectors.toList());
    }

}
