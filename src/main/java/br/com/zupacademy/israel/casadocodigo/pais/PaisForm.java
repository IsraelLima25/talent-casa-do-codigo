package br.com.zupacademy.israel.casadocodigo.pais;

import br.com.zupacademy.israel.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    @NotBlank
    private String nome;

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }

}
