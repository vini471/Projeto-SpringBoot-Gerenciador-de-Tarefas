package com.senai.gerTarefas.service;

import com.senai.gerTarefas.StatusTarefa;
import com.senai.gerTarefas.dto.TarefaDto;
import com.senai.gerTarefas.entity.TarefaEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {
    List<TarefaEntity> listaDeTarefa = new ArrayList<>();

    public boolean adcionaTarefa(TarefaDto dto) {
        for (TarefaEntity busca : listaDeTarefa) {
            if (busca.getNome().equals(dto.getNome())) {
                System.out.println("A tarefa com o mesmo nome já existente!");
                return false;
            }
        }
        TarefaEntity tarefaEntity = new TarefaEntity();

        tarefaEntity.setNome(dto.getNome());
        tarefaEntity.setDescricao(dto.getDescricao());
        tarefaEntity.setStatus(StatusTarefa.PENDENTE);


        listaDeTarefa.add(tarefaEntity);
        return true;
    }

    public boolean deletaTarefa(TarefaDto dto) {
        for (TarefaEntity busca : listaDeTarefa) {
            if (busca.getNome().equals(dto.getNome())) {
                System.out.println("A tarefa foi deletada com sucesso!");

                listaDeTarefa.remove(busca);
                System.out.println("Usuario deletado com sucesso!");

                return true;
            }
        }
        System.out.println("Usuario não encontrado, tente novamente!");
        return false;
    }

    public boolean atualizaTarefa(TarefaDto dto, String nome){
        for (TarefaEntity busca : listaDeTarefa){
            if (busca.getNome().equals(dto.getNome())){
                System.out.println("Taefa encontrada!");

                busca.setNome(dto.getNome());
                busca.setDescricao(dto.getDescricao());
                busca.setStatus(dto.getStatus());

                return true;
            }
        }
        System.out.println("Tarefa não encontrada! tente novamente!");
        return false;
    }

    public List<TarefaEntity> exibeTarefa(){
        for (TarefaEntity n : listaDeTarefa){
            System.out.println(n);
        }
        return listaDeTarefa;
    }
}
