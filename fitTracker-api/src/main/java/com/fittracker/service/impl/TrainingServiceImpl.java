package com.fittracker.service.impl;

import com.fittracker.dto.TrainingDto;
import com.fittracker.entity.Training;
import com.fittracker.repository.TrainingRepository;
import com.fittracker.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public TrainingDto createTraining(TrainingDto dto) {
        Training entity = toEntity(dto);
        Training saved = trainingRepository.save(entity);
        return toDto(saved);
    }

    @Override
    public TrainingDto updateTraining(Long id, TrainingDto dto) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado com id: " + id));
        Training.TrainingStatus.valueOf(dto.getStatus().toUpperCase());
        Training updated = trainingRepository.save(training);
        return toDto(updated);
    }

    @Override
    public void deleteTraining(Long id) {
        if (!trainingRepository.existsById(id)) {
            throw new RuntimeException("Treino não encontrado com id: " + id);
        }
        trainingRepository.deleteById(id);
    }

    @Override
    public TrainingDto getTrainingById(Long id) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado com id: " + id));
        return toDto(training);
    }

    @Override
    public List<TrainingDto> getAllTrainings() {
        return trainingRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<TrainingDto> getTrainingsByStatus(String status) {
        Training.TrainingStatus enumStatus =
                Training.TrainingStatus.valueOf(status.toUpperCase());

        return trainingRepository.findByStatus(enumStatus)
                .stream()
                .map(this::toDto)
                .toList();
    }
    @Override
    public TrainingDto updateTrainingStatus(Long id, String status) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado com id: " + id));

        try {
            Training.TrainingStatus enumStatus = Training.TrainingStatus.valueOf(status.trim().toUpperCase());
            training.setStatus(enumStatus);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Status inválido: " + status);
        }

        Training saved = trainingRepository.save(training);
        return toDto(saved);
    }

    private Training toEntity(TrainingDto dto) {
        Training t = new Training();
        t.setId(dto.getId());
        if (dto.getStatus() != null) {
            try {
                t.setStatus(Training.TrainingStatus.valueOf(dto.getStatus().trim().toUpperCase()));
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Status inválido: " + dto.getStatus());
            }
        } else {
            t.setStatus(null);
        }

        return t;
    }

    private TrainingDto toDto(Training training) {
        TrainingDto dto = new TrainingDto();
        dto.setId(training.getId());
        dto.setNome(training.getNome());
        dto.setExercicios(training.getExercicios());
        dto.setSeries(training.getSeries());
        dto.setRepeticoes(training.getRepeticoes());
        dto.setTempoDescanso(training.getTempoDescanso());

        if (training.getStatus() != null) {
            dto.setStatus(training.getStatus().name());
        } else {
            dto.setStatus(null);
        }

        return dto;
    }

}
