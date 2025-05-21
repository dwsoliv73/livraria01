package com.dwbooks.controllers;

import com.dwbooks.model.Categoria;
import com.dwbooks.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepo;

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return categoriaRepo.save(categoria);
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepo.findAll();
    }
}
