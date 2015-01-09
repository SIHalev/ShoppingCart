
public abstract class Item  {
	private String name;	
	private String description;
	private double unitPrice;
	
	public Item(String name, String description, double unitPrice) {
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		//result.append("[ ");
		result.append(String.format("%-30s |", name));
		result.append(String.format("%-30s |", description));
		result.append(String.format("%-15s |", String.valueOf(unitPrice)));
		
		return result.toString();		
	}
	
	public String getItemsForCard() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("%-30s ", name));
		result.append(String.format("%-15s ", String.valueOf(unitPrice)));
		
		return result.toString();	
	}
}
