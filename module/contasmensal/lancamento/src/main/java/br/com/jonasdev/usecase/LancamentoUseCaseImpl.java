package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
class LancamentoUseCaseImpl implements LancamentoUseCase {

    private final SaveLancamentoUseCase save;
    private final FindLancamentoUseCase find;
    private final FindAllLancamentoUseCase findAll;
    private final DeleteLancamentoUseCase delete;
    private final UpdateLancamentoUseCase update;

    public LancamentoUseCaseImpl(SaveLancamentoUseCase save,
                                 FindLancamentoUseCase find,
                                 FindAllLancamentoUseCase findAll,
                                 DeleteLancamentoUseCase delete,
                                 UpdateLancamentoUseCase update) {
        this.save = save;
        this.find = find;
        this.findAll = findAll;
        this.delete = delete;
        this.update = update;
    }

    public Lancamento save(Lancamento inputDto) {
        return save.execute(inputDto);
    }

    @Override
    public Lancamento findById(Long id) {
        return find.execute(id);
    }

    @Override
    public Page<Lancamento> findAllPageable(Pageable page) {
        return findAll.executePageable(page);
    }

    @Override
    public void delete(Long id) {
        delete.execute(id);
    }

    @Override
    public Lancamento update(Lancamento dto) {
        return update.execute(dto);
    }


}
