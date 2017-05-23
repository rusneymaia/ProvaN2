package br.com.rusneymaia.rusneymaia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rusneymaia.rusneymaia.Banco.BancoController;

public class CadastrarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registro);

        EditText nome = (EditText)findViewById(R.id.editText_nome);
        EditText telefone = (EditText)findViewById(R.id.editText_telefone);
        EditText email = (EditText)findViewById(R.id.editText_email);
        EditText senha = (EditText)findViewById(R.id.editText_senha);
        EditText senha2 = (EditText)findViewById(R.id.editText_senha2);

        String nomeString = nome.getText().toString();
        String telefoneString = telefone.getText().toString();
        String emailString = email.getText().toString();
        String senhaString = senha.getText().toString();
        String senha2String = senha2.getText().toString();

        String resultado;
        if (senhaString == senha2String) {
            BancoController bancoDao = new BancoController(getBaseContext());
            resultado = bancoDao.insereDadoUsuario(nomeString, telefoneString, emailString, senhaString);
        } else {
            resultado = "Senhas informadas não sao iguais. Por favor, tente novamente!";
        }
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
    }
}
