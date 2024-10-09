package com.example.livro.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_Livro")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column(name = "titulo", length = 75)
    private String titulo;

    @Column(name = "autor", length = 150)
    private String autor;

    @Column(name = "ano_publicacao")
    private Double ano_publicacao;

    @Column(name = "preco")
    private Double preco;
}


