package com.lucas.cadastrodeempregados.empregados;

import com.lucas.cadastrodeempregados.tarefas.Tarefa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "empregados")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "tarefa")
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String cep;

    private String endereco;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;

}
