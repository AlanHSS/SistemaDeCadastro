package com.example.SistemaDeCadastro.Pessoas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaMapper pessoaMapper;

    public PessoaService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    //Adicionar um funcionário
    public PessoaDTO adicionarFuncionario(PessoaDTO pessoaDTO){
        PessoaModel funcionario = pessoaMapper.map(pessoaDTO);
        funcionario = pessoaRepository.save(funcionario);
        return pessoaMapper.map(funcionario);
    }

    //Exibir todos os funcionários
    public List<PessoaDTO> exibirTodosFuncionarios(){
        List<PessoaModel> funcionarios = pessoaRepository.findAll();
        return funcionarios.stream()
                .map(pessoaMapper::map)
                .collect(Collectors.toList());
    }

    //Procurar um funcionários por iD
    public PessoaDTO exibirFuncionarioPorID(Long id){
        Optional<PessoaModel> exibirPorID = pessoaRepository.findById(id);
        return exibirPorID.map(pessoaMapper::map).orElse(null);
    }

    //Atualizar os dados de um funcionário
    public PessoaDTO atualizarFuncionarioPorID(Long id, PessoaDTO pessoaDTO){
        Optional<PessoaModel> funcionarioExistente = pessoaRepository.findById(id);
        if (funcionarioExistente.isPresent()){
            PessoaModel funcionarioAtualizado = pessoaMapper.map(pessoaDTO);
            funcionarioAtualizado.setId(id);
            PessoaModel funcionarioSave = pessoaRepository.save(funcionarioAtualizado);
            return pessoaMapper.map(funcionarioSave);
        }
        return null;
    }

    //Deletar um funiconário
    public void deletarFuncionarioPorID(Long id){
        pessoaRepository.deleteById(id);
    }

}