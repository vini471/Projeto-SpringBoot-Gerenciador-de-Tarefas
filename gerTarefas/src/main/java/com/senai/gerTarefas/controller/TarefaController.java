package com.senai.gerTarefas.controller;

import com.senai.gerTarefas.dto.TarefaDto;
import com.senai.gerTarefas.entity.TarefaEntity;
import com.senai.gerTarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerTarefas")
public class TarefaController {
    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping("/adiciona")
    public ResponseEntity<String> adicionar (@RequestBody TarefaDto tarefaDto){
        boolean resultado = service.adcionaTarefa(tarefaDto);
        if (resultado == false){
            return ResponseEntity.badRequest().body("Não foi possivel adicionar nova tarefa, " +
                    "verifique e tente novamente!");
        }
        return ResponseEntity.ok().body("Tarefa adicionada com sucesso!");
    }

    @PostMapping("/deleta")
    public ResponseEntity<String> deletar (@RequestBody TarefaDto tarefaDto){
        boolean resultado = service.deletaTarefa(tarefaDto);
        if (resultado == false){
            return ResponseEntity.badRequest().body("Não foi possivel deletar esta tarefa, tente novamente!");
        }
        return ResponseEntity.ok().body("Tarefa deletada com sucesso!");
    }

    @GetMapping("/exibe")
    public ResponseEntity<List<TarefaEntity>> exibe (){
        List<TarefaEntity> usuarios = service.exibeTarefa();
        if (usuarios == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(usuarios);
    }

    @PutMapping("/atualiza{nome}")
    public ResponseEntity<String> atualizar (@PathVariable String nome,
                                             @RequestBody TarefaDto tarefaDto){
        boolean resultado = service.atualizaTarefa(tarefaDto, nome);
        if (!resultado){
            return ResponseEntity.badRequest().body("Tarefa não encontrada! tente novamente!");
        }
        return ResponseEntity.ok().body("Tarefa atualizada com sucesso!");
    }
}
