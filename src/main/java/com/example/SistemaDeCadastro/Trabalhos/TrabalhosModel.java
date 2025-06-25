package com.example.SistemaDeCadastro.Trabalhos;

import com.example.SistemaDeCadastro.Pessoas.PessoaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //transformando uma classe em uma entidade para ser usado no db
@Table(name = "tb_trabalhos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrabalhosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String cargo;
    private int cargaHoraria;
    @OneToMany(mappedBy = "trabalhos")
    private List<PessoaModel> pessoa;



}
