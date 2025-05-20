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
    public List<EmpregadoDTO> getAll() {
        return empregadoService.getAll();
    }

    @GetMapping("/get/{id}")
    public EmpregadoDTO getById(@PathVariable Long id) {
        return empregadoService.getById(id);
    }

    @PostMapping("/add")
    public EmpregadoDTO add(@RequestBody EmpregadoDTO empregadoDTO) {
        return empregadoService.add(empregadoDTO);
    }

    @PutMapping("/update/{id}")
    public EmpregadoDTO update(@PathVariable Long id,@RequestBody EmpregadoDTO empregadoDTO) {
        return empregadoService.update(id, empregadoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        empregadoService.delete(id);
    }
}
