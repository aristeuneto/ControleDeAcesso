package com.example.controledeacesso.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controledeacesso.R;

public class ActivityTelaInicial extends AppCompatActivity {

    private Button btnConsultar;
    private Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityTelaInicial.this, ActivityConsultar.class);
                startActivity(intent);


            }
        });
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityTelaInicial.this, ActivityCadastrar.class);
                startActivity(intent);


            }
        });


    }
}
