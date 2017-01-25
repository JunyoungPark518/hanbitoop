package shopping;

public class CustomerServiceImpl implements CustomerService {
	Customer customer;
	int index;
	public CustomerServiceImpl() {
		customer = new Customer();
		index = 0;
	}
	
	@Override
	public String buy(Product p) {
		// 물건 구매시 현재 금액과 차이를 보고 구매 가능한지를 따진다.
		// 만약 가진 돈이 작으면 잔액이 부족합니다 라고 한다
		String pname = p.getName();
		String result = "잔액이 부족함\n남은 잔액:" + customer.getMoney();
		if(customer.getMoney() >= p.getPrice()) {
			if(pname.equals("청소기")) {
				customer.setMoney(customer.getMoney()-p.getPrice());
			} else if(pname.equals("컴퓨터")) {
				customer.setMoney(customer.getMoney()-p.getPrice());
			} else if(pname.equals("스마트폰")) {
				customer.setMoney(customer.getMoney()-p.getPrice());
			} else {
				customer.setMoney(customer.getMoney()-p.getPrice());
			}
			result = pname + "이(가) 카트에 추가됨";
		} 
		add(p);
		return result;
	}

	@Override
	public void add(Product p) {
		// 카트에 추가시키는 로직
		customer.getCart()[index] = p;
		index++;
	}

	@Override
	public String getBill() {
		// 쇼핑을 마치고 영수증을 출력한다.
		// TV ... 300
		// 지금 상황에선 3개만 구입한 내용이 나온다
		String bill = "";
		for(int i=0; i<index; i++) {
			bill += customer.getCart()[i].toString() + "\n";
		}
		return bill;
	}


}
