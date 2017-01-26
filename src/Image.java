
import java.util.Date;

public class Image extends Event{
    private String customer_id;
    private String camera_make;
    private String cameral_model;
    
    public Image(String key, Date event_time, String customer_id, String camera_make, String camera_model) {
        super(key, event_time);
        this.customer_id = customer_id;
        this.camera_make = camera_make;
        this.cameral_model = camera_model;
    }
 
    public String getCustomer_id() {
        return customer_id;
    }

   
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String toString() {
        return super.toString() + ", customer_id: " + this.customer_id + ", camera_make: " + this.camera_make + ", camera_model: " + this.cameral_model;
    }
}
