package br.com.zupacademy.israel.casadocodigo.livro;

import br.com.zupacademy.israel.casadocodigo.autor.Autor;
import br.com.zupacademy.israel.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String isbn;
    @NotNull
    @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @Lob
    private String sumarioMarkdown;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Future
    private LocalDate dataPublicacao;
    @NotNull
    @ManyToOne
    private Categoria categoria;
    @NotNull
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String isbn, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String titulo,
                 @NotBlank @Size(max = 500) String resumo, String sumarioMarkdown, @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Future LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumarioMarkdown = sumarioMarkdown;
        this.preco = preco;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }


    public String getIsbn() {
        return isbn;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumarioMarkdown() {
        return sumarioMarkdown;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Autor getAutor() {
        return autor;
    }

    public LivroDTO toLivroDTO() {
        return new LivroDTO(id, titulo);
    }
}
