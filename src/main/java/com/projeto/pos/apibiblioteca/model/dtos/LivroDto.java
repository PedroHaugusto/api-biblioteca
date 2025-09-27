package com.projeto.pos.apibiblioteca.model.dtos;

import com.projeto.pos.apibiblioteca.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record LivroDto(UUID id,
                       @NotBlank String titulo,
                       @NotBlank String descricao,
                       @NotNull Integer qtdePaginas) {

    public LivroDto(Livro livro){
        this(livro.getId(),
                livro.getTitulo(),
                livro.getDescricao(),
                livro.getQtdePaginas());
    }
}
