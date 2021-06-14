package calendar;

import com.google.api.services.calendar.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventCollector {
    public String summary;
    public String date;
    public String location;
    public EventCollector(String summary, String date, String location) {
        this.summary = summary;
        this.date = date;
        this.location = location;
    }
}