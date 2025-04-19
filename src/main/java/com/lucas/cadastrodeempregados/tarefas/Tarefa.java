package com.lucas.cadastrodeempregados.tarefas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucas.cadastrodeempregados.empregados.Empregado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "tarefas")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private String descricao;

    @OneToMany(mappedBy = "tarefa")
    @JsonIgnore
    private List<Empregado> empregados;
}
