package com.projeto.pos.apibiblioteca.service;

import com.projeto.pos.apibiblioteca.model.dtos.LivroDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface LivroService {

    Page<LivroDto> findAll(Pageable pagination);
    LivroDto save(LivroDto livroDto);
    LivroDto update(UUID id, LivroDto livroDto);
    void deleteById(UUID id);
}
