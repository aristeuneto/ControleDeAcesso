package com.example.controledeacesso.controller;

import com.example.controledeacesso.DAO.DaoAcesso;
import com.example.controledeacesso.dbHelper.ConexaoSQLite;
import com.example.controledeacesso.model.ModelAcesso;

import java.util.List;

public class ControllerAcesso {

    private DaoAcesso daoAcesso;

    public ControllerAcesso(ConexaoSQLite conexaoSQLite) {
        daoAcesso = new DaoAcesso(conexaoSQLite);
    }

    public long salvarAcesso(ModelAcesso modelAcesso) {
        return this.daoAcesso.salvarAcesso(modelAcesso);
    }

    public List<ModelAcesso> getAcessoPorCPF(String cpf) {
        return this.daoAcesso.getAcessoPorCPF(cpf);
    }

}
