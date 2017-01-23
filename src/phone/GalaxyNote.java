package phone;

public class GalaxyNote extends Iphone {
	public final static String BRAND = "Galaxy Note";
	private String size;
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		return String.format("%s때문에 %s한 상태에서 %s으로 '%s'에서 '%s'을 검색했다", BRAND, 
				move, size, receiver, data);
	}
}
