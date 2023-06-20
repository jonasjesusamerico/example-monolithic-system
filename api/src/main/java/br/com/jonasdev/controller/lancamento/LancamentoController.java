package br.com.jonasdev.controller.lancamento;

import br.com.jonasdev.facade.LancamentoFacade;
import br.com.jonasdev.facade.LancamentoFacadeDto;
import br.com.jonasdev.infra.config.exceptions.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController {

    private final LancamentoFacade facade;

    public LancamentoController(LancamentoFacade facade) {
        this.facade = facade;
    }

    @GetMapping()
    public ResponseEntity<List<LancamentoFacadeDto>> getAll() {
        return new ResponseEntity<>(facade.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LancamentoFacadeDto> findById(@PathVariable("id") Long id) {
        try {
            LancamentoFacadeDto lancamento = facade.findById(id);
            return new ResponseEntity<>(lancamento, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<LancamentoFacadeDto> post(@Valid @RequestBody LancamentoFacadeDto req) {
        return new ResponseEntity<>(facade.save(req), HttpStatus.OK);
    }
}
