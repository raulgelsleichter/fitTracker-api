package com.fittracker.controller;

import com.fittracker.dto.TrainingDto;
import com.fittracker.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping
    public ResponseEntity<TrainingDto> createTraining(@RequestBody TrainingDto trainingDto) {
        TrainingDto createdTraining = trainingService.createTraining(trainingDto);
        return new ResponseEntity<>(createdTraining, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingDto> updateTraining(@PathVariable Long id, @RequestBody TrainingDto trainingDto) {
        TrainingDto updatedTraining = trainingService.updateTraining(id, trainingDto);
        return new ResponseEntity<>(updatedTraining, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingDto> getTrainingById(@PathVariable Long id) {
        TrainingDto trainingDto = trainingService.getTrainingById(id);
        return new ResponseEntity<>(trainingDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TrainingDto>> getAllTrainings(@RequestParam(required = false) String status) {
        List<TrainingDto> trainings = trainingService.getAllTrainings(status);
        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TrainingDto> updateTrainingStatus(@PathVariable Long id, @RequestParam String status) {
        TrainingDto updatedTraining = trainingService.updateTrainingStatus(id, status);
        return new ResponseEntity<>(updatedTraining, HttpStatus.OK);
    }
}