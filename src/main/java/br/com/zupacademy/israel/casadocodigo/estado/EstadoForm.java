package br.com.zupacademy.israel.casadocodigo.estado;

import br.com.zupacademy.israel.casadocodigo.pais.Pais;
import br.com.zupacademy.israel.casadocodigo.validator.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    @NotBlank
    private String nome;

    public EstadoForm(@NotNull Long idPais, @NotBlank String nome) {
        this.idPais = idPais;
        this.nome = nome;
    }

    public Estado toModel(EntityManager manager){
        Pais pais = manager.find(Pais.class, idPais);
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
