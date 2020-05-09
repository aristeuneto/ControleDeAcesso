package com.example.controledeacesso.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.controledeacesso.R;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private EditText edtLogin;
    private EditText edtSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnEntrar = (Button) findViewById(R.id.btnEntrar);
        this.edtLogin = (EditText) findViewById(R.id.edtLogin);
        this.edtSenha = (EditText) findViewById(R.id.edtSenha);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String login = edtLogin.getText().toString();
                String senha = edtSenha.getText().toString();

                if (login.equals("admin") && senha.equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, ActivityTelaInicial.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(MainActivity.this,"Login ou senha incorretos!", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
