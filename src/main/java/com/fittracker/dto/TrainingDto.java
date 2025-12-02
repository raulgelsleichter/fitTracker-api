package com.fittracker.dto;

import java.util.List;

public class TrainingDto {
    private Long id;
    private List<ExerciseDto> exercicios;
    private int series;
    private int repeticoes;
    private int tempoDescanso;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ExerciseDto> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ExerciseDto> exercicios) {
        this.exercicios = exercicios;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {this.repeticoes = repeticoes; }

    public int getTempoDescanso() {
        return tempoDescanso;
    }

    public void setTempoDescanso(int tempoDescanso) {
        this.tempoDescanso = tempoDescanso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}