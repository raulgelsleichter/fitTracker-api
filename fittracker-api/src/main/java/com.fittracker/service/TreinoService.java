package com.fittracker.service;

import com.fittracker.entity.Treino;
import com.fittracker.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    public Treino criarTreino(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Optional<Treino> buscarPorId(Long id) {
        return treinoRepository.findById(id);
    }

    public List<Treino> buscarPorStatus(Treino.StatusTreino status) {
        return treinoRepository.findByStatus(status);
    }

    public Treino atualizarTreino(Long id, Treino treinoAtualizado) {
        Optional<Treino> treinoExistente = treinoRepository.findById(id);
        if (treinoExistente.isPresent()) {
            Treino treino = treinoExistente.get();
            treino.setExercicios(treinoAtualizado.getExercicios());
            treino.setNumeroSeries(treinoAtualizado.getNumeroSeries());
            treino.setRepeticoes(treinoAtualizado.getRepeticoes());
            treino.setDescansoEntreSeries(treinoAtualizado.getDescansoEntreSeries());
            treino.setStatus(treinoAtualizado.getStatus());
            return treinoRepository.save(treino);
        }
        throw new RuntimeException("Treino não encontrado");
    }

    public void atualizarStatus(Long id, Treino.StatusTreino status) {
        Optional<Treino> treino = treinoRepository.findById(id);
        if (treino.isPresent()) {
            treino.get().setStatus(status);
            treinoRepository.save(treino.get());
        } else {
            throw new RuntimeException("Treino não encontrado");
        }
    }

    public void deletarTreino(Long id) {
        if (treinoRepository.existsById(id)) {
            treinoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Treino não encontrado");
        }
    }
}