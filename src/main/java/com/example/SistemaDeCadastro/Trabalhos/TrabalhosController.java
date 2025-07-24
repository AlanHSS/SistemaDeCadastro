package com.example.SistemaDeCadastro.Trabalhos;

import com.example.SistemaDeCadastro.Pessoas.PessoaDTO;
import com.example.SistemaDeCadastro.Pessoas.PessoaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trabalhos")
public class TrabalhosController {

    private final TrabalhosService trabalhosService;

    public TrabalhosController(TrabalhosService trabalhosService) {
        this.trabalhosService = trabalhosService;
    }

    //Adicionar um trabalho (http://localhost:8057/trabalhos/adicionarTrabalho)
    @PostMapping("/adicionarTrabalho")
    public ResponseEntity<String> adicionarTrabalho(@RequestBody TrabalhosDTO trabalho){
        TrabalhosDTO novoTrabalho = trabalhosService.adicionarTrabalho(trabalho);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Novo trabalho cadastrado com sucesso!");
    }

    //Procurar um trabalho por ID (http://localhost:8057/trabalhos/exibirTrabalho/?)
    @GetMapping("/exibirTrabalho/{id}")
    public ResponseEntity<?> exibirPorID(@PathVariable Long id){
        TrabalhosDTO mostarTrab = trabalhosService.exibirTrabalhoPorID(id);

        if (mostarTrab != null){
            return ResponseEntity.ok(mostarTrab);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Este ID do funcionario não foi encontrado!");
        }
    }

    //Exibir todos os trabalhos (http://localhost:8057/trabalhos/exibirTodosTrabalhos)
    @GetMapping("/exibirTodosTrabalhos")
    public List<TrabalhosDTO> exibirTrabalhos(){
        return trabalhosService.exibirTodosTrabalhos();
    }

    //Atualizar as informações de um trabalho (http://localhost:8057/trabalhos/atualizarTrabalho/?)
    @PutMapping("/atualizarTrabalho/{id}")
    public ResponseEntity<?> atualizarTrabalho(@PathVariable Long id, @RequestBody TrabalhosDTO trabalhoAtualizado){
        TrabalhosDTO trabAtualizado = trabalhosService.atualizarTrabalhoPorID(id, trabalhoAtualizado);

        if (trabAtualizado != null){
            return ResponseEntity.ok(trabAtualizado);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Este ID do trabalho não foi encontrado!");
        }
    }

    //Deletar um trabalho (http://localhost:8057/trabalhos/deletarTrabalho/?)
    @DeleteMapping("/deletarTrabalho/{id}")
    public ResponseEntity<String> deletarPorID(@PathVariable Long id){
        if (trabalhosService.exibirTrabalhoPorID(id) != null){
            trabalhosService.deletarTrabalhoPorID(id);
            return ResponseEntity.ok("Trabalho do ID: " + id + " foi deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Este ID do trabalho não foi encontrado!");
        }
    }
}