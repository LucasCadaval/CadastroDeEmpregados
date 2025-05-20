package com.lucas.cadastrodeempregados.tarefas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public TarefaService (TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    /* Busca todas as tarefas */
    public List<TarefaDTO> getAll() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream()
                .map(tarefaMapper::map)
                .collect(Collectors.toList());
    }

    /* Busca tarefa pelo id */
    public TarefaDTO getById(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(tarefaMapper::map).orElse(null);
    }

    /* Cria nova tarefa */
    public TarefaDTO add(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.map(tarefaDTO);
        tarefa = tarefaRepository.save(tarefa);
        return tarefaMapper.map(tarefa);
    }

    /* Atualiza tarefa por id */
    public TarefaDTO update(Long id, TarefaDTO tarefaDTO) {
        Optional<Tarefa> tarefaToUpdate = tarefaRepository.findById(id);
        if(tarefaToUpdate.isPresent()) {
            Tarefa tarefaUpdated = tarefaMapper.map(tarefaDTO);
            tarefaUpdated.setId(id);
            Tarefa tarefaSaved = tarefaRepository.save(tarefaUpdated);

            return tarefaMapper.map(tarefaSaved);
        }
        return null;
    }

    /* Deleta tarefa por id */
    public void delete(Long id) {
        tarefaRepository.deleteById(id);
    }
}
