package com.dwbooks.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity 

public class Categoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Livro> livros = new ArrayList<>();
}