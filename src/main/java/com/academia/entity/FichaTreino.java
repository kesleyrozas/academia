package com.academia.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity(name="ficha_treino")
public class FichaTreino {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha_treino", nullable = false)
    private Long id;

    @NotNull(message = "Pessoa obrigatorio")
    @ManyToOne
    @JoinColumn(name="id_pessoa")
    private Pessoa pessoa;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="id_exercicio")
    private List<Exercicio> exercicios;

    @Column(name="numero")
    private Integer numero;

    @Column(name="quantidade")
    private Integer quantidade;

}
