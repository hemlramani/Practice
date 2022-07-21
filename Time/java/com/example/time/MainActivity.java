package com.example.time;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateEx dateEx = new DateEx();
                dateEx.show(getSupportFragmentManager(),"");


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeEx timeEx = new TimeEx();
                timeEx.show(getSupportFragmentManager(),"");
            }
        });
    }

    public  static class DateEx extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
        {
            Calendar c =Calendar.getInstance();
            int date=c.get(Calendar.DAY_OF_MONTH);
            int month=c.get(Calendar.MONTH);
            int year=c.get(Calendar.YEAR);
            return new DatePickerDialog(getActivity(),this,year,month,date);
        }


        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            
        }
    }

    public  static class TimeEx extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
        {
            Calendar c = Calendar.getInstance();
            int hour= c.get(Calendar.HOUR);
            int min = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(),this,hour,min,true);
        }
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {

            Toast.makeText(getActivity(), ""+i, Toast.LENGTH_SHORT).show();
            
        }
    }
}