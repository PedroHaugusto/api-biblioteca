package com.projeto.pos.apibiblioteca.model;

import com.projeto.pos.apibiblioteca.model.dtos.LivroDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @Column(length = 255, nullable = false)
    private String descricao;

    @NotNull
    private Integer qtdePaginas;

    @ManyToMany
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_id")
    private List<ExemplarLivro> exemplares;

    public Livro(UUID id, String titulo, String descricao, Integer qtdePaginas) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.qtdePaginas = qtdePaginas;
    }

    public static Livro fromDto(LivroDto livroDto){
        return new Livro(livroDto.id(),
                livroDto.titulo(),
                livroDto.descricao(),
                livroDto.qtdePaginas());
    }
}
