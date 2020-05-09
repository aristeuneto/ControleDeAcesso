package com.example.controledeacesso.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.controledeacesso.R;
import com.example.controledeacesso.controller.ControllerAcesso;
import com.example.controledeacesso.dbHelper.ConexaoSQLite;
import com.example.controledeacesso.model.ModelAcesso;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityCadastrar extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtCpf;
    private EditText edtOrigem;
    private EditText edtDestino;
    private EditText edtMorador;
    private Button btnSalvar;
    private ModelAcesso modelAcesso;
    private Spinner spMorador;
    private ArrayAdapter arrayAdapterMorador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        edtNome = findViewById(R.id.edtIdNome);
        edtCpf = findViewById(R.id.edtIdCpf);
        edtOrigem = findViewById(R.id.edtIdOrigem);
        edtDestino = findViewById(R.id.edtIdDestino);
   //     edtMorador = findViewById(R.id.edtIdMoradorSimNao);
        btnSalvar = findViewById(R.id.btnSalvar);
        spMorador = findViewById(R.id.spMorador);

        arrayAdapterMorador = ArrayAdapter.createFromResource(ActivityCadastrar.this,R.array.arrayMorador,R.layout.support_simple_spinner_dropdown_item);
        spMorador.setAdapter(arrayAdapterMorador);

        this.clickNoBotaoSalvarLinester();

    }

    public void clickNoBotaoSalvarLinester() {

        this.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModelAcesso modelAcesso = getDadosDoFormulario();

                if (modelAcesso != null) {
                    ControllerAcesso controllerAcesso = new ControllerAcesso(ConexaoSQLite.getInstance(ActivityCadastrar.this));
                    long idModelAcesso = controllerAcesso.salvarAcesso(modelAcesso);
                    if (idModelAcesso > 0) {
                        Toast.makeText(ActivityCadastrar.this, "Salvo com sucesso!", Toast.LENGTH_LONG).show();

                    } else {

                        Toast.makeText(ActivityCadastrar.this, "Erro ao Salvar!", Toast.LENGTH_LONG).show();
                    }

                } else {

                    Toast.makeText(ActivityCadastrar.this, "Todos os campos são obrigatórios!", Toast.LENGTH_LONG).show();
                }


            }
        });


    }

    public ModelAcesso getDadosDoFormulario() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String dataHora = simpleDateFormat.format(calendar.getTime());

        this.modelAcesso = new ModelAcesso();
        modelAcesso.setDataHora(dataHora);

        if (edtNome.getText().toString().isEmpty() == false) {
            modelAcesso.setNome(edtNome.getText().toString());

        } else {

            return null;
        }

        if (edtCpf.getText().toString().isEmpty() == false) {
            modelAcesso.setCpf(edtCpf.getText().toString());

        } else {

            return null;
        }
        if (edtOrigem.getText().toString().isEmpty() == false) {
            modelAcesso.setOrigem(edtOrigem.getText().toString());

        } else {

            return null;
        }

        if (edtDestino.getText().toString().isEmpty() == false) {
            modelAcesso.setDestino(edtDestino.getText().toString());

        } else {

            return null;
        }

      //  edtMorador.getText().toString().isEmpty() == false
        if (spMorador.getSelectedItem() != null) {
            modelAcesso.setMoradorSimNao(spMorador.getSelectedItem().toString());
         //   modelAcesso.setMoradorSimNao(edtMorador.getText().toString());

        } else {

            return null;
        }


        return modelAcesso;
    }

}
