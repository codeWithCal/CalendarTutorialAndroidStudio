package codewithcal.au.calendarappexample;

import static codewithcal.au.calendarappexample.CalendarUtils.selectedDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StatsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        initWidgets();
        produceStats();
    }

    private TextView average, monday, tuesday, wednesday, thursday, friday, saturday, sunday;

    public void initWidgets() {
        average = findViewById(R.id.averageStats);
        monday = findViewById(R.id.mondayStats);
        tuesday = findViewById(R.id.tuesdayStats);
        wednesday = findViewById(R.id.wednesdayStats);
        thursday = findViewById(R.id.thursdayStats);
        friday = findViewById(R.id.fridayStats);
        saturday = findViewById(R.id.saturdayStats);
        sunday = findViewById(R.id.sundayStats);
    }

    public void produceStats() {
        double mondayTotal = 0;
        double averageTotal = 0;
        double tuesdayTotal = 0;
        double wednesdayTotal = 0;
        double thursdayTotal = 0;
        double fridayTotal = 0;
        double saturdayTotal = 0;
        double sundayTotal = 0;
        double mondayCount = 0;
        double tuesdayCount = 0;
        double wednesdayCount = 0;
        double thursdayCount = 0;
        double fridayCount = 0;
        double saturdayCount = 0;
        double sundayCount = 0;
        ArrayList<Event> events = Event.eventsList;
        ArrayList<RepeatEvent> events2 = RepeatEvent.repeatList;


        ArrayList<LocalDate> dates = new ArrayList<>();

        // for normal events
        for (int i = 0; i < events.size(); i++) {
            if(events.get(i).getDay().equals("none")) {
                if (events.get(i).getDate().getDayOfWeek().getValue() == 1) {
                    mondayTotal += 1;
                    if (!(searchForEvent(dates, events.get(i)))) {
                        mondayCount += 1;
                    }
                } else if (events.get(i).getDate().getDayOfWeek().getValue() == 2) {
                    tuesdayTotal += 1;
                    if (!(searchForEvent(dates, events.get(i)))) {
                        tuesdayCount += 1;
                    }
                } else if (events.get(i).getDate().getDayOfWeek().getValue() == 3) {
                    wednesdayTotal += 1;
                    if (!(searchForEvent(dates, events.get(i)))) {
                        wednesdayCount += 1;
                    }
                } else if (events.get(i).getDate().getDayOfWeek().getValue() == 4) {
                    thursdayTotal += 1;
                    if (!(searchForEvent(dates, events.get(i)))) {
                        thursdayCount += 1;
                    }
                } else if (events.get(i).getDate().getDayOfWeek().getValue() == 5) {
                    fridayTotal += 1;
                    if (!(searchForEvent(dates, events.get(i)))) {
                        fridayCount += 1;
                    }
                } else if (events.get(i).getDate().getDayOfWeek().getValue() == 6) {
                    saturdayTotal += 1;
                    if (!(searchForEvent(dates, events.get(i)))) {
                        saturdayCount += 1;
                    }
                } else if (events.get(i).getDate().getDayOfWeek().getValue() == 7) {
                    sundayTotal += 1;
                    if (!(searchForEvent(dates, events.get(i)))) {
                        sundayCount += 1;
                    }
                }
            }
            else if(events.get(i).getDay().equals("Monday")) {
                if(mondayCount == 0) {
                    mondayCount = 1;
                }
                mondayTotal += mondayCount;
            }
            else if(events.get(i).getDay().equals("Tuesday")) {
                if(tuesdayCount == 0) {
                    tuesdayCount = 1;
                }
                tuesdayTotal += tuesdayCount;
            }
            else if(events.get(i).getDay().equals("Wednesday")) {
                System.out.println("Worked");
                if(wednesdayCount == 0) {
                    wednesdayCount = 1;
                }
                wednesdayTotal += wednesdayCount;
            }
            else if(events.get(i).getDay().equals("Thursday")) {
                if(thursdayCount == 0) {
                    thursdayCount = 1;
                }
                thursdayTotal += thursdayCount;
            }
            else if(events.get(i).getDay().equals("Friday")) {
                if(fridayCount == 0) {
                    fridayCount = 1;
                }
                fridayTotal += fridayCount;
            }
            else if(events.get(i).getDay().equals("Saturday")) {
                if(saturdayCount == 0) {
                    saturdayCount = 1;
                }
                saturdayTotal += saturdayCount;
            }
            else if(events.get(i).getDay().equals("Sunday")) {
                if(sundayCount == 0) {
                    sundayCount = 1;
                }
                sundayTotal += sundayCount;
            }
        }



        // for repeat events
        for (int i = 0; i < events2.size(); i++) {
            if(events2.get(i).getDay().equals("any")) {
                if (mondayCount == 0) {
                    mondayCount = 1;
                }
                mondayTotal += mondayCount;
                if (tuesdayCount == 0) {
                    tuesdayCount = 1;
                }
                tuesdayTotal += tuesdayCount;
                if (wednesdayCount == 0) {
                    wednesdayCount = 1;
                }
                wednesdayTotal += wednesdayCount;
                if (thursdayCount == 0) {
                    thursdayCount = 1;
                }
                thursdayTotal += thursdayCount;
                if (fridayCount == 0) {
                    fridayCount = 1;
                }
                fridayTotal += fridayCount;
                if (saturdayCount == 0) {
                    saturdayCount = 1;
                }
                saturdayTotal += saturdayCount;
                if (sundayCount == 0) {
                    sundayCount = 1;
                }
                sundayTotal += sundayCount;
            }
            else if(events2.get(i).getDay().equals("Monday")) {
                if(mondayCount == 0) {
                    mondayCount = 1;
                }
                mondayTotal += mondayCount;
            }
            else if(events2.get(i).getDay().equals("Tuesday")) {
                if(tuesdayCount == 0) {
                    tuesdayCount = 1;
                }
                tuesdayTotal += tuesdayCount;
            }
            else if(events2.get(i).getDay().equals("Wednesday")) {
                if(wednesdayCount == 0) {
                    wednesdayCount = 1;
                }
                wednesdayTotal += wednesdayCount;
            }
            else if(events2.get(i).getDay().equals("Thursday")) {
                if(thursdayCount == 0) {
                    thursdayCount = 1;
                }
                thursdayTotal += thursdayCount;
            }
            else if(events2.get(i).getDay().equals("Friday")) {
                if(fridayCount == 0) {
                    fridayCount = 1;
                }
                fridayTotal += fridayCount;
            }
            else if(events2.get(i).getDay().equals("Saturday")) {
                if(saturdayCount == 0) {
                    saturdayCount = 1;
                }
                saturdayTotal += saturdayCount;
            }
            else if(events2.get(i).getDay().equals("Sunday")) {
                if(sundayCount == 0) {
                    sundayCount = 1;
                }
                sundayTotal += sundayCount;
            }
        }

        mondayTotal = 24.0 - mondayTotal/mondayCount;
        tuesdayTotal = 24.0 - tuesdayTotal/tuesdayCount;
        wednesdayTotal = 24.0 - wednesdayTotal/wednesdayCount;
        thursdayTotal = 24.0 - thursdayTotal/thursdayCount;
        fridayTotal = 24.0 - fridayTotal/fridayCount;
        saturdayTotal = 24.0 - saturdayTotal/saturdayCount;
        sundayTotal = 24.0 - sundayTotal/sundayCount;

        averageTotal = mondayTotal + tuesdayTotal + wednesdayTotal + thursdayTotal + fridayTotal + saturdayTotal + sundayTotal;

        average.setText(String.valueOf(averageTotal));
        monday.setText(String.valueOf(mondayTotal));
        tuesday.setText(String.valueOf(tuesdayTotal));
        thursday.setText(String.valueOf(thursdayTotal));
        friday.setText(String.valueOf(fridayTotal));
        wednesday.setText(String.valueOf(wednesdayTotal));
        saturday.setText(String.valueOf(saturdayTotal));
        sunday.setText(String.valueOf(sundayTotal));
    }

    public void returnCalendar(View view) {
        finish();
    }

    public boolean searchForEvent(ArrayList<LocalDate> list, Event event) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).compareTo(event.getDate()) == 0) {
                return true;
            }
        }
        return false;
    }
}
