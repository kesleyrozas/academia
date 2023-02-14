package com.academia.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa", nullable = false)
    private Long id;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "sexo", length = 1)
    private String sexo;

    @Column(name = "dtnascimento")
    private String nascimento;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "altura")
    private Integer altura;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "email")
    private String email;

    @Column(name = "funcao")
    private String funcao;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "turno")
    private String turno;

    @Column(name = "tipocadastro", length = 1)
    private Integer tipoCadastro;

}
