
public class Product extends Item {
	private String manufacturer;
	private String dateOfProduction; //change it to data class later.
	
	public Product(String name, String description, double unitPrice,
			String manufacturer, String dateOfProduction) {
		super(name, description, unitPrice);
		this.manufacturer = manufacturer;
		
		this.dateOfProduction = dateOfProduction;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getdateOfProduction() {
		return dateOfProduction;
	}

	public void setdateOfProduction(String dateOfProduction) {
		this.dateOfProduction = dateOfProduction;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append(super.toString());
		result.append(String.format("%-30s| ", manufacturer));
		result.append(String.format("%-15s| ", dateOfProduction));
		result.append("\n");
		
		return result.toString();		
	}
	
	@Override
	public String getItemsForCard() {
		StringBuilder result = new StringBuilder();
		
		result.append(super.getItemsForCard());
		result.append(String.format("%-30s", manufacturer));
		
		return result.toString();	
	}
}
