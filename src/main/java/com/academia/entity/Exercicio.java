package com.academia.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="exercicio")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercicio", nullable = false)
    private Long id;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

    @Column(name = "series", nullable = false)
    private Integer series;

    @Column(name = "repeticoes", nullable = false)
    private Integer repeticoes;

    @Column(name = "equipamento", length = 80)
    private String equipamento;

    @ManyToOne
    @JoinColumn(name = "id_ficha_treino")
    private FichaTreino fichaTreino;

}
