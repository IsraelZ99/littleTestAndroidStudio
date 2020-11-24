package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class DataPicker extends AppCompatActivity {

    TextView txtShowDate;
    Button btnSetDate;

    Date currentDate;

    int dataMonth, dataYear , dataDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_picker);

        txtShowDate = (TextView) findViewById(R.id.txtGetDate);
        btnSetDate = (Button) findViewById(R.id.btnSetDate);

        currentDate = new Date();

        getCurrentDate();
        clickSetDate();
    }

    private void getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        dataYear = calendar.get(Calendar.YEAR);
        dataMonth = calendar.get(Calendar.MONTH);
        dataDay = calendar.get(Calendar.DAY_OF_MONTH);
        txtShowDate.setText("Fecha actual del sistema: "+dataDay+"-"+(dataMonth + 1)+"-"+dataYear);
    }

    private void clickSetDate() {
        btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog getDate = new DatePickerDialog(DataPicker.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        final int currentMonth = month+1;
                        String formatDay = (dayOfMonth < 10) ? "0"+String.valueOf(dayOfMonth) : String.valueOf(dayOfMonth);
                        String formatMonth = (currentMonth < 10) ? "0"+String.valueOf(currentMonth) : String.valueOf(currentMonth);
                        dataYear = year; dataMonth = Integer.parseInt(formatMonth); dataDay = Integer.parseInt(formatDay);
                        txtShowDate.setText("Fecha seleccionada: "+dataDay+"-"+(dataMonth)+"-"+dataYear);
                    }
                }, dataYear, dataMonth, dataDay);
                getDate.show();
            }
        });

    }


}