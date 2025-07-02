package com.example.SistemaDeCadastro.Trabalhos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabalhosService {

    private TrabalhosRepository trabalhosRepository;

    public TrabalhosService(TrabalhosRepository trabalhosRepository) {
        this.trabalhosRepository = trabalhosRepository;
    }

    public List<TrabalhosModel> exibirTodosTrabalhos(){
        return trabalhosRepository.findAll();
    }
}
