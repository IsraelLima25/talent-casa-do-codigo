package br.com.zupacademy.israel.casadocodigo.livro;

import br.com.zupacademy.israel.casadocodigo.autor.Autor;
import br.com.zupacademy.israel.casadocodigo.categoria.Categoria;
import br.com.zupacademy.israel.casadocodigo.validator.ExistsId;
import br.com.zupacademy.israel.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotNull
    @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumarioMarkdown;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public LivroForm(@NotBlank String isbn, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String titulo,
                     @NotBlank @Size(max = 500) String resumo, String sumarioMarkdown, @NotNull @Min(20) BigDecimal preco,
                     @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumarioMarkdown = sumarioMarkdown;
        this.preco = preco;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toModel(EntityManager manager) {
       @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
       @NotNull Autor autor = manager.find(Autor.class, idAutor);
       return new Livro(isbn,numeroPaginas,titulo,resumo,sumarioMarkdown,preco,dataPublicacao,categoria, autor);
    }

    /* O jackson não conseguiu desserializar pelo construtor */
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
