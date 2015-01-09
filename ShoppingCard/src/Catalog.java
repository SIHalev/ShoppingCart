import java.util.ArrayList;
import java.util.List;


public class Catalog {
	private List<Item> allItems;
	
	public Catalog() {
		allItems = new ArrayList<Item>();
		
		//allProducts.add(e)
		setItemsData();
	}
	
	void setItemsData() {
//		String name, String description, double unitPrice,
//		double pricePerMonth, Payments paymentType
		
		allItems.add(new Product("chair", "3 legged chair", 39.90, "IKEA", "10.8.2013"));
		allItems.add(new Product("table", "4 legged Table", 69.90, "IKEA", "11.8.2012"));
		//allItems.add(new Product("chair", "3 legged table", 29.90, "IKEA", "5.5.2011"));
		allItems.add(new Product("cup", "Red cup with green logo", 5.90, "IKEA", "10.8.2013"));
		allItems.add(new Product("pen", "Pink pen", 1.90, "Art Inn", "10.8.2013"));
		
		allItems.add(new Service("clowd_storage", "Capacity 6GB", 0, 0.50, Payments.PER_HOUR));
		allItems.add(new Service("wow", "PC game", 39.99, 5.99, Payments.WITH_REGISTRATION_PRICE));
		allItems.add(new Service("support", "Support for SWT", 0, 10.99, Payments.PER_HOUR));
		allItems.add(new Service("adobe_illustrator", "Drawing software", 89.99, 0, Payments.FIXED));
	}	
	
	public Item getItem(String value) {
		for (Item item : allItems) {
			if(item.getName().toLowerCase().equals(value)) {
				return item;
			}
		}
		
		return null;
	}
	
	public String toString(String type) {
		String mainHeader = String.format("%-30s |%-30s |%-15s |", "Name", "Description", "Unit price");
		String productHeader = String.format("%-30s|%-15s | \n", "Manufacturer", "Production date");
		String serviceHeader = String.format("%-15s |%-30s | \n", "Price per mount", "Payment type");
		
		StringBuilder products = new StringBuilder();
		StringBuilder services = new StringBuilder();
			
		products.append(mainHeader + productHeader);
		services.append(mainHeader + serviceHeader);
				
		products.append("-------------------------------------------------------------------------------------------------------------------------------------------\n");
		services.append("-------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		for (Item item : allItems) {
			if(item instanceof Product) {
				products.append(item.toString());
			} else {
				services.append(item.toString());
			}
		}
		
		switch(type) {
			case "products":
				return products.toString();
				
			case "services":
				return services.toString();
				
			default:
				return products.toString() + "\n\n" + services.toString();
		}
	}
	
	@Override
	public String toString() {
		return this.toString("all");	
	}
}
