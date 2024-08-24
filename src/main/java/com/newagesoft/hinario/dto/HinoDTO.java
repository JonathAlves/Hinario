package com.newagesoft.hinario.dto;

import com.newagesoft.hinario.util.FaixaEtaria;
import com.newagesoft.hinario.util.Tema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class HinoDTO implements Serializable {
    private Long id;
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 2, max = 50)
    private String name;
    @NotNull(message = "Campo obrigatório")
    private Long number;
    @NotBlank(message = "A letra não pode ser vazia.")
    private String letra;
    private String autor;
    @NotNull(message = "Campo obrigatório")
    private Tema tema;
    @NotNull(message = "Campo obrigatório")
    private FaixaEtaria faixaEtaria;
    @NotBlank(message = "Campo obrigatório")
    private String isAvulso;
}
