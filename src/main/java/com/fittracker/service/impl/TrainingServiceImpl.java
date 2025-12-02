package com.fittracker.service.impl;

import com.fittracker.entity.Training;
import com.fittracker.repository.TrainingRepository;
import com.fittracker.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Training createTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Optional<Training> getTrainingById(Long id) {
        return trainingRepository.findById(id);
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public Training updateTraining(Long id, Training trainingDetails) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado com o id: " + id));
        training.setExercises(trainingDetails.getExercises());
        training.setSeries(trainingDetails.getSeries());
        training.setRepetitions(trainingDetails.getRepetitions());
        training.setRestTime(trainingDetails.getRestTime());
        training.setStatus(trainingDetails.getStatus());
        return trainingRepository.save(training);
    }

    @Override
    public void deleteTraining(Long id) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado com o id: " + id));
        trainingRepository.delete(training);
    }

    @Override
    public List<Training> getTrainingsByStatus(String status) {
        return trainingRepository.findByStatus(status);
    }
}