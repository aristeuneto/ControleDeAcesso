package com.example.controledeacesso.dbHelper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class ConexaoSQLite extends SQLiteOpenHelper {

    private static ConexaoSQLite instancia_conexao;
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB = "db_acesso";

    private ConexaoSQLite(@Nullable Context context) {
        super(context, NOME_DB, null, VERSAO_DB);

    }

    public static ConexaoSQLite getInstance(Context context) {
        if (instancia_conexao == null) {
            instancia_conexao = new ConexaoSQLite(context);

        }

        return instancia_conexao;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
      /*  String excluir = "DROP TABLE tbl_acesso";
        db.execSQL(excluir);*/
        String tblAcesso =
                "CREATE TABLE IF NOT EXISTS tbl_acesso(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," +
                        "nome TEXT NOT NULL," +
                        "cpf TEXT NOT NULL," +
                        "origem TEXT NOT NULL," +
                        "destino TEXT NOT NULL," +
                        "morador TEXT NOT NULL," +
                        "data_hora TEXT NOT NULL" +
                        ")";

        db.execSQL(tblAcesso);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
