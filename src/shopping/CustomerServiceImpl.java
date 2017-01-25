package shopping;

public class CustomerServiceImpl implements CustomerService {
	Customer customer;
	Product[] cart;
	int index;
	public CustomerServiceImpl() {
		customer = new Customer();
		index = 0;
	}
	
	@Override
	public String buy(Product p) {
		// 물건 구매시 현재 금액과 차이를 보고 구매 가능한지를 따진다.
		// 만약 가진 돈이 작으면 잔액이 부족합니다 라고 한다
		int money = customer.getMoney();
		String pname = p.getName();
		String result = "잔액이 부족함";
		cart = customer.getCart();
		if(money >= p.getPrice()) {
			if(pname.equals("청소기")) {
				p = new Cleaner();
				customer.setMoney(customer.getMoney()-p.getPrice());
			} else if(pname.equals("컴퓨터")) {
				p = new Computer();
				customer.setMoney(customer.getMoney()-p.getPrice());
			} else if(pname.equals("스마트폰")) {
				p = new Smartphone();
				customer.setMoney(customer.getMoney()-p.getPrice());
			} else {
				p = new TV();
				customer.setMoney(customer.getMoney()-p.getPrice());
			}
			result = pname + "이(가) 카트에 추가됨";
		} 
		return result;
	}

	@Override
	public void add(Product p) {
		// 카트에 추가시키는 로직
		cart = customer.getCart();
		cart[index] = p;
		index++;
	}

	@Override
	public String getBill() {
		// 쇼핑을 마치고 영수증을 출력한다.
		// TV ... 300
		// 지금 상황에선 3개만 구입한 내용이 나온다
		String bill = "";
		for(int i=0; i<index; i++) {
			bill += cart[i].toString() + "\n";
		}
		return bill;
	}


}
