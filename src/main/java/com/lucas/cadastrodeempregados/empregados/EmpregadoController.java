package com.lucas.cadastrodeempregados.empregados;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empregado")
public class EmpregadoController {

    private final EmpregadoService empregadoService;

    public EmpregadoController (EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;
    }

    @GetMapping("/get")
    public List<Empregado> getAll() {
        return empregadoService.getAll();
    }

    @GetMapping("/get/{id}")
    public Empregado getById(@PathVariable int id) {
        return empregadoService.getById(id);
    }

    @PostMapping("/add")
    public Empregado add(@RequestBody Empregado empregado) {
        return empregadoService.add(empregado);
    }

    @PutMapping("/update/{id}")
    public Empregado update(@PathVariable int id,@RequestBody Empregado empregado) {
        return empregadoService.update(id, empregado);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        empregadoService.delete(id);
    }
}
