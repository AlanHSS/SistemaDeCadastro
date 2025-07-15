package com.example.SistemaDeCadastro.Trabalhos;

import com.example.SistemaDeCadastro.Pessoas.PessoaDTO;
import com.example.SistemaDeCadastro.Pessoas.PessoaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrabalhosService {

    private final TrabalhosRepository trabalhosRepository;
    private final TrabalhosMapper trabalhosMapper;

    public TrabalhosService(TrabalhosRepository trabalhosRepository, TrabalhosMapper trabalhosMapper) {
        this.trabalhosRepository = trabalhosRepository;
        this.trabalhosMapper = trabalhosMapper;
    }

    //Adicionar um trabalho
    public TrabalhosDTO adicionarTrabalho(TrabalhosDTO trabalhosDTO){
        TrabalhosModel trabalho = trabalhosMapper.map(trabalhosDTO);
        trabalho = trabalhosRepository.save(trabalho);
        return trabalhosMapper.map(trabalho);
    }

    //Exibir todos os trabalhos
    public List<TrabalhosDTO> exibirTodosTrabalhos(){
        List<TrabalhosModel> trabalhos = trabalhosRepository.findAll();
        return trabalhos.stream()
                .map(trabalhosMapper::map)
                .collect(Collectors.toList());
    }

    //Procurar um trabalho por iD
    public TrabalhosDTO exibirTrabalhoPorID(Long id){
        Optional<TrabalhosModel> exibirPorID = trabalhosRepository.findById(id);
        return exibirPorID.map(trabalhosMapper::map).orElse(null);
    }

    //Atualizar as informações de um trabalho
    public TrabalhosDTO atualizarTrabalhoPorID(Long id, TrabalhosDTO trabalhosDTO){
        Optional<TrabalhosModel> trabalhoExistente = trabalhosRepository.findById(id);
        if (trabalhoExistente.isPresent()){
            TrabalhosModel trabalhoAtualizado = trabalhosMapper.map(trabalhosDTO);
            trabalhoAtualizado.setId(id);
            TrabalhosModel trabalhoSave = trabalhosRepository.save(trabalhoAtualizado);
            return trabalhosMapper.map(trabalhoSave);
        }
        return null;
    }

    //Deletar um trabalo
    public void deletarTrabalhoPorID(Long id){
        trabalhosRepository.deleteById(id);
    }
}