package br.com.rusneymaia.rusneymaia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HorariosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_horarios);
        final Button buttonLogar = (Button) findViewById(R.id.button_agendarhorario);
        buttonLogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent downloadIntent = new Intent(HorariosActivity.this, AgendamentoActivity.class);
                startService(downloadIntent);
            }
        });
    }
}