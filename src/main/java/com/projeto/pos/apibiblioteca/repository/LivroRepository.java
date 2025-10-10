package com.projeto.pos.apibiblioteca.repository;

import com.projeto.pos.apibiblioteca.model.Livro;
import com.projeto.pos.apibiblioteca.model.dtos.LivroDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
    LivroDto findByTitulo(LivroDto livroDto);
}
