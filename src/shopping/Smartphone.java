package shopping;

public class Smartphone extends Product {
	private String size, giga;
	public Smartphone() {
		super(300);
	}
	@Override
	public String getName() {
		return "스마트폰";
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGiga() {
		return giga;
	}

	public void setGiga(String giga) {
		this.giga = giga;
	}

	@Override
	public String toString() {
		return "Smartphone [name=" + name + ", price=" + super.getPrice() + "]";
	}

}
