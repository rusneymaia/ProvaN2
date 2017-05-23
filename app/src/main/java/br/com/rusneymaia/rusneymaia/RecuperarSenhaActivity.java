package br.com.rusneymaia.rusneymaia;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rusneymaia.rusneymaia.Banco.BancoController;
import br.com.rusneymaia.rusneymaia.Banco.CriaBanco;

public class RecuperarSenhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recuperarsenha);

        final Button buttonRecuperarSenha = (Button) findViewById(R.id.button_enviarSenha);
        buttonRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText email = (EditText)findViewById(R.id.editText_email);
                String emailString = email.getText().toString();
                Cursor cursor;
                BancoController bancoDao = new BancoController(getBaseContext());
                cursor = bancoDao.recuperarSenhaUsuario(emailString);
                String resultado = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.SENHA1));
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
        final Button buttonLogar = (Button) findViewById(R.id.button_acessarLogin);
        buttonLogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(RecuperarSenhaActivity.this, MainActivity.class);
                startService(intent3);
            }
        });
    }
}
