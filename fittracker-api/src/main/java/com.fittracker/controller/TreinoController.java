package com.fittracker.controller;

import com.fittracker.entity.Treino;
import com.fittracker.service.TreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @PostMapping
    public ResponseEntity<Treino> criarTreino(@Valid @RequestBody Treino treino) {
        Treino novoTreino = treinoService.criarTreino(treino);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTreino);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treino> buscarPorId(@PathVariable Long id) {
        Optional<Treino> treino = treinoService.buscarPorId(id);
        return treino.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Treino>> buscarPorStatus(@RequestParam(required = false) Treino.StatusTreino status) {
        if (status != null) {
            List<Treino> treinos = treinoService.buscarPorStatus(status);
            return ResponseEntity.ok(treinos);
        }
        return ResponseEntity.badRequest().build(); // Ou retornar todos, mas focamos em status
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treino> atualizarTreino(@PathVariable Long id, @Valid @RequestBody Treino treino) {
        try {
            Treino treinoAtualizado = treinoService.atualizarTreino(id, treino);
            return ResponseEntity.ok(treinoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(@PathVariable Long id, @RequestBody Treino.StatusTreino status) {
        try {
            treinoService.atualizarStatus(id, status);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTreino(@PathVariable Long id) {
        try {
            treinoService.deletarTreino(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}