package com.lucas.cadastrodeempregados.tarefas;

import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    public Tarefa map(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(tarefaDTO.getId());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setEmpregados(tarefaDTO.getEmpregados());

        return tarefa;
    }

    public TarefaDTO map(Tarefa tarefa) {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setId(tarefa.getId());
        tarefaDTO.setDescricao(tarefa.getDescricao());
        tarefaDTO.setTitulo(tarefa.getTitulo());
        tarefaDTO.setEmpregados(tarefa.getEmpregados());

        return tarefaDTO;
    }
}
