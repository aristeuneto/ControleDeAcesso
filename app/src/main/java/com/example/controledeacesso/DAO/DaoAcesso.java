package com.example.controledeacesso.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;

import com.example.controledeacesso.dbHelper.ConexaoSQLite;
import com.example.controledeacesso.model.ModelAcesso;

import java.util.ArrayList;
import java.util.List;

public class DaoAcesso {

    private ConexaoSQLite conexaoSQLite;

    public DaoAcesso(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarAcesso(ModelAcesso modelAcesso) {

        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();
        try {


            ContentValues values = new ContentValues();
            values.put("nome", modelAcesso.getNome());
            values.put("cpf", modelAcesso.getCpf());
            values.put("origem", modelAcesso.getOrigem());
            values.put("destino", modelAcesso.getDestino());
            values.put("morador", modelAcesso.getMoradorSimNao());
            values.put("data_hora", modelAcesso.getDataHora());

            long idAcesso = db.insert("tbl_acesso", null, values);

            return idAcesso;
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (db != null) {
                db.close();
                ;

            }
        }
        return 0;

    }

    public List<ModelAcesso> getAcessoPorCPF(String cpf) {
        List<ModelAcesso> listaModelAcesso = new ArrayList<ModelAcesso>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String sql = "SELECT * FROM tbl_acesso WHERE cpf = '" + cpf + "'";

        try {
            db = this.conexaoSQLite.getReadableDatabase();
            cursor = db.rawQuery(sql, null);
            ModelAcesso acessoTemporario = null;
            if (cursor.moveToFirst()) {
                //Coloquei uma String com o Texto para facilitar a impressao no layout
                do {
                    acessoTemporario = new ModelAcesso();
                    acessoTemporario.setIdAcesso(cursor.getInt(0));
                    acessoTemporario.setNome("Nome: " + cursor.getString(1));
                    acessoTemporario.setCpf("CPF: " + cursor.getString(2));
                    acessoTemporario.setOrigem("Origem: " + cursor.getString(3));
                    acessoTemporario.setDestino("Destino: " + cursor.getString(4));
                    acessoTemporario.setMoradorSimNao("Morador?: " + cursor.getString(5));
                    acessoTemporario.setDataHora("Data e Hora: " + cursor.getString(6));

                    listaModelAcesso.add(acessoTemporario);

                } while (cursor.moveToNext());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }

        return listaModelAcesso;
    }


}
