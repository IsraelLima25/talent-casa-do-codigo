package br.com.zupacademy.israel.casadocodigo.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    public ResponseEntity<Void> cadastrarCategoria(@Valid @RequestBody CategoriaForm categoriaForm) {
        Categoria categoria = categoriaForm.toModel();
        manager.persist(categoria);
        return ResponseEntity.ok().build();
    }
}
