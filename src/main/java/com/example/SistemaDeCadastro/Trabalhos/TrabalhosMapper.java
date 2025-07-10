package com.example.SistemaDeCadastro.Trabalhos;

public class TrabalhosMapper {
    public TrabalhosModel map(TrabalhosDTO trabalhosDTO){
        TrabalhosModel trabalhosModel = new TrabalhosModel();
        trabalhosModel.setId(trabalhosDTO.getId());
        trabalhosModel.setCargo(trabalhosDTO.getCargo());
        trabalhosModel.setCargaHoraria(trabalhosDTO.getCargaHoraria());
        trabalhosModel.setPessoa(trabalhosDTO.getPessoa());

        return trabalhosModel;
    }

    public TrabalhosDTO map(TrabalhosModel trabalhosModel){
        TrabalhosDTO trabalhosDTO = new TrabalhosDTO();
        trabalhosDTO.setId(trabalhosModel.getId());
        trabalhosDTO.setCargo(trabalhosModel.getCargo());
        trabalhosDTO.setCargaHoraria(trabalhosModel.getCargaHoraria());
        trabalhosDTO.setPessoa(trabalhosModel.getPessoa());

        return trabalhosDTO;
    }
}
