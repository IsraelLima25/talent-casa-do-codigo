package br.com.zupacademy.israel.casadocodigo.categoria;

import br.com.zupacademy.israel.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    @NotBlank
    private String nome;

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
