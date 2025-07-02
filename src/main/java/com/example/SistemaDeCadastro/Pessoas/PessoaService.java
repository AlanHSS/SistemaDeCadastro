package com.example.SistemaDeCadastro.Pessoas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    //Exibir todos os funcionários
    public List<PessoaModel> exibirTodosFuncionarios(){
        return pessoaRepository.findAll();
    }

}
