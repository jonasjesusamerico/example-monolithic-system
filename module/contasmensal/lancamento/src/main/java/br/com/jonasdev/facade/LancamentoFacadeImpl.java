package br.com.jonasdev.facade;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.usecase.LancamentoUseCase;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class LancamentoFacadeImpl implements LancamentoFacade {

    private final LancamentoUseCase useCase;

    public LancamentoFacadeImpl(LancamentoUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    @Transactional(readOnly = true)
    public LancamentoFacadeDto findById(Long id) {
        return Optional.ofNullable(useCase.findById(id))
                .filter(t -> Objects.nonNull(t.getId()))
                .map(LancamentoConversor::domainToDto)
                .orElseThrow(() -> new EntityNotFoundException("Lançamento " + id + " not found"));
    }

    @Override
    public Page<LancamentoFacadeDto> findAllPageable(Pageable page) {
        Page<Lancamento> lancamentoPage = useCase.findAllPageable(page);

        List<LancamentoFacadeDto> collect = lancamentoPage.stream()
                .map(LancamentoConversor::domainToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(collect, page, lancamentoPage.getTotalElements());
    }

    @Override
    public LancamentoFacadeDto save(LancamentoFacadeDto inputDto) {
        Lancamento lancamento = LancamentoConversor.dtoToDomain(inputDto);
        Lancamento lancamentoSaved = useCase.save(lancamento);
        return LancamentoConversor.domainToDto(lancamentoSaved);
    }

    @Override
    public LancamentoFacadeDto update(LancamentoFacadeDto input) {
        findById(input.getId());

        Lancamento lancamento = LancamentoConversor.dtoToDomain(input);
        Lancamento updated = useCase.update(lancamento);

        return LancamentoConversor.domainToDto(updated);
    }

    @Override
    public void delete(Long id) {
        Lancamento lancamento = Optional.ofNullable(useCase.findById(id))
                .filter(t -> Objects.nonNull(t.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Lançamento " + id + " not found"));
        useCase.delete(lancamento.getId());
    }

}
