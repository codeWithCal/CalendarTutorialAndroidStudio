package codewithcal.au.calendarappexample;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HourAdapter extends ArrayAdapter<HourEvent>
{
    public HourAdapter(@NonNull Context context, List<HourEvent> hourEvents)
    {
        super(context, 0, hourEvents);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        HourEvent event = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hour_cell, parent, false);

        setHour(convertView, event.time);
        setEvents(convertView, event.events);

        return convertView;
    }

    private void setHour(View convertView, LocalTime time)
    {
        TextView timeTV = convertView.findViewById(R.id.timeTV);
        int hour = time.getHour();
        String timeFrame = "AM";
        if (hour == 0) {
            hour = 12;
        }
        else if (hour >= 12) {
            if (hour > 12){
                hour = hour % 12;
            }
            timeFrame = "PM";
        }
        timeTV.setText(hour + ":00 " + timeFrame);
    }

    private void setEvents(View convertView, ArrayList<Event> events)
    {
        TextView event1 = convertView.findViewById(R.id.event1);

        if(events.size() == 0)
        {
            hideEvent(event1);
        }
        else
        {
            setEvent(event1, events.get(0));

        }
    }

    private void setEvent(TextView textView, Event event)
    {
        if(event.getPlace().compareTo("none") == 0) {
            textView.setText(event.getName());
        }
        else {
            textView.setText(event.getName() + " @ " + event.getPlace());
        }
        if( !(event.getTag().equals("Free Time")) ) {
            textView.setBackgroundColor(Color.parseColor("#EEEEEE"));
            textView.setTextColor(Color.parseColor("#000000"));
        }
        else {
            textView.setBackgroundColor(Color.parseColor("#0000FF"));
            textView.setTextColor(Color.parseColor("#FFFFFF"));
        }
        textView.setVisibility(View.VISIBLE);
    }

    private void hideEvent(TextView tv)
    {
        tv.setVisibility(View.INVISIBLE);
    }

}













