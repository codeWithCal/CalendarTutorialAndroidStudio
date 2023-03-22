package codewithcal.au.calendarappexample;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }

    public static ArrayList<Event> eventsForDateAndTime(LocalDate date, LocalTime time)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            int eventHour = event.time.getHour();
            int cellHour = time.getHour();
            Date newDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            if(eventHour == cellHour) {
                if (event.getDate().equals(date) || event.day.equals(android.text.format.DateFormat.format("EEEE", newDate))) {
                    Event newEvent = new Event(event.getName(), date, event.getTime(), event.getTag(), event.getPlace());
                    events.add(newEvent);
                }
            }
        }

        return events;
    }


    private String name;
    private LocalDate date;
    private LocalTime time;

    private String tag;

    private String day;

    private String place;

    public Event(String name, LocalDate date, LocalTime time, String tag, String day, String place)
    {
        this.name = name;
        this.date = date;
        this.time = time;
        this.tag = tag;
        this.day = day;
        this.place = place;
    }

    public Event(String name, LocalDate date, LocalTime time, String tag)
    {
        this(name, date, time, tag, "none", "none");
    }
    public Event(String name, LocalDate date, LocalTime time, String tag, String place)
    {
        this(name, date, time, tag, "none", place);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
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

    public String getPlace() {return place;}

    public void setPlace(String place) {this.place = place;}
}
