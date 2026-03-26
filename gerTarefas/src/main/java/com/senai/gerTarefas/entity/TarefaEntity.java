package com.senai.gerTarefas.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.senai.gerTarefas.StatusTarefa;

public class TarefaEntity {
    @NotBlank(message = "Tarefa não pode conter espaços em branco!")
    @NotNull(message = "Tarefa não pode ser vazia?")
    private String nome, descricao;

    private StatusTarefa status = StatusTarefa.PENDENTE;

    public TarefaEntity() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Tarefa:\n" +
                "Nome: " + nome + "\n" +
                "Status: " + status + "\n" +
                "Descrição: " + descricao;
    
    }
}
