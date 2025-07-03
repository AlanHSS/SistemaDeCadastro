package com.example.SistemaDeCadastro.Trabalhos;

import com.example.SistemaDeCadastro.Pessoas.PessoaModel;
import org.springframework.web.bind.annotation.*;

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

    //Procurar um trabalho por ID
    @GetMapping("/exibirTrabalho/{id}")
    public TrabalhosModel exibirPorID(@PathVariable Long id){
        return trabalhosService.exibirTrabalhoPorID(id);
    }

    //Exibir todos os trabalhos
    @GetMapping("/exibirTodosTrabalhos")
    public List<TrabalhosModel> exibirTrabalhos(){
        return trabalhosService.exibirTodosTrabalhos();
    }
}