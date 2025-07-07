package com.example.SistemaDeCadastro.Pessoas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    //Adicionar um funcionário
    public PessoaModel adicionarFuncionario(PessoaModel funcionario){
        return pessoaRepository.save(funcionario);
    }

    //Exibir todos os funcionários
    public List<PessoaModel> exibirTodosFuncionarios(){
        return pessoaRepository.findAll();
    }

    //Procurar um funcionários por iD
    public PessoaModel exibirFuncionarioPorID(Long id){
        Optional<PessoaModel> exibirPorID = pessoaRepository.findById(id);
        return exibirPorID.orElse(null);
    }

    //Atualizar os dados de um funcionário
    public PessoaModel atualizarFuncionarioPorID(Long id, PessoaModel funcionarioAtualizado){
        if (pessoaRepository.existsById(id)){
            funcionarioAtualizado.setId(id);
            return pessoaRepository.save(funcionarioAtualizado);
        }
        return null;
    }

    //Deletar um funiconário
    public void deletarFuncionarioPorID(Long id){
        pessoaRepository.deleteById(id);
    }

}