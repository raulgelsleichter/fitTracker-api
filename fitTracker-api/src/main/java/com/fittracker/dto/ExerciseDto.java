package com.fittracker.dto;

import lombok.Data;

@Data
public class ExerciseDto {

    private Long id;
    private String nome;
    private int series;
    private int repeticoes;
    private int tempoDescanso;
    private String status;
}
