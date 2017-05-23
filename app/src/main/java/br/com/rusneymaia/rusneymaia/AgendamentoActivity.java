package br.com.rusneymaia.rusneymaia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class AgendamentoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_agendamento);
        final Button buttonLogar = (Button) findViewById(R.id.button_agendar);
        final CalendarView calendar = (CalendarView) findViewById(R.id.calendarView);
        buttonLogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                        Intent intent = new Intent(AgendamentoActivity.this, HorariosActivity.class);
                        //intent.putExtra(day,)
                        startService(intent);
                        //Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}