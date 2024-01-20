package br.com.zupacademy.israel.casadocodigo.cliente;

import br.com.zupacademy.israel.casadocodigo.estado.Estado;
import br.com.zupacademy.israel.casadocodigo.pais.Pais;
import br.com.zupacademy.israel.casadocodigo.validator.CPFOrCNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @CPFOrCNPJ
    @NotBlank
    private  String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public Cliente() {
    }

    public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobreNome, @NotBlank String documento,
                   @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais,
                   Estado estado, @NotBlank String telefone, @NotBlank String cep) {

        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }
}
