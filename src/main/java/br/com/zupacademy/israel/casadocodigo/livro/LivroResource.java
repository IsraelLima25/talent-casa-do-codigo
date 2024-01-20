package br.com.zupacademy.israel.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroResource {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<Void> cadastrarLivro(@Valid @RequestBody LivroForm livroForm) {

        Livro livro = livroForm.toModel(manager);
        manager.persist(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarLivros() {

        List<Livro> listaLivros = livroRepository.findAll();
        List<LivroDTO> listLivrosDTO = listaLivros.stream().map(Livro::toLivroDTO).collect(Collectors.toList());
        return ResponseEntity.ok(listLivrosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheLivroDTO> detalharLivro(@PathVariable Long id) {

        Optional<Livro> possivelLivro = livroRepository.findById(id);
        if (!possivelLivro.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        DetalheLivroDTO detalheLivroDTO = new DetalheLivroDTO(possivelLivro.get());
        return ResponseEntity.ok(detalheLivroDTO);
    }
}
