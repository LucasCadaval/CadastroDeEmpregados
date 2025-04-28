package com.lucas.cadastrodeempregados.empregados;

import org.springframework.stereotype.Component;

@Component
public class EmpregadoMapper {

    public Empregado map(EmpregadoDTO empregadoDTO) {
        Empregado empregado = new Empregado();
        empregado.setId(empregadoDTO.getId());
        empregado.setNome(empregadoDTO.getNome());
        empregado.setCpf(empregadoDTO.getCpf());
        empregado.setEmail(empregadoDTO.getEmail());
        empregado.setCep(empregadoDTO.getCep());
        empregado.setEndereco(empregadoDTO.getEndereco());
        empregado.setTarefa(empregadoDTO.getTarefa());

        return empregado;
    }

    public EmpregadoDTO map(Empregado empregado) {
        EmpregadoDTO empregadoDTO = new EmpregadoDTO();
        empregadoDTO.setId(empregado.getId());
        empregadoDTO.setNome(empregado.getNome());
        empregadoDTO.setCpf(empregado.getCpf());
        empregadoDTO.setEmail(empregado.getEmail());
        empregadoDTO.setCep(empregado.getCep());
        empregadoDTO.setEndereco(empregado.getEndereco());
        empregadoDTO.setTarefa(empregado.getTarefa());

        return empregadoDTO;
    }
 }
