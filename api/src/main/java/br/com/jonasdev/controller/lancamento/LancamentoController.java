package br.com.jonasdev.controller.lancamento;

import br.com.jonasdev.infra.config.exceptions.NotFoundException;
import br.com.jonasdev.domain.Lancamento;
import br.com.jonasdev.facade.AddProductFacadeInputDto;
import br.com.jonasdev.facade.ILancamentoFacade;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController {

    private final ILancamentoFacade facade;

    public LancamentoController(ILancamentoFacade facade) {
        this.facade = facade;
    }

    @GetMapping()
    public ResponseEntity<List<Lancamento>> getAll() {
        return new ResponseEntity<>(facade.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Lancamento> findById(@PathVariable("id") Long id) {
        try {
            Lancamento lancamento = facade.findById(id);
            return new ResponseEntity<>(lancamento, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<Lancamento> post(@Valid @RequestBody AddProductFacadeInputDto req) {

        Lancamento lancamento = facade.add(req);

        return new ResponseEntity<>(lancamento, HttpStatus.OK);
    }
}
