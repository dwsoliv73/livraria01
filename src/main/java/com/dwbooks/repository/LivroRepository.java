package com.dwbooks.repository;

import com.dwbooks.model.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Page<Livro> findByCategoriaId(Long categoriaId, Pageable pageable);
}
