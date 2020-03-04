package com.example.idene.calendarios;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

public class MainActivity extends AppCompatActivity {

    //private CalendarView calendarView;//Calendario nativo
    private MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);

        //configuracao
        //valores para os meses
        CharSequence meses[] = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho",
                "Agosto","Setembro","Otubro","Novembro","Dezembro"};
        calendarView.setTitleMonths(meses);

        CharSequence semanas[] = {"Segunda","Terça","Quarta","Quinta","Sexta","Sabado","Domingo"};
        calendarView.setWeekDayLabels(semanas);        


        /*
        //data maxima e minima
        calendarView.state().edit().setMinimumDate(CalendarDay.from(2015,1,1))//data minima do app
                .setMaximumDate(CalendarDay.from(2020,3,1))//data maxima do app
                .commit();
        */

        //recuperar os meses
        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                Log.i("data:","valor:" + (date.getMonth()+1) + "/" + date.getYear());
            }
        });

        /*
        //recuperar dia mes e ano
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Log.i("data:","valor:" + date);
            }
        });
        */










/*Calendario nativo
        calendarView = findViewById(R.id.calendarView);

        //recuper o dado do dia selecionado
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Log.i("data:","valor:" + dayOfMonth + "/" + month + "/" + year);
            }
        });
        */
    }
}
