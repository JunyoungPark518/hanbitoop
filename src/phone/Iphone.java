package phone;

public class Iphone extends Nokia {
	public final static String BRAND = "iPhone";
	protected String data;
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return String.format("%s때문에 %s한 상태에서 '%s'에서 '%s'을 검색했다", BRAND, 
				move, receiver, data);
	}
}
