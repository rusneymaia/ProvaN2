package br.com.rusneymaia.rusneymaia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_logar);
        final Button buttonLogar = (Button) findViewById(R.id.button_login);
        buttonLogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, AgendamentoActivity.class);
                startService(intent1);
            }
        });
        final Button buttonRecuperarSenha = (Button) findViewById(R.id.button_recuperarSenha);
        buttonRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, RecuperarSenhaActivity.class);
                startService(intent2);
            }
        });
        final Button buttonCadastrar = (Button) findViewById(R.id.button_registro);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, CadastrarActivity.class);
                startService(intent3);
            }
        });
    }
}