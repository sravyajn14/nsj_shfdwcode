import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Customer extends Event implements Comparable<Customer>
   {
	    private String lastName;
	    private String adrCity;
	    private String adrSt;
	    private Date fVisit = null;
	    private Date lVisit = null;
	    private HashMap<String, Order> ord = new HashMap<>();
	    private ArrayList<SiteVisit> sVisit = new ArrayList<>();
	    private ArrayList<Image> imgs = new ArrayList<>();
	    private double LTV;
	  
	    public Customer(String key, Date event_time, String lastName, String adrCity, String adrSt) {
	        super(key, event_time);
	        this.setLast_name(lastName);
	        this.setAdr_city(adrCity);
	        this.setAdr_state(adrSt);
	    }
	    public void addImage(Image img) {
	        if(img != null) {
	            imgs.add(img);
	        } else {
	            System.out.println("Image is null");
	            return;
	        }
	    }
	    
	    public void addOrder(Order order) {
	        if(order != null) {            
	           ord.put(order.getKey(), order);
	        } else {
	            System.out.println("Order is null");
	        }
	    }
	    public void addSite(SiteVisit visit) {
	        if(visit != null) {
	            if(fVisit == null || visit.getEvent_time().compareTo(fVisit) < 0) {
	                fVisit = visit.getEvent_time();
	            }
	            if(lVisit == null || visit.getEvent_time().compareTo(lVisit) > 0) {
	                lVisit = visit.getEvent_time();
	            }
	            sVisit.add(visit);
	        } else {
	            System.out.println("SiteVisit is null");
	            return;
	        }
	    }
	    
	   
	    public long getWeekNum() {
	        if(lVisit == null || fVisit == null) return 0;
	        long weeks = (lVisit.getTime()-fVisit.getTime())/(7 * 24 * 60 * 60 * 1000);
	        if(weeks < 1) return 1;
	        return weeks;
	    }
	    public double getTotalAmount() {
	        if(ord == null || ord.size() == 0) return 0;
	        double total = 0;
	        for(Order order : ord.values()) {
	            total += order.getTotal_amount_num();
	        }
	        return total;
	    }
	    public double calculateLTV() {
	        long weeks = getWeekNum();
	        double total = getTotalAmount();
	        this.LTV = total/weeks;
	        return total;
	    }
	    
	   
	    public String getLast_name() {
	        return lastName;
	    }
	    public void setLast_name(String last_name) {
	        this.lastName = last_name;
	    }
	    public Date getFirstVisit() {
	        return fVisit;
	    }
	    
	    public Date getLastVisit() {
	        return lVisit;
	    }

	    public double getLTV() {
	        return LTV;
	    }
	    public void setLTV(double lTV) {
	        LTV = lTV;
	    }
	    
	    public String getAdr_city() {
	        return adrCity;
	    }
	    public void setAdr_city(String adrcity) {
	        this.adrCity = adrcity;
	    }

	    public String getAdr_state() {
	        return adrSt;
	    }

	    public void setAdr_state(String adrstate) {
	        this.adrSt = adrstate;
	    }
	    public String getOrders() {
	        StringBuilder sb = new StringBuilder();
	        for(Order order : ord.values()) {
	            sb.append(order.toString()).append('\n');
	        }
	        return sb.toString();
	    }
	   
	    public String getHistory () {
	        StringBuilder sb = new StringBuilder();
	        sb.append("\nOrder history: ");
	        for(Order order : ord.values()) {
	            sb.append(order.toString());
	        }
	        sb.append("\nVisted sites: ");
	        for(SiteVisit site : sVisit) {
	            sb.append(site.toString());
	        }
	        sb.append("\nImage uploaded: ");
	        for(Image image : imgs) {
	            sb.append(image.toString());
	        }
	        return "Customer - "+ super.toString() + ", last name: " + this.lastName + ", city: " + this.adrCity + ", state: " + this.adrSt + "history: "+ sb.toString();        
	    }
	    public int compareTo(Customer other) {
	        return Double.compare(other.LTV, this.LTV);
	    }
	    public String toString() {
	        return super.toString() + ", last name: " + this.lastName + ", city: " + this.adrCity + ", state: " + this.adrSt + ", lift time value: " + this.LTV;        
	    }

	}
