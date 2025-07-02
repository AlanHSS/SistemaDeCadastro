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

    //Adicionar um funcionários
    @PostMapping("/adicionarFuncionario")
    public String adicionar(){
        return "Adicionar funcionario";
    }

    //Procurar um funcionários
    @GetMapping("/buscarIDFuncionario")
    public String buscar(){
        return "Buscar funcionario";
    }

    //Exibir todos os funcionários
    @GetMapping("/todosFuncionaris")
    public List<PessoaModel> exibirTodos(){
        return pessoaService.exibirTodosFuncionarios();
    }

    //Atualizar os dados de um funcionário
    @PutMapping("/alterarIDFuncionario")
    public String alterarDados(){
        return "Atualizar dados dos funcionários";
    }

    //Deletar um funiconário
    @DeleteMapping("/deletarIDFuncionario")
    public String deletar(){
        return "Deletar funcionário";
    }

}
