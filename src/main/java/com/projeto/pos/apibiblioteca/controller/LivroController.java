package com.projeto.pos.apibiblioteca.controller;

import com.projeto.pos.apibiblioteca.model.dtos.LivroDto;
import com.projeto.pos.apibiblioteca.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<Page<LivroDto>> findAll(@PageableDefault(size = 10, direction = Sort.Direction.ASC)Pageable pagination){
        return ResponseEntity.ok(livroService.findAll(pagination));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroDto> save(@Valid @RequestBody LivroDto livroDto, UriComponentsBuilder uriBuilder){
        var livroDtoSaved = livroService.save(livroDto);
        URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livroDtoSaved.id()).toUri();
        return ResponseEntity.created(uri).body(livroDtoSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> update(@PathVariable("id") UUID id, @Valid @RequestBody LivroDto livroDto){
        return ResponseEntity.ok(livroService.update(id, livroDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        livroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}