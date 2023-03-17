package codewithcal.au.calendarappexample;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class RepeatEvent {

    public static ArrayList<RepeatEvent> repeatList = new ArrayList<>();

    private String name;
    private String tag;
    private LocalTime time;

    public RepeatEvent(LocalTime time, String name) {
        this.time = time;
        this.tag = "Not Free Time";
        this.name = name;
    }

    public static ArrayList<Event> eventForTime(LocalTime time, LocalDate date) {
        ArrayList<Event> events = new ArrayList<>();
        for(RepeatEvent event: repeatList)
        {
            int eventHour = event.time.getHour();
            int cellHour = time.getHour();
            if(eventHour == cellHour) {
                Event newEvent = new Event(event.getName(), date, event.getTime(), event.getTag());
                events.add(newEvent);
            }
        }
        return events;
    }

    public LocalTime getTime(){return time;}

    public void setTime(LocalTime time){this.time = time;}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }
}
