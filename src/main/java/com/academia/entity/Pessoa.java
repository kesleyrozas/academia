package com.academia.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa", nullable = false)
    private Long id;

    @Column(name = "nome", length = 80, nullable = false)
    @NotEmpty(message = "O nome deverá ser informado!")
    @Length(min = 5, max = 80, message = "O nome devéra ter de 5 a 80 caracteres")
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false)
    @NotEmpty(message = "O cpf deverá ser informado!")
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
