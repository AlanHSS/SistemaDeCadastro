package com.example.SistemaDeCadastro.Pessoas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    //Rota principal
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Homepage";
    }

    //Adicionar um funcionários (http://localhost:8057/funcionarios/adicionarFuncionario)
    @PostMapping("/adicionarFuncionario")
    public ResponseEntity<String> adicionarFuncionario(@RequestBody PessoaDTO funcionario){
        PessoaDTO novoFuncionario = pessoaService.adicionarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Novo funcionário cadastrado com sucesso!");
    }

    //Procurar um funcionário por ID (http://localhost:8057/funcionarios/exibirFuncionario/?)
    @GetMapping("/exibirFuncionario/{id}")
    public ResponseEntity<?> exibirPorID(@PathVariable Long id){
        PessoaDTO mostrarFunc = pessoaService.exibirFuncionarioPorID(id);

        if (mostrarFunc != null){
            return ResponseEntity.ok(mostrarFunc);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Este ID do funcionario não foi encontrado!");
        }
    }

    //Exibir todos os funcionários (http://localhost:8057/funcionarios/exibirTodosFuncionarios)
    @GetMapping("/exibirTodosFuncionarios")
    public List<PessoaDTO> exibirTodos(){
        return pessoaService.exibirTodosFuncionarios();
    }

    //Atualizar os dados de um funcionário (http://localhost:8057/funcionarios/atualizarFuncionario/?)
    @PutMapping("/atualizarFuncionario/{id}")
    public ResponseEntity<?> atualizarFuncionario(@PathVariable Long id, @RequestBody PessoaDTO funcionarioAtualizado){
        PessoaDTO funcAtualizado = pessoaService.atualizarFuncionarioPorID(id, funcionarioAtualizado);

        if (funcAtualizado != null){
            return ResponseEntity.ok(funcAtualizado);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Este ID do funcionario não foi encontrado!");
        }
    }

    //Deletar um funiconário (http://localhost:8057/funcionarios/deletarFuncionario/?)
    @DeleteMapping("/deletarFuncionario/{id}")
    public ResponseEntity<String> deletarPorID(@PathVariable Long id){
        if (pessoaService.exibirFuncionarioPorID(id) != null){
            pessoaService.deletarFuncionarioPorID(id);
            return ResponseEntity.ok("Funcionario do ID: " + id + " foi deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Este ID do funcionario não foi encontrado!");
        }

    }

}