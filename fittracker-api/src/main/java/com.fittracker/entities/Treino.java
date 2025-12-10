package com.fittracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "treinos")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Exercícios são obrigatórios")
    private String exercicios; // Lista de exercícios separados por vírgula (ex: "Agachamento,Supino")

    @Min(value = 1, message = "Número de séries deve ser pelo menos 1")
    private int numeroSeries;

    @Min(value = 1, message = "Repetições devem ser pelo menos 1")
    private int repeticoes;

    @Min(value = 0, message = "Descanso não pode ser negativo")
    private int descansoEntreSeries; // Em segundos

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status é obrigatório")
    private StatusTreino status;

    public enum StatusTreino {
        ATIVO, VENCIDO, COMPLETO
    }

    // Construtores, getters e setters
    public Treino() {}

    public Treino(String exercicios, int numeroSeries, int repeticoes, int descansoEntreSeries, StatusTreino status) {
        this.exercicios = exercicios;
        this.numeroSeries = numeroSeries;
        this.repeticoes = repeticoes;
        this.descansoEntreSeries = descansoEntreSeries;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getExercicios() { return exercicios; }
    public void setExercicios(String exercicios) { this.exercicios = exercicios; }

    public int getNumeroSeries() { return numeroSeries; }
    public void setNumeroSeries(int numeroSeries) { this.numeroSeries = numeroSeries; }

    public int getRepeticoes() { return repeticoes; }
    public void setRepeticoes(int repeticoes) { this.repeticoes = repeticoes; }

    public int getDescansoEntreSeries() { return descansoEntreSeries; }
    public void setDescansoEntreSeries(int descansoEntreSeries) { this.descansoEntreSeries = descansoEntreSeries; }

    public StatusTreino getStatus() { return status; }
    public void setStatus(StatusTreino status) { this.status = status; }
}