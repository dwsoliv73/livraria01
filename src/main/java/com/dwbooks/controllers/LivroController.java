package com.dwbooks.controllers;

import com.dwbooks.model.Livro;
import com.dwbooks.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepo;

    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return livroRepo.save(livro);
    }

    @GetMapping
    public Page<Livro> listar(Pageable pageable) {
        return livroRepo.findAll(pageable);
    }

    @GetMapping("/categoria/{id}")
    public Page<Livro> porCategoria(@PathVariable Long id, Pageable pageable) {
        return livroRepo.findByCategoriaId(id, pageable);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro novoLivro) {
        Livro livro = livroRepo.findById(id).orElseThrow();
        livro.setTitulo(novoLivro.getTitulo());
        livro.setAutor(novoLivro.getAutor());
        livro.setCategoria(novoLivro.getCategoria());
        return livroRepo.save(livro);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        livroRepo.deleteById(id);
    }
}
