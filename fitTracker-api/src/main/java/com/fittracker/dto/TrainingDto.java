package com.fittracker.dto;

import java.util.List;

public class TrainingDto {

    private Long id;
    private String nome;
    private List<String> exercicios; // ✅ TEM QUE SER STRING
    private int series;
    private int repeticoes;
    private int tempoDescanso;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<String> getExercicios() { return exercicios; }
    public void setExercicios(List<String> exercicios) { this.exercicios = exercicios; }

    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }

    public int getRepeticoes() { return repeticoes; }
    public void setRepeticoes(int repeticoes) { this.repeticoes = repeticoes; }

    public int getTempoDescanso() { return tempoDescanso; }
    public void setTempoDescanso(int tempoDescanso) { this.tempoDescanso = tempoDescanso; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
