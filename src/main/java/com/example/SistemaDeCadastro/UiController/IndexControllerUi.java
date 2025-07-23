package com.example.SistemaDeCadastro.UiController;
import com.example.SistemaDeCadastro.Pessoas.PessoaDTO;
import com.example.SistemaDeCadastro.Pessoas.PessoaService;
import com.example.SistemaDeCadastro.Trabalhos.TrabalhosDTO;
import com.example.SistemaDeCadastro.Trabalhos.TrabalhosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexControllerUi {

    private final PessoaService pessoaService;
    private final TrabalhosService trabalhosService;

    public IndexControllerUi(PessoaService pessoaService, TrabalhosService trabalhosService) {
        this.pessoaService = pessoaService;
        this.trabalhosService = trabalhosService;
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

    //Adicionar novo funcionario
    @GetMapping("/adicionarFuncionario")
    public String adicionarFuncionario(Model model){
        model.addAttribute("funcionario", new PessoaDTO());
        model.addAttribute("listaTrabalhos", trabalhosService.exibirTodosTrabalhos());
        return "adicionarfuncionario";
    }
    @PostMapping("/salvar")
    public String salvarFuncionario(@ModelAttribute PessoaDTO funcioanrio, RedirectAttributes redirectAttributes){
        pessoaService.adicionarFuncionario(funcioanrio);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Funcionario cadastrado com sucesso!");
        return "redirect:/index/exibirTodosFuncionarios";
    }

    //Editar funcionário existente
    @GetMapping("/editarFuncionario/{id}")
    public String editarFuncionario(@PathVariable Long id, Model model, PessoaDTO funcionario){
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("listaTrabalhos", trabalhosService.exibirTodosTrabalhos());
        return "adicionarfuncionario";
    }
    @PostMapping("/alterar/{id}")
    public String editarFuncionario(@PathVariable Long id, @ModelAttribute PessoaDTO funcioanrio, RedirectAttributes redirectAttributes){
        pessoaService.atualizarFuncionarioPorID(id, funcioanrio);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Dados alterados com sucesso!");
        return "redirect:/index/exibirTodosFuncionarios";
    }

    //Deletar um funcionário
    @GetMapping("/deletarFuncionario/{id}")
    public String deletarPorID(@PathVariable Long id, RedirectAttributes redirectAttributes){
        pessoaService.deletarFuncionarioPorID(id);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Funcionário excluído com sucesso.");
        return "redirect:/index/exibirTodosFuncionarios";
    }





    //Exibir todos os trabalhos
    @GetMapping("/exibirTodosTrabalhos")
    public String exibirTodosTrabalhos(Model model){
        List<TrabalhosDTO> trabalhos = trabalhosService.exibirTodosTrabalhos();
        model.addAttribute("trabalhos", trabalhos);
        return "exibirtrabalhos";
    }

    //Adicionar novo trabalho
    @GetMapping("/adicionarTrabalho")
    public String adicionarTrabalho(Model model){
        model.addAttribute("trabalho", new TrabalhosDTO());
        return "adicionartrabalho";
    }
    @PostMapping("/salvarTrabalho")
    public String salvarTrabalho(@ModelAttribute TrabalhosDTO trabalho, RedirectAttributes redirectAttributes){
        trabalhosService.adicionarTrabalho(trabalho);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Trabalho cadastrado com sucesso!");
        return "redirect:/index/exibirTodosTrabalhos";
    }

    //Editar trabalho existente
    @GetMapping("/editarTrabalho/{id}")
    public String editarTrabalho(@PathVariable Long id, Model model, TrabalhosDTO trabalho){
        model.addAttribute("trabalho", trabalho);
        return "adicionartrabalho";
    }
    @PostMapping("/alterarTrabalho/{id}")
    public String editarTrabalho(@PathVariable Long id, @ModelAttribute TrabalhosDTO trabalho, RedirectAttributes redirectAttributes){
        trabalhosService.atualizarTrabalhoPorID(id, trabalho);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Dados alterados com sucesso!");
        return "redirect:/index/exibirTodosTrabalhos";
    }

    //Deletar um trabalho
    @GetMapping("/deletarTrabalho/{id}")
    public String deletarTrabalhoPorID(@PathVariable Long id, RedirectAttributes redirectAttributes){
        if (pessoaService.temFuncionarioComTrabalho(id)) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Não é possível excluir: há funcionários com esse trabalho.");
            return "redirect:/index/exibirTodosTrabalhos";
        }
            trabalhosService.deletarTrabalhoPorID(id);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Trabalho excluído com sucesso.");
            return "redirect:/index/exibirTodosTrabalhos";
    }

}
