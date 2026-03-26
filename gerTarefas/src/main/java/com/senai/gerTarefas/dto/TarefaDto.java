package com.senai.gerTarefas.dto;

import com.senai.gerTarefas.entity.TarefaEntity;
import com.senai.gerTarefas.StatusTarefa;


public class TarefaDto {
    private String nome, descricao;
    private StatusTarefa status = StatusTarefa.PENDENTE;

    public TarefaDto() {
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
}
