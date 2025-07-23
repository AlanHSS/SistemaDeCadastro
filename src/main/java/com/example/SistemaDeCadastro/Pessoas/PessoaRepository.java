package com.example.SistemaDeCadastro.Pessoas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
    boolean existsByTrabalhosId(Long trabalhoId);

}
