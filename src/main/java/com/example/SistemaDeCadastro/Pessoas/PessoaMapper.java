package com.example.SistemaDeCadastro.Pessoas;

import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {
    public PessoaModel map(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(pessoaDTO.getId());
        pessoaModel.setEmail(pessoaDTO.getEmail());
        pessoaModel.setNome(pessoaDTO.getNome());
        pessoaModel.setIdade(pessoaDTO.getIdade());
        pessoaModel.setTrabalhos(pessoaDTO.getTrabalhos());

        return pessoaModel;
    }

    public PessoaDTO map(PessoaModel pessoaModel){
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoaModel.getId());
        pessoaDTO.setEmail(pessoaModel.getEmail());
        pessoaDTO.setNome(pessoaModel.getNome());
        pessoaDTO.setIdade(pessoaModel.getIdade());
        pessoaDTO.setTrabalhos(pessoaModel.getTrabalhos());

        return pessoaDTO;
    }
}
