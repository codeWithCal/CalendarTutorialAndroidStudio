package codewithcal.au.calendarappexample;

import static codewithcal.au.calendarappexample.CalendarUtils.selectedDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        for (int i = 0; i <= workE - workS; i++){
            LocalTime repeat = LocalTime.of(workS + i, 0);
            RepeatEvent newRepeat = new RepeatEvent(repeat, "Working");
            RepeatEvent.repeatList.add(newRepeat);
        }

        startActivity(new Intent(this, DailyCalendarActivity.class));
    }

}
