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
    public List<Tarefa> getAll() {
        return tarefaService.getAll();
    }

    @GetMapping("/get/{id}")
    public Tarefa getById(@PathVariable Long id) {
        return tarefaService.getById(id);
    }

    @PostMapping("/add")
    public Tarefa add(@RequestBody Tarefa tarefa) {
        return tarefaService.add(tarefa);
    }

    @PutMapping("/update/{id}")
    public Tarefa update(@PathVariable Long id,@RequestBody Tarefa tarefa) {
        return tarefaService.update(id, tarefa);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        tarefaService.delete(id);
    }
}
