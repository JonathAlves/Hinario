package com.newagesoft.hinario.model;

import com.newagesoft.hinario.util.FaixaEtaria;
import com.newagesoft.hinario.util.Tema;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "hino")
@Getter
@Setter
@EqualsAndHashCode
public class Hino implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "number", nullable = false)
    private Long number;
    @Lob
    private String letra;
    @Column(name = "autor", nullable = false)
    private String autor;
    @Enumerated(EnumType.STRING)
    private Tema tema;
    @Enumerated(EnumType.STRING)
    private FaixaEtaria faixaEtaria;
    @Column(nullable = false)
    private String isAvulso;
}
