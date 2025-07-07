package com.example.SistemaDeCadastro.Trabalhos;

import com.example.SistemaDeCadastro.Pessoas.PessoaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhosService {

    private TrabalhosRepository trabalhosRepository;

    public TrabalhosService(TrabalhosRepository trabalhosRepository) {
        this.trabalhosRepository = trabalhosRepository;
    }

    //Adicionar um trabalho
    public TrabalhosModel adicionarTrbalho(TrabalhosModel trabalho){
        return trabalhosRepository.save(trabalho);
    }

    //Exibir todos os trabalhos
    public List<TrabalhosModel> exibirTodosTrabalhos(){
        return trabalhosRepository.findAll();
    }

    //Procurar um trabalho por iD
    public TrabalhosModel exibirTrabalhoPorID(Long id){
        Optional<TrabalhosModel> exibirPorID = trabalhosRepository.findById(id);
        return exibirPorID.orElse(null);
    }

    //Deletar um trabalo
    public void deletarTrabalhoPorID(Long id){
        trabalhosRepository.deleteById(id);
    }
}