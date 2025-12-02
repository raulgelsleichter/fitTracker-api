-- SQL script to initialize the database schema for FitTracker

CREATE TABLE IF NOT EXISTS training (
    id SERIAL PRIMARY KEY,
    exercicios TEXT NOT NULL,
    series INT NOT NULL,
    repeticoes INT NOT NULL,
    tempo_descanso INT NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('Ativo', 'Vencidos', 'Completo')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_training_status ON training(status);