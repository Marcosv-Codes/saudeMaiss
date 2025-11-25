package com.saudeMais;

public class Medico extends Funcionario {

    private String areaTrabalho; // VERDE, AMARELO, VERMELHO

    public Medico(String nome, String cpf, String dataNascimento,
                  String matricula, String senha,
                  UPA upaAlocado, String areaTrabalho) {

        super(nome, cpf, dataNascimento, matricula, senha, upaAlocado);
        this.areaTrabalho = areaTrabalho;
    }

    public String getAreaTrabalho() { return areaTrabalho; }
    public void setAreaTrabalho(String areaTrabalho) { this.areaTrabalho = areaTrabalho; }

    // Chamar o paciente certo
    public Paciente chamarProximoPaciente() {
        UPA upa = getUpaAlocado();
        Paciente p = upa.chamarProximo(areaTrabalho);

        if (p == null) {
            System.out.println("Nenhum paciente na fila " + areaTrabalho);
            return null;
        }

        System.out.println("Chamando: " + p.getNome());
        return p;
    }

    // Atender paciente
    public void atenderPaciente(Paciente paciente) {
        if (paciente == null) {
            System.out.println("Nenhum paciente para atender.");
            return;
        }

        paciente.setAtendido(true);
        System.out.println("Atendendo: " + paciente.getNome());
    }

    // Encaminhar pra enfermaria
    public void encaminharParaEnfermaria(Paciente paciente) {
        if (paciente == null) return;

        paciente.setEncaminhadoParaEnfermaria(true);
        System.out.println("Paciente " + paciente.getNome() + " encaminhado para enfermaria.");
    }

    // Finalizar atendimento
    public void finalizarAtendimento(Paciente paciente) {
        if (paciente == null) return;

        paciente.setAtendimentoFinalizado(true);

        UPA upa = getUpaAlocado();
        upa.removerPaciente(paciente);

        System.out.println("Atendimento finalizado para: " + paciente.getNome());
    }
}
