package com.projeto.pos.apibiblioteca.service;

import com.projeto.pos.apibiblioteca.model.Livro;
import com.projeto.pos.apibiblioteca.model.dtos.LivroDto;
import com.projeto.pos.apibiblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService{

    private final LivroRepository livroRepository;

    @Override
    public Page<LivroDto> findAll(Pageable pagination){
        return livroRepository.findAll(pagination).map((p)-> new LivroDto(p));
    }

    @Transactional
    @Override
    public LivroDto save(LivroDto livroDto){
        var livro = Livro.fromDto(livroDto);
        return new LivroDto(livroRepository.save(livro));
    }
}
