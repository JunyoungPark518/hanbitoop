package bank;

import java.util.Calendar;

public class Account {
	public final static String BANK_NAME = "한빛뱅크";
	private String uid, accountType, createDate;
	private int money, accountNo;
	// 6자리 random 숫자
	
	public Account(String uid, String accountType) {
		this.accountNo = makeNumber();
		this.createDate = today();
		this.uid = uid;
		this.accountType = accountType;
		money = 0;
	}
	
	private int makeNumber() {
		String no = "";
		for(int i=0; i<6; i++) {
			no += (int) (Math.random() * 10);
		}
		return Integer.parseInt(no);
	}
	
	public String today() {
		Calendar c = Calendar.getInstance();
		return c.get(c.YEAR) + "년 " + c.get(c.MONTH) + 1 + "월 " + c.get(c.DAY_OF_MONTH) + "일";
	}
	
	public String getUid() {
		return uid;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
}
