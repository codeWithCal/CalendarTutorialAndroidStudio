package codewithcal.au.calendarappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity
{
    private EditText eventNameET, eventTagET, eventTimeStartHET, eventTimeStartMET, eventTimeEndHET, eventTimeEndMET;
    private TextView eventDateTV;

    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        eventTagET = findViewById(R.id.eventTagET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeStartHET = findViewById(R.id.eventTimeStartHET);
        eventTimeStartMET = findViewById(R.id.eventTimeStartMET);
        eventTimeEndHET = findViewById(R.id.eventTimeEndHET);
        eventTimeEndMET = findViewById(R.id.eventTimeEndMET);
    }

    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString();
        String eventTag = eventTagET.getText().toString();
        int hourS = Integer.parseInt(eventTimeStartHET.getText().toString());
        // int minuteS = Integer.parseInt(eventTimeStartMET.getText().toString());
        int hourE = Integer.parseInt(eventTimeEndHET.getText().toString());
        // int minuteE = Integer.parseInt(eventTimeEndMET.getText().toString());
        for (int i = 0; i <= hourE-hourS; i++){
            LocalTime eventTime = LocalTime.of(hourS + i, 0);
            Event newEvent = new Event(eventName, CalendarUtils.selectedDate, eventTime, eventTag);
            Event.eventsList.add(newEvent);
        }
        finish();
    }
}