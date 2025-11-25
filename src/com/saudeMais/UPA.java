package com.saudeMais;

import java.util.ArrayList;

public class UPA {
    // ATRIBUTOS
    private String nome;
    private String endereco;
    private ArrayList<Paciente> filaVerde;
    private ArrayList<Paciente> filaAmarela;
    private ArrayList<Paciente> filaVermelha;

    // GETTERS E SETTERS
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public ArrayList<Paciente> getFilaVerde() { return filaVerde; }
    public ArrayList<Paciente> getFilaAmarela() { return filaAmarela; }
    public ArrayList<Paciente> getFilaVermelha() { return filaVermelha; }

    // CONSTRUTOR
    public UPA(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;

        this.filaVerde = new ArrayList<>();
        this.filaAmarela = new ArrayList<>();
        this.filaVermelha = new ArrayList<>();
    }

    // MÉTODOS
    public void adicionarPacienteFila(Paciente paciente) {
        if (paciente == null) return;

        String prioridade = paciente.getPrioridade().toLowerCase();

        if (prioridade.equals("verde"))
            filaVerde.add(paciente);
        else if (prioridade.equals("amarela"))
            filaAmarela.add(paciente);
        else if (prioridade.equals("vermelha"))
            filaVermelha.add(paciente);
    }

    public Paciente chamarProximo(String area) {
        if (area == null) return null;

        area = area.toLowerCase();

        if (area.equals("verde")) {
            if (filaVerde.isEmpty()) return null;
            return filaVerde.get(0);
        }
        if (area.equals("amarela")) {
            if (filaAmarela.isEmpty()) return null;
            return filaAmarela.get(0);
        }
        if (area.equals("vermelha")) {
            if (filaVermelha.isEmpty()) return null;
            return filaVermelha.get(0);
        }

        return null;
    }

    public boolean removerPaciente(Paciente paciente) {
        if (filaVerde.remove(paciente)) return true;
        if (filaAmarela.remove(paciente)) return true;
        if (filaVermelha.remove(paciente)) return true;
        return false;
    }

    public int posicaoNaFila(Paciente paciente) {
        if (filaVerde.contains(paciente))
            return filaVerde.indexOf(paciente) + 1;

        if (filaAmarela.contains(paciente))
            return filaAmarela.indexOf(paciente) + 1;

        if (filaVermelha.contains(paciente))
            return filaVermelha.indexOf(paciente) + 1;

        return -1;
    }

    public double getTempoMedioEspera() {
        return 0.0; // versão sem cálculo real
    }
}
