package codewithcal.au.calendarappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class EventEditActivity extends AppCompatActivity
{
    private EditText eventNameET, eventTagET, eventTimeStartHET, eventTimeStartMET, eventTimeEndHET, eventTimeEndMET, eventPlaceET;
    private TextView eventDateTV;

    private Switch eventStartS, eventEndS;

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
        eventPlaceET = findViewById(R.id.eventPlaceET);
        eventTimeStartHET = findViewById(R.id.eventTimeStartHET);
        eventTimeStartMET = findViewById(R.id.eventTimeStartMET);
        eventTimeEndHET = findViewById(R.id.eventTimeEndHET);
        eventTimeEndMET = findViewById(R.id.eventTimeEndMET);
        eventStartS = findViewById(R.id.addEventSSwitch);
        eventEndS = findViewById(R.id.addEventESwitch);
    }

    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString();
        String eventTag = eventTagET.getText().toString();
        String eventPlace = eventPlaceET.getText().toString();
        int hourS = Integer.parseInt(eventTimeStartHET.getText().toString());

        if (eventStartS.isChecked() && hourS != 12) {
            hourS = hourS + 12;
        }
        else if (!(eventStartS.isChecked()) && hourS == 12) {
            hourS = 0;
        }
        // int minuteS = Integer.parseInt(eventTimeStartMET.getText().toString());
        int hourE = Integer.parseInt(eventTimeEndHET.getText().toString());

        if (eventEndS.isChecked() && hourE != 12) {
            hourE = hourE + 12;
        }
        else if (!(eventEndS.isChecked()) && hourE == 12) {
            hourE = 0;
        }
        // int minuteE = Integer.parseInt(eventTimeEndMET.getText().toString());

        CheckBox checkBox = findViewById(R.id.checkbox_repeat);

        if(hourE >= hourS) {
            for (int i = 0; i <= hourE - hourS; i++) {
                LocalTime eventTime = LocalTime.of(hourS + i, 0);
                if (checkBox.isChecked()) {
                    Date newDate = Date.from(CalendarUtils.selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    Event newEvent = new Event(eventName, CalendarUtils.selectedDate, eventTime, eventTag, android.text.format.DateFormat.format("EEEE", newDate).toString(), eventPlace);
                    Event.eventsList.add(newEvent);
                } else {
                    Event newEvent = new Event(eventName, CalendarUtils.selectedDate, eventTime, eventTag, eventPlace);
                    Event.eventsList.add(newEvent);
                }
            }
        }

        else {
            for (int i = 0; i <= 23 - hourS; i++) {
                LocalTime eventTime = LocalTime.of(hourS + i, 0);
                if (checkBox.isChecked()) {
                    Date newDate = Date.from(CalendarUtils.selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    Event newEvent = new Event(eventName, CalendarUtils.selectedDate, eventTime, eventTag, android.text.format.DateFormat.format("EEEE", newDate).toString(), eventPlace);
                    Event.eventsList.add(newEvent);
                } else {
                    Event newEvent = new Event(eventName, CalendarUtils.selectedDate, eventTime, eventTag, eventPlace);
                    Event.eventsList.add(newEvent);
                }
            }

            for (int i = 0; i <= hourE; i++) {
                LocalTime eventTime = LocalTime.of(i, 0);
                if (checkBox.isChecked()) {
                    Date newDate = Date.from(CalendarUtils.selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    Event newEvent = new Event(eventName, CalendarUtils.selectedDate, eventTime, eventTag, android.text.format.DateFormat.format("EEEE", newDate).toString(), eventPlace);
                    Event.eventsList.add(newEvent);
                } else {
                    Event newEvent = new Event(eventName, CalendarUtils.selectedDate, eventTime, eventTag, eventPlace);
                    Event.eventsList.add(newEvent);
                }
            }
        }
        finish();
    }

    public void cancelEventAction(View view) {
        finish();
    }
}