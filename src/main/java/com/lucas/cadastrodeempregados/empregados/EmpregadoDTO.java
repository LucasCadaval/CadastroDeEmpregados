package com.lucas.cadastrodeempregados.empregados;

import com.lucas.cadastrodeempregados.tarefas.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpregadoDTO {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String cep;

    private String endereco;

    private Tarefa tarefa;
}
