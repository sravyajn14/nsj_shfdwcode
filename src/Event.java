
import java.text.DateFormat;

import java.util.Date;

/*holds event key and event time information
 */
public class Event {
    private String key;
    protected Date event_time;
    
    public Event() {}
    
    public Event(String key, Date event_time) {
        this.key = key;
        this.event_time = event_time;
    }

    public Date getEvent_time() {
        return event_time;
    }

    public void setEvent_time(Date event_time) {
        this.event_time = event_time;
    }

    public String getKey() {
        return key;
    }
    
    public String toString() {
        DateFormat d2 = DateFormat.getDateTimeInstance(); 
        return "Event key: "+ this.key + ", Event time: "+d2.format(this.event_time);
        
    }
}

