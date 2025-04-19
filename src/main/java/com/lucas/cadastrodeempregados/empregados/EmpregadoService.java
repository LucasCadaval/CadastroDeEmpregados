package com.lucas.cadastrodeempregados.empregados;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    private final EmpregadoRepository empregadoRepository;

    public EmpregadoService(EmpregadoRepository empregadoRepository) {
        this.empregadoRepository = empregadoRepository;
    }

    /* Busca todos os empregados */
    public List<Empregado> getAll() {
        return empregadoRepository.findAll();
    }

    /* Busca empregado pelo id */
    public Empregado getById(int id) {
        return empregadoRepository.findById(id).orElse(null);
    }

    /* Cria novo empregado */
    public Empregado add(Empregado empregado) {
        return empregadoRepository.save(empregado);
    }

    /* Atualiza empregado por id */
    public Empregado update(int id, Empregado empregado) {
        Optional<Empregado> empregadoToUpate = empregadoRepository.findById(id);
        if(empregadoToUpate.isPresent()) {
            Empregado empregadoUpdated = empregadoToUpate.get();
            empregadoUpdated.setNome(empregado.getNome());
            empregadoUpdated.setCep(empregado.getCep());
            empregadoUpdated.setCpf(empregado.getCpf());
            empregadoUpdated.setEmail(empregado.getEmail());
            empregadoUpdated.setEndereco(empregado.getEndereco());
            empregadoUpdated.setTarefa(empregado.getTarefa());

            return empregadoRepository.save(empregadoUpdated);
        }
        return null;
    }

    /* Deleta empregado por id */
    public void delete(int id) {
        empregadoRepository.deleteById(id);
    }
}
