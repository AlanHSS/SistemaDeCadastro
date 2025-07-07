package com.example.SistemaDeCadastro.Pessoas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class PessoaController {

    private PessoaService pessoaService;

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
    public PessoaModel adicionarFuncionario(@RequestBody PessoaModel funcionario){
        return pessoaService.adicionarFuncionario(funcionario);
    }

    //Procurar um funcionário por ID (http://localhost:8057/funcionarios/exibirFuncionario/?)
    @GetMapping("/exibirFuncionario/{id}")
    public PessoaModel exibirPorID(@PathVariable Long id){
        return pessoaService.exibirFuncionarioPorID(id);
    }

    //Exibir todos os funcionários (http://localhost:8057/funcionarios/exibirTodosFuncionarios)
    @GetMapping("/exibirTodosFuncionarios")
    public List<PessoaModel> exibirTodos(){
        return pessoaService.exibirTodosFuncionarios();
    }

    //Atualizar os dados de um funcionário
    @PutMapping("/alterarIDFuncionario")
    public String alterarDados(){
        return "Atualizar dados dos funcionários";
    }

    //Deletar um funiconário (http://localhost:8057/funcionarios/deletarFuncionario/?)
    @DeleteMapping("/deletarFuncionario/{id}")
    public void deletarPorID(@PathVariable Long id){
        pessoaService.deletarFuncionarioPorID(id);
    }

}