package com.lucas.cadastrodeempregados.empregados;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpregadoService {

    private final EmpregadoRepository empregadoRepository;
    private final EmpregadoMapper empregadoMapper;

    public EmpregadoService(EmpregadoRepository empregadoRepository, EmpregadoMapper empregadoMapper) {
        this.empregadoRepository = empregadoRepository;
        this.empregadoMapper = empregadoMapper;
    }

    /* Busca todos os empregados */
    public List<EmpregadoDTO> getAll() {
        List<Empregado> empregados = empregadoRepository.findAll();
        return empregados.stream()
                .map(empregadoMapper::map)
                .collect(Collectors.toList());
    }

    /* Busca empregado pelo id */
    public EmpregadoDTO getById(Long id) {
        Optional<Empregado> empregado = empregadoRepository.findById(id);
        return empregado.map(empregadoMapper::map).orElse(null);
    }

    /* Cria novo empregado */
    public EmpregadoDTO add(EmpregadoDTO empregadoDTO) {
        Empregado empregado = empregadoMapper.map(empregadoDTO);
        empregado = empregadoRepository.save(empregado);
        return empregadoMapper.map(empregado);
    }

    /* Atualiza empregado por id */
    public EmpregadoDTO update(Long id, EmpregadoDTO empregadoDTO) {
        Optional<Empregado> empregadoToUpate = empregadoRepository.findById(id);
        if(empregadoToUpate.isPresent()) {
            Empregado empregadoUpdated = empregadoMapper.map(empregadoDTO);
            empregadoUpdated.setId(id);
            Empregado empregadoSaved = empregadoRepository.save(empregadoUpdated);
            return empregadoMapper.map(empregadoSaved);
        }
        return null;
    }

    /* Deleta empregado por id */
    public void delete(Long id) {
        empregadoRepository.deleteById(id);
    }
}
