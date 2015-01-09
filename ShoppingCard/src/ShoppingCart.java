import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart {
	private Map<Item, Integer> allItems;

	public ShoppingCart() {
		allItems = new HashMap<Item, Integer> ();	
	}
	
	public void removeItem(String name) {
		if(name == null) {
			return;
		}
		
		Iterator iter = allItems.entrySet().iterator();	 
	    while (iter.hasNext()) {
	        Map.Entry pairs = (Map.Entry) iter.next();
	        Item item = (Item) pairs.getKey();
	        
	        if(item.getName().equals(name)) {
	        	 iter.remove(); 
	        }       
	    }
	}
	
	public void removeItem(String name, int count) {
		if(count < 1 || name == null) {
			return;
		}
		
		Iterator iter = allItems.entrySet().iterator();	 
	    while (iter.hasNext()) {
	        Map.Entry pairs = (Map.Entry) iter.next();
	        Item item = (Item) pairs.getKey();
	        
	        if(item.getName().equals(name)) {
	        	if((Integer)pairs.getValue() <= count) {
	        		 iter.remove();
	        	} else {
	        		allItems.put(item, allItems.get(item) - count);
	        	}
	        }       
	    }
	}
	
	public void clear() {
		allItems.clear();
	}
	
	public void addItem(Item item, int count) throws Exception {
		if(count < 1 || item == null) {
			return;
		}
			
		if(allItems.containsKey(item)) {
			allItems.put(item, allItems.get(item) + count);
		} else {
			allItems.put(item, count);
		}	
		
		if(allItems.get(item) < 0) {
			throw new Exception();
		}
	}
	
	
	public String toString(String type) throws Exception {
		String mainHeader = String.format("%-10s|%-30s|%-15s|", "Count", "Name", " Unit price");
		String productsHeader = String.format("%-30s|%-15s|", "Manifacturer", "Total price");
		String serviceHeader = String.format("%-15s|%-15s|", "Per mount", "Total price");
		
		StringBuilder products = new StringBuilder();
		StringBuilder services = new StringBuilder();
			
		products.append(mainHeader + productsHeader);
		services.append(mainHeader + serviceHeader);
		
		products.append("\n-------------------------------------------------------------------------------------------------------------------------------------------\n");
		services.append("\n-------------------------------------------------------------------------------------------------------------------------------------------\n");
					
		for(Entry<Item, Integer> entry : allItems.entrySet()) {
		    Item key = entry.getKey();
		    
		    double totalPrice = entry.getValue() * entry.getKey().getUnitPrice();
		    
		    if(totalPrice < 0) {
		    	totalPrice = Double.MAX_VALUE;
		    	//Everything is free beyond the max value ! 
		    }
		    
		    if(key instanceof Product) {	    	
		    	products.append(String.format("%-10s|", entry.getValue()));	
			    products.append(key.getItemsForCard());	
			    products.append(new DecimalFormat("#0.00").format(totalPrice));	
		    } else {
		    	services.append(String.format("%-10s|", entry.getValue()));	
		    	services.append(key.getItemsForCard());	
		    	services.append(new DecimalFormat("#0.00").format(totalPrice));	
			}	
		
		}		
		
		switch(type) {
			case "products":
				return products.toString();
				
			case "services":
				return services.toString();
				
			default:
				return products.toString() + "\n\n"+ services.toString();
		}
	}
	
	
}
