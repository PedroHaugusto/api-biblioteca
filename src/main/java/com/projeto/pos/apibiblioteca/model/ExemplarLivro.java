package com.projeto.pos.apibiblioteca.model;

import com.projeto.pos.apibiblioteca.model.enuns.StatusConservacao;
import com.projeto.pos.apibiblioteca.model.enuns.StatusLivro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_exemplares")
public class ExemplarLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private StatusConservacao statusConservacao;

    @Enumerated(EnumType.STRING)
    private StatusLivro statusLivro;
}
