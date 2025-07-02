package com.example.SistemaDeCadastro.Trabalhos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trabalhos")
public class TrabalhosController {

    private TrabalhosService trabalhosService;

    public TrabalhosController(TrabalhosService trabalhosService) {
        this.trabalhosService = trabalhosService;
    }

    //Rota principal
    @GetMapping("/trabalhostabela")
    public String boasVindas(){
        return "Tabela de Trabalhos";
    }

    //Adicionar um trabalho
    @PostMapping("/adicionarTrabalho")
    public String adicionar(){
        return "Adicionar trabalho";
    }

    //Exibir todos os trabalhos
    @GetMapping("/todosTrabalhos")
    public List<TrabalhosModel> exibirTrabalhos(){
        return trabalhosService.exibirTodosTrabalhos();
    }
}
