package br.com.zupacademy.israel.casadocodigo.cliente;

import br.com.zupacademy.israel.casadocodigo.estado.Estado;
import br.com.zupacademy.israel.casadocodigo.pais.Pais;
import br.com.zupacademy.israel.casadocodigo.validator.CPFOrCNPJ;
import br.com.zupacademy.israel.casadocodigo.validator.ExistsId;
import br.com.zupacademy.israel.casadocodigo.validator.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteForm {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @CPFOrCNPJ
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobreNome,
                       @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                       @NotBlank String cidade, @NotNull Long idPais, @NotBlank String telefone,
                       @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Cliente toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        Estado estado = idEstado != null ? manager.find(Estado.class, idEstado) : null;
        return new Cliente(email, nome, sobreNome, documento, endereco,
                complemento, cidade, pais, estado, telefone, cep);
    }
}
