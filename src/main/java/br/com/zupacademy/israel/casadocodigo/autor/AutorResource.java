package br.com.zupacademy.israel.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorResource {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    public ResponseEntity<Void> cadastrarAutor(@Valid @RequestBody AutorForm autorForm) {

        Autor autor = autorForm.toModel();
        manager.persist(autor);
        return ResponseEntity.ok().build();
    }
}
