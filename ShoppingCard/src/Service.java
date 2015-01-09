
public class Service extends Item {

	private double pricePerMonth;
	private Payments paymentType;
	
	public Service(String name, String description, double unitPrice,
			double pricePerMonth, Payments paymentType) {
		super(name, description, unitPrice);
		
		this.pricePerMonth = pricePerMonth;
		this.paymentType = paymentType;
	}

	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

	public Payments getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Payments paymentType) {
		this.paymentType = paymentType;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append(super.toString());
		result.append(String.format("%-15s |", String.valueOf(pricePerMonth)));
		result.append(String.format("%-30s |", paymentType.toString()));
		result.append("\n");
		
		return result.toString();		
	}
	
	@Override
	public String getItemsForCard() {
		StringBuilder result = new StringBuilder();
		
		result.append(super.getItemsForCard());
		result.append(String.format("%-15s ", String.valueOf(pricePerMonth)));		
		
		return result.toString();	
	}
}
