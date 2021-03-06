package shopping;

public class CustomerServiceImpl implements CustomerService {
	Customer customer;
	int index;
	Product[] cart; // 다형성
	public CustomerServiceImpl() {
		customer = new Customer();
		index = 0;
		cart = new Product[4];
	}
	/*  물건 구매시 현재 금액과 차이를 보고 구매 가능한지를 따진다.
		만약 가진 돈이 작으면 잔액이 부족합니다 라고 한다. */
	@Override
	public String buy(Product p) {
		String pname = p.getName();
		String result = "잔액이 부족함\n남은 잔액:" + customer.getMoney();
		if(customer.getMoney() >= p.getPrice()) {
			customer.setMoney(customer.getMoney()-p.getPrice());
			result = pname + "이(가) 카트에 추가됨";
			add(p);
		} 
		return result;
	}

	/* 카트에 추가시키는 로직 */
	@Override
	public void add(Product p) {
		cart[index] = p;
		index++;
	}

	/* 쇼핑을 마치고 영수증을 출력한다.
	   TV ... 300
	   지금 상황에선 3개만 구입한 내용이 나온다 */
	@Override
	public String getBill() {
		String bill = "";
		for(int i=0; i<index; i++) {
			bill += cart[i].toString() + "\n";
		}
		return bill;
	}


}
