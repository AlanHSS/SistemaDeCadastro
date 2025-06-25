package com.example.SistemaDeCadastro.Pessoas;

import com.example.SistemaDeCadastro.Trabalhos.TrabalhosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity //transformando uma classe em uma entidade para ser usado no db
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private int idade;
    @Column(unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "trablhos_id")
    private TrabalhosModel trabalhos;
}
