package com.example.controledeacesso.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.controledeacesso.R;
import com.example.controledeacesso.adapters.AdapterListaAcessos;
import com.example.controledeacesso.controller.ControllerAcesso;
import com.example.controledeacesso.dbHelper.ConexaoSQLite;
import com.example.controledeacesso.model.ModelAcesso;

import java.util.ArrayList;
import java.util.List;

public class ActivityConsultar extends AppCompatActivity {

    private Button btnConsultarAcesso;
    private EditText edtCpf;
    private TextView tvNome;
    private TextView tvCpf;
    private TextView tvOrigem;
    private TextView tvDestino;
    private TextView tvMorador;
    private TextView tvDataHora;
    private List<ModelAcesso> listaAcessos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        edtCpf = findViewById(R.id.edtCpf);

        tvNome = findViewById(R.id.tvNome);
        tvCpf = findViewById(R.id.tvCpf);
        tvOrigem = findViewById(R.id.tvOrigem);
        tvDestino = findViewById(R.id.tvDestino);
        tvMorador = findViewById(R.id.tvMorador);
        tvDataHora = findViewById(R.id.tvDataHora);

        btnConsultarAcesso = findViewById(R.id.btnConsultarAcesso);
        btnConsultarAcesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpf = edtCpf.getText().toString();
                ControllerAcesso controllerAcesso = new ControllerAcesso(ConexaoSQLite.getInstance(ActivityConsultar.this));
                listaAcessos = controllerAcesso.getAcessoPorCPF(cpf);

                if (listaAcessos.isEmpty() == false) {

                    tvNome.setText(listaAcessos.get(0).getNome());
                    tvCpf.setText(listaAcessos.get(0).getCpf());
                    tvOrigem.setText(listaAcessos.get(0).getOrigem());
                    tvDestino.setText(listaAcessos.get(0).getDestino());
                    tvMorador.setText(listaAcessos.get(0).getMoradorSimNao());
                    tvDataHora.setText(listaAcessos.get(0).getDataHora());

                } else {

                    Toast.makeText(ActivityConsultar.this, "Usuario não encontrado!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
