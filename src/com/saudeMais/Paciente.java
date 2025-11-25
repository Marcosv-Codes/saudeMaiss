package com.saudeMais;

public class Paciente extends Pessoa {
    // ATRIBUTOS
    private String email;
    private String senha;
    private String prioridade; // VERDE, AMARELA, VERMELHA
    private String chegadaFilaTimestamp;

    // ATRIBUTOS DE ESTADO (o médico usa)
    private boolean atendido;
    private boolean encaminhadoParaEnfermaria;
    private boolean atendimentoFinalizado;

    // GETTERS E SETTERS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getChegadaFilaTimestamp() {
        return chegadaFilaTimestamp;
    }

    public void setChegadaFilaTimestamp(String chegadaFilaTimestamp) {
        this.chegadaFilaTimestamp = chegadaFilaTimestamp;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public boolean isEncaminhadoParaEnfermaria() {
        return encaminhadoParaEnfermaria;
    }

    public void setEncaminhadoParaEnfermaria(boolean encaminhadoParaEnfermaria) {
        this.encaminhadoParaEnfermaria = encaminhadoParaEnfermaria;
    }

    public boolean isAtendimentoFinalizado() {
        return atendimentoFinalizado;
    }
    public void setAtendimentoFinalizado(boolean atendimentoFinalizado) {
        this.atendimentoFinalizado = atendimentoFinalizado;
    }

    // CONSTRUTOR
    public Paciente(String nome, String cpf, String dataNascimento,
                    String email, String senha, String prioridade,
                    String chegadaFilaTimestamp) {

        super(nome, cpf, dataNascimento);
        this.email = email;
        this.senha = senha;
        this.prioridade = prioridade;
        this.chegadaFilaTimestamp = chegadaFilaTimestamp;

        // estados iniciais
        this.atendido = false;
        this.encaminhadoParaEnfermaria = false;
        this.atendimentoFinalizado = false;
    }

    // TO-STRING
    @Override
    public String toString() {
        return "Paciente{" +
                "email='" + email + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", atendido=" + atendido +
                ", encaminhadoParaEnfermaria=" + encaminhadoParaEnfermaria +
                ", atendimentoFinalizado=" + atendimentoFinalizado +
                "} " + super.toString();
    }

    // MÉTODOS
    public boolean login(String email, String senha){
        if(email == null || senha == null) return false;

        boolean correto = this.email.equals(email) && this.senha.equals(senha);

        if (correto)
            System.out.println("Login realizado com sucesso!");
        else
            System.out.println("E-mail ou senha incorretos.");

        return correto;
    }

    public double verTempoEspera(){
        return 0.0; // placeholder simples
    }
}
