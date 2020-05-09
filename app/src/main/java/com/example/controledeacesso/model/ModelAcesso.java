package com.example.controledeacesso.model;

public class ModelAcesso {

    private int idAcesso;
    private String nome;
    private String cpf;
    private String origem;
    private String destino;
    private String moradorSimNao;
    private String dataHora;

    public ModelAcesso() {

    }

    public int getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(int idAcesso) {
        this.idAcesso = idAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMoradorSimNao() {
        return moradorSimNao;
    }

    public void setMoradorSimNao(String moradorSimNao) {
        this.moradorSimNao = moradorSimNao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
