package br.com.zupacademy.israel.casadocodigo.pais;

import br.com.zupacademy.israel.casadocodigo.estado.Estado;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

    @Deprecated
    public Pais() {
    }

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public boolean paisPossuiEstados() {
        return this.estados.size() > 0;
    }
}

