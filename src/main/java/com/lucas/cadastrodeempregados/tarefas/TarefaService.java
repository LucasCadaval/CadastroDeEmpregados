package com.lucas.cadastrodeempregados.tarefas;

import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService (TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    /* Busca todas as tarefas */
    public List<Tarefa> getAll() {
        return tarefaRepository.findAll();
    }

    /* Busca tarefa pelo id */
    public Tarefa getById(int id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    /* Cria nova tarefa */
    public Tarefa add(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    /* Atualiza tarefa por id */
    public Tarefa update(int id, Tarefa tarefa) {
        Optional<Tarefa> tarefaToUpdate = tarefaRepository.findById(id);
        if(tarefaToUpdate.isPresent()) {
            Tarefa tarefaUpdated = tarefaToUpdate.get();
            tarefaUpdated.setTitulo(tarefa.getTitulo());
            tarefaUpdated.setDescricao(tarefa.getDescricao());

            return tarefaRepository.save(tarefaUpdated);
        }
        return null;
    }

    /* Deleta tarefa por id */
    public void delete(int id) {
        tarefaRepository.deleteById(id);
    }
}
