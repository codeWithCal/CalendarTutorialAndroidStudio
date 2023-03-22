package codewithcal.au.calendarappexample;

import static codewithcal.au.calendarappexample.CalendarUtils.selectedDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class InitialQuizActivity extends AppCompatActivity{

    private EditText sleepSHET, sleepSMET, sleepEHET, sleepEMET, workSHET, workSMET, workEHET, workEMET;
    private Switch sleepSSwitch, sleepESwitch, workSSwitch, workESwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_quiz);
        initWidgets();
    }


    private void initWidgets() {
        sleepSHET = findViewById(R.id.initialQuizSleepStartHET);
        sleepSMET = findViewById(R.id.initialQuizSleepStartMET);
        sleepEHET = findViewById(R.id.initialQuizSleepEndHET);
        sleepEMET = findViewById(R.id.initialQuizSleepEndMET);
        workSHET = findViewById(R.id.initialQuizWorkStartHET);
        workSMET = findViewById(R.id.initialQuizWorkStartMET);
        workEHET = findViewById(R.id.initialQuizWorkEndHET);
        workEMET = findViewById(R.id.initialQuizWorkEndMET);
        sleepSSwitch = findViewById(R.id.sleepSSwitch);
        sleepESwitch = findViewById(R.id.sleepESwitch);
        workSSwitch = findViewById(R.id.workSSwitch);
        workESwitch = findViewById(R.id.workESwitch);
    }


    public void doneInitialQuiz(View view){
        int sleepS = Integer.parseInt(sleepSHET.getText().toString());

        if (sleepSSwitch.isChecked() && sleepS != 12) {
            sleepS = sleepS + 12;
        }
        else if (!(sleepSSwitch.isChecked()) && sleepS == 12) {
            sleepS = 0;
        }

        int sleepE = Integer.parseInt(sleepEHET.getText().toString());

        if (sleepESwitch.isChecked() && sleepE != 12) {
            sleepE = sleepE + 12;
        }
        else if (!(sleepESwitch.isChecked()) && sleepE == 12) {
            sleepE = 0;
        }



        int workS = Integer.parseInt(workSHET.getText().toString());

        if (workSSwitch.isChecked() && workS != 12) {
            workS = workS + 12;
        }
        else if (!(workSSwitch.isChecked()) && workS == 12) {
            workS = 0;
        }

        int workE = Integer.parseInt(workEHET.getText().toString());

        if (workESwitch.isChecked() && workE != 12) {
            workE = workE + 12;
        }
        else if (!(workESwitch.isChecked()) && workE == 12) {
            workE = 0;
        }

        if(sleepE >= sleepS) {
            for (int i = 0; i <= sleepE - sleepS; i++) {
                LocalTime repeat = LocalTime.of(sleepS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Sleeping");
                RepeatEvent.repeatList.add(newRepeat);
            }
        }

        else {
            for (int i = 0; i <= 23 - sleepS; i++) {
                LocalTime repeat = LocalTime.of(sleepS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Sleeping");
                RepeatEvent.repeatList.add(newRepeat);
            }

            for (int i = 0; i <= sleepE; i++) {
                LocalTime repeat = LocalTime.of(i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Sleeping");
                RepeatEvent.repeatList.add(newRepeat);
            }
        }


        CheckBox checkBoxMo = findViewById(R.id.checkbox_monday);

        if (checkBoxMo.isChecked()) {
            dayEventAdd(workS, workE, "Monday");
        }

        CheckBox checkBoxTu = findViewById(R.id.checkbox_tuesday);

        if (checkBoxTu.isChecked()) {
            dayEventAdd(workS, workE, "Tuesday");
        }

        CheckBox checkBoxWe = findViewById(R.id.checkbox_wednesday);

        if (checkBoxWe.isChecked()) {
            dayEventAdd(workS, workE, "Wednesday");
        }

        CheckBox checkBoxTh = findViewById(R.id.checkbox_thursday);

        if (checkBoxTh.isChecked()) {
            dayEventAdd(workS, workE, "Thursday");
        }

        CheckBox checkBoxFr = findViewById(R.id.checkbox_friday);

        if (checkBoxFr.isChecked()) {
            dayEventAdd(workS, workE, "Friday");
        }

        CheckBox checkBoxSa = findViewById(R.id.checkbox_saturday);

        if (checkBoxSa.isChecked()) {
            dayEventAdd(workS, workE, "Saturday");
        }

        CheckBox checkBoxSu = findViewById(R.id.checkbox_sunday);

        if (checkBoxSu.isChecked()) {
            dayEventAdd(workS, workE, "Sunday");
        }

        startActivity(new Intent(this, DailyCalendarActivity.class));
    }


    private void dayEventAdd(int timeS, int timeE, String day) {
        if(timeE >= timeS) {
            for (int i = 0; i <= timeE - timeS; i++) {
                LocalTime repeat = LocalTime.of(timeS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", day);
                RepeatEvent.repeatList.add(newRepeat);
            }
        }

        else {
            for (int i = 0; i <= 23 - timeS; i++) {
                LocalTime repeat = LocalTime.of(timeS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", day);
                RepeatEvent.repeatList.add(newRepeat);
            }

            for (int i = 0; i <= timeE; i++) {
                LocalTime repeat = LocalTime.of(i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", day);
                RepeatEvent.repeatList.add(newRepeat);
            }
        }
    }

}
