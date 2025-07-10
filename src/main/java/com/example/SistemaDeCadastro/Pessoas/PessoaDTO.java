package com.example.SistemaDeCadastro.Pessoas;

import com.example.SistemaDeCadastro.Trabalhos.TrabalhosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private TrabalhosModel trabalhos;


}
