package com.example.SistemaDeCadastro.Pessoas;

import com.example.SistemaDeCadastro.Trabalhos.TrabalhosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity //transformando uma classe em uma entidade para ser usado no db
@Table(name = "tb_cadastro")
@Data //getters e setters usando lombok
@NoArgsConstructor
@AllArgsConstructor
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Idade")
    private int idade;

    @Column(unique = true, name = "E-mail")
    private String email;

    @ManyToOne
    @JoinColumn(name = "trablhos_id")
    private TrabalhosModel trabalhos;



}
