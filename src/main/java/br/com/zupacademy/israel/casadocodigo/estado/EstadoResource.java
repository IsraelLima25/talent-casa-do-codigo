package br.com.zupacademy.israel.casadocodigo.estado;

import br.com.zupacademy.israel.casadocodigo.estado.validator.UniqueNameStateCountryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private UniqueNameStateCountryValidator stateCountryValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(stateCountryValidator);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> cadastrarEstado(@Valid @RequestBody EstadoForm estadoForm) {
        Estado estado = estadoForm.toModel(manager);
        manager.persist(estado);
        return ResponseEntity.ok().build();
    }
}
