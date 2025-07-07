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

    //Adicionar um trabalho (http://localhost:8057/trabalhos/adicionarTrabalho)
    @PostMapping("/adicionarTrabalho")
    public TrabalhosModel adicionarTrabalho(@RequestBody TrabalhosModel trabalho){
        return trabalhosService.adicionarTrbalho(trabalho);
    }

    //Procurar um trabalho por ID (http://localhost:8057/trabalhos/exibirTrabalho/?)
    @GetMapping("/exibirTrabalho/{id}")
    public TrabalhosModel exibirPorID(@PathVariable Long id){
        return trabalhosService.exibirTrabalhoPorID(id);
    }

    //Exibir todos os trabalhos (http://localhost:8057/trabalhos/exibirTodosTrabalhos)
    @GetMapping("/exibirTodosTrabalhos")
    public List<TrabalhosModel> exibirTrabalhos(){
        return trabalhosService.exibirTodosTrabalhos();
    }

    //Atualizar as informações de um tabalho (http://localhost:8057/trabalhos/atualizarTrabalho/?)
    @PutMapping("/atualizarTrabalho/{id}")
    public TrabalhosModel atualizarTrabalho(@PathVariable Long id, @RequestBody TrabalhosModel trabalhoAtualizado){
        return trabalhosService.atualizarTrabalhoPorID(id, trabalhoAtualizado);
    }

    //Deletar um trabalho (http://localhost:8057/trabalhos/deletarTrabalho/?)
    @DeleteMapping("/deletarTrabalho/{id}")
    public void deletarPorID(@PathVariable Long id){
        trabalhosService.deletarTrabalhoPorID(id);
    }
}