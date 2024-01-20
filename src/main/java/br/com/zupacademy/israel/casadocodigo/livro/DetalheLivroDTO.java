package br.com.zupacademy.israel.casadocodigo.livro;

import br.com.zupacademy.israel.casadocodigo.autor.AutorDTO;

import java.math.BigDecimal;

public class DetalheLivroDTO {

    private String titulo;
    private BigDecimal preco;
    private String resumo;
    private String sumarioMarkdown;
    private Integer numeroPaginas;
    private String isbn;
    private AutorDTO autor;

    public DetalheLivroDTO(Livro livro) {
        titulo = livro.getTitulo();
        preco = livro.getPreco();
        resumo = livro.getResumo();
        sumarioMarkdown = livro.getSumarioMarkdown();
        numeroPaginas = livro.getNumeroPaginas();
        isbn = livro.getIsbn();
        autor = new AutorDTO(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumarioMarkdown() {
        return sumarioMarkdown;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public AutorDTO getAutor() {
        return autor;
    }
}
