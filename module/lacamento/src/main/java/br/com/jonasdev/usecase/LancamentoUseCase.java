package br.com.jonasdev.usecase;

import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.facade.AddProductFacadeInputDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class LancamentoUseCase implements ILancamentoUseCase{

    private final AddLancamentoUseCase add;
    private final FindLancamentoUseCase find;
    private final FindAllLancamentoUseCase findAll;

    public LancamentoUseCase(AddLancamentoUseCase add, FindLancamentoUseCase find, FindAllLancamentoUseCase findAll) {
        this.add = add;
        this.find = find;
        this.findAll = findAll;
    }

    public Lancamento add(AddProductFacadeInputDto inputDto) {
        return add.execute(inputDto);
    }

    @Override
    public Lancamento findById(Long id) {
        return find.execute(id);
    }

    @Override
    public List<Lancamento> findAll() {
        return findAll.execute();
    }


}