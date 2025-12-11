package com.fittracker.service;

import com.fittracker.dto.TrainingDto;
import java.util.List;

public interface TrainingService {
    TrainingDto createTraining(TrainingDto trainingDto);
    TrainingDto updateTraining(Long id, TrainingDto trainingDto);
    void deleteTraining(Long id);
    TrainingDto getTrainingById(Long id);
    List<TrainingDto> getAllTrainings();
    List<TrainingDto> getTrainingsByStatus(String status);
    TrainingDto updateTrainingStatus(Long id, String status);
}
