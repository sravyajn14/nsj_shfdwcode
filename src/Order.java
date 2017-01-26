
import java.util.Date;

public class Order extends Event {
    private String custid;
    private String totalamt;
    private double totalamtn;
    
    public Order(String key, Date event_time, String customer_id, String total_amount)
    {
        super(key, event_time);
        String[] amount_array = total_amount.trim().split(" "); 
        double total_amount_num = Double.parseDouble(amount_array[0]);
        this.custid = customer_id;
        this.totalamt = total_amount;
        this.totalamtn = total_amount_num;
        
    }   

    public String getCustomer_id() {
        return custid;
    }

    public void setCustomer_id(String customer_id) {
        this.custid = customer_id;
    }

    public double getTotal_amount_num() {
        return totalamtn;
    }

    public void setTotal_amount(double total_amount_num) {
        this.totalamtn = total_amount_num;
    }
    
    public String toString() {
        return super.toString() + ", customer_id: " + this.custid + ", totalamt: " + this.totalamt + " , totalamtn: "+ this.totalamtn;
    }
    
    
    public int hashCode() {
        return super.getKey().hashCode();
    }
    
}
