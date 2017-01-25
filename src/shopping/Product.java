package shopping;

public class Product {
	protected String name, company;
	protected int price;
	
	public Product(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
