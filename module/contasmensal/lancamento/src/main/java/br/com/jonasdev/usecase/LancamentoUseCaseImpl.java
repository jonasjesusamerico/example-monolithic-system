package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class LancamentoUseCaseImpl implements LancamentoUseCase {

    private final AddLancamentoUseCase add;
    private final FindLancamentoUseCase find;
    private final FindAllLancamentoUseCase findAll;

    public LancamentoUseCaseImpl(AddLancamentoUseCase add, FindLancamentoUseCase find, FindAllLancamentoUseCase findAll) {
        this.add = add;
        this.find = find;
        this.findAll = findAll;
    }

    public Lancamento save(Lancamento inputDto) {
        return add.execute(inputDto);
    }

    @Override
    public Lancamento findById(Long id) {
        return find.execute(id);
    }

    @Override
    public Page<Lancamento> findAllPageable(Pageable page) {
        return findAll.execute(page);
    }


}
