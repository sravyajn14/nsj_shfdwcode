import org.json.JSONException;

public class Test_main {
	
	  public static void main(String[] args) throws JSONException {
	        Input data = new Input();
	        Test_main obj = new Test_main();
	        String file = args[0];
	        System.out.println("File Name: " + args[0]);
	        System.out.println("Number of customers: " + args[1]);
	        System.out.println("Ouput : ");
	        obj.ingest(file, data);
	        Customer[] topKcustomers = obj.topLTVCustomer(Integer.parseInt(args[1]), data);
	        
	        System.out.println("Top "+ args[1] + " customers lift time value");
	        for(int i = 0; i < topKcustomers.length; i++) {
	            System.out.println(topKcustomers[i]);
	        }        
	    }
	    public void ingest(String file, Input d) throws JSONException {
	        d.ingest(file);
	    }
	    
	    public Customer[] topLTVCustomer(int x, Input d) {
	        return d.LTVCustomers(x);
	    }
	  
	  
	}
