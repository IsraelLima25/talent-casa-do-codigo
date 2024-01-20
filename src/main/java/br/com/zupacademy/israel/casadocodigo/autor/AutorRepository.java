package br.com.zupacademy.israel.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Long> {

    Optional<Autor> findByEmail (String email);
}
