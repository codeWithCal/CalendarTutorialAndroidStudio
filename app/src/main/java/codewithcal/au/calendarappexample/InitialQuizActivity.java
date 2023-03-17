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
import android.widget.TextView;

import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class InitialQuizActivity extends AppCompatActivity{

    private EditText sleepSHET, sleepSMET, sleepEHET, sleepEMET, workSHET, workSMET, workEHET, workEMET;

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
    }


    public void doneInitialQuiz(View view){
        int sleepS = Integer.parseInt(sleepSHET.getText().toString());
        int sleepE = Integer.parseInt(sleepEHET.getText().toString());

        int workS = Integer.parseInt(workSHET.getText().toString());
        int workE = Integer.parseInt(workEHET.getText().toString());

        for (int i = 0; i <= sleepE - sleepS; i++){
            LocalTime repeat = LocalTime.of(sleepS + i, 0);
            RepeatEvent newRepeat = new RepeatEvent(repeat, "Sleeping");
            RepeatEvent.repeatList.add(newRepeat);
        }


        CheckBox checkBoxMo = findViewById(R.id.checkbox_monday);

        if (checkBoxMo.isChecked()) {
            for (int i = 0; i <= workE - workS; i++){
                LocalTime repeat = LocalTime.of(workS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", "Monday");
                RepeatEvent.repeatList.add(newRepeat);
            }
        }

        CheckBox checkBoxTu = findViewById(R.id.checkbox_tuesday);

        if (checkBoxTu.isChecked()) {
            for (int i = 0; i <= workE - workS; i++){
                LocalTime repeat = LocalTime.of(workS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", "Tuesday");
                RepeatEvent.repeatList.add(newRepeat);
            }
        }

        CheckBox checkBoxWe = findViewById(R.id.checkbox_wednesday);

        if (checkBoxWe.isChecked()) {
            for (int i = 0; i <= workE - workS; i++){
                LocalTime repeat = LocalTime.of(workS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", "Wednesday");
                RepeatEvent.repeatList.add(newRepeat);
            }
        }

        CheckBox checkBoxTh = findViewById(R.id.checkbox_thursday);

        if (checkBoxTh.isChecked()) {
            for (int i = 0; i <= workE - workS; i++){
                LocalTime repeat = LocalTime.of(workS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", "Thursday");
                RepeatEvent.repeatList.add(newRepeat);
            }
        }

        CheckBox checkBoxFr = findViewById(R.id.checkbox_friday);

        if (checkBoxFr.isChecked()) {
            for (int i = 0; i <= workE - workS; i++){
                LocalTime repeat = LocalTime.of(workS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", "Friday");
                RepeatEvent.repeatList.add(newRepeat);
            }
        }

        CheckBox checkBoxSa = findViewById(R.id.checkbox_saturday);

        if (checkBoxSa.isChecked()) {
            for (int i = 0; i <= workE - workS; i++){
                LocalTime repeat = LocalTime.of(workS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", "Saturday");
                RepeatEvent.repeatList.add(newRepeat);
            }
        }

        CheckBox checkBoxSu = findViewById(R.id.checkbox_sunday);

        if (checkBoxSu.isChecked()) {
            for (int i = 0; i <= workE - workS; i++){
                LocalTime repeat = LocalTime.of(workS + i, 0);
                RepeatEvent newRepeat = new RepeatEvent(repeat, "Working", "Sunday");
                RepeatEvent.repeatList.add(newRepeat);
            }
        }

        startActivity(new Intent(this, DailyCalendarActivity.class));
    }

}
