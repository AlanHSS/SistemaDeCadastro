package com.example.SistemaDeCadastro.Trabalhos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TrabalhosController {
    @GetMapping("/trabalhostabela")
    public String boasVindas(){
        return "Tabela de Trabalhos";
    }
}
