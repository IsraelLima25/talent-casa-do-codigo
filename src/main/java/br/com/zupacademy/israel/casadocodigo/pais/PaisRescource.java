package br.com.zupacademy.israel.casadocodigo.pais;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisRescource {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    public ResponseEntity<Void> cadastrarPais(@Valid @RequestBody PaisForm paisForm) {
        Pais pais = paisForm.toModel();
        manager.persist(pais);
        return ResponseEntity.ok().build();
    }
}
