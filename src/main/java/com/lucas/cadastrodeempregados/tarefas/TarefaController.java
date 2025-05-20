package com.lucas.cadastrodeempregados.tarefas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController (TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/get")
    public List<TarefaDTO> getAll() {
        return tarefaService.getAll();
    }

    @GetMapping("/get/{id}")
    public TarefaDTO getById(@PathVariable Long id) {
        return tarefaService.getById(id);
    }

    @PostMapping("/add")
    public TarefaDTO add(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.add(tarefaDTO);
    }

    @PutMapping("/update/{id}")
    public TarefaDTO update(@PathVariable Long id,@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.update(id, tarefaDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        tarefaService.delete(id);
    }
}
