package com.lucas.cadastrodeempregados.tarefas;

import com.lucas.cadastrodeempregados.empregados.Empregado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {

    private Long id;

    private String titulo;

    private String descricao;

    private List<Empregado> empregados;
}
