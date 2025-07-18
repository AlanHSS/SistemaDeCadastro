package com.example.SistemaDeCadastro.UiController;
import com.example.SistemaDeCadastro.Pessoas.PessoaDTO;
import com.example.SistemaDeCadastro.Pessoas.PessoaService;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexControllerUi {

    private final PessoaService pessoaService;

    public IndexControllerUi(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    //Exibir Homepage
    @GetMapping("/homepage")
    public String exibirHomepage(){
        return "homepage";
    }

    //Exibir todos os funcionários
    @GetMapping("/exibirTodosFuncionarios")
    public String exibirTodos(Model model){
        List<PessoaDTO> funcionarios = pessoaService.exibirTodosFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "exibirfuncionarios";
    }

    //Adicionar funcionario
    @GetMapping("/adicionarFuncionario")
    public String adicionarFuncionario(Model model){
        model.addAttribute("funcionario", new PessoaDTO());
        return "adicionarfuncionario";
    }

    //Salvar novo funcionário
    @PostMapping("/salvar")
    public String salvarFuncionario(@ModelAttribute PessoaDTO funcioanrio, RedirectAttributes redirectAttributes){
        pessoaService.adicionarFuncionario(funcioanrio);
        redirectAttributes.addFlashAttribute("mensagem", "Novo funcioário cadastrado com sucesso!");
        return "redirect:/index/exibirTodosFuncionarios";
    }

    //Deletar um funcionário
    @GetMapping("/deletarFuncionario/{id}")
    public String deletarPorID(@PathVariable Long id){
        pessoaService.deletarFuncionarioPorID(id);
        return "redirect:/index/exibirTodosFuncionarios";
    }
}
