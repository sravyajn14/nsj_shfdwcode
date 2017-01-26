/**
 * SiteVisit class holds site visit information
 
 *               
 */

import java.util.Date;
public class SiteVisit extends Event implements Comparable<SiteVisit>{
    private String customer_id;
    private String tags;
    
    public SiteVisit(String key, Date event_time, String customer_id, String tags) {
        super(key, event_time);
        this.customer_id = customer_id;
        this.tags = tags;
    }
    
   
    public String getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int compareTo(SiteVisit other) {
        return this.event_time.compareTo(other.getEvent_time());        
    }
    public String toString() {
        return super.toString() + ", customer_id: " + this.customer_id + ", tags: " + this.tags;               
    }
    
}