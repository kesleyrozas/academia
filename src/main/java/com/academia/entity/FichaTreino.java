package com.academia.entity;

import jakarta.persistence.*;

@Entity(name="ficha_treino")
public class FichaTreino {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_ficha_treino", nullable = false)
    private Long id_ficha_treino;

    private int numero;

    private int quantidade;

    private long id_pessoa;

    private long id_exercicio;

    public Long getId_ficha_treino() {
        return id_ficha_treino;
    }

    public void setId_ficha_treino(Long id_ficha_treino) {
        this.id_ficha_treino = id_ficha_treino;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public long getId_exercicio() {
        return id_exercicio;
    }

    public void setId_exercicio(long id_exercicio) {
        this.id_exercicio = id_exercicio;
    }
}
