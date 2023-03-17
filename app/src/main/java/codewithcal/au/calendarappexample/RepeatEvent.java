package codewithcal.au.calendarappexample;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class RepeatEvent {

    public static ArrayList<RepeatEvent> repeatList = new ArrayList<>();

    private String name;
    private String tag;
    private LocalTime time;

    private String day;

    public RepeatEvent(LocalTime time, String name, String day) {
        this.time = time;
        this.tag = "Not Free Time";
        this.name = name;
        this.day = day;
    }

    public RepeatEvent(LocalTime time, String name) {
        this(time, name, "any");
    }

    public static ArrayList<Event> eventForTime(LocalTime time, LocalDate date) {
        ArrayList<Event> events = new ArrayList<>();
        for(RepeatEvent event: repeatList)
        {
            int eventHour = event.time.getHour();
            int cellHour = time.getHour();

            Date newDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            if(eventHour == cellHour) {
                if (event.day.equals("any") || event.day.equals(android.text.format.DateFormat.format("EEEE", newDate))) {
                    Event newEvent = new Event(event.getName(), date, event.getTime(), event.getTag());
                    events.add(newEvent);
                }
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

    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day = day;
    }
}
