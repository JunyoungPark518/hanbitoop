package bank;

import java.util.Calendar;
import util.RandomGen;

public abstract class Account {
	public final static String BANK_NAME = "한빛뱅크";
	public final static String ACCOUNT_TYPE = "통장 BASE";
	protected String uid, accountType, createDate;
	protected int money, accountNo;
	// 6자리 random 숫자
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String uid, String accountType) {
		accountNo = RandomGen.getRandomNum(999999, 100000);
		createDate = Calendar.getInstance().get(Calendar.YEAR) + "년 "
				+ Calendar.getInstance().get(Calendar.MONTH) + 1 + "월 "
				+ Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "일";
		this.uid = uid;
		this.accountType = accountType;
		money = 0;
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
	
	public abstract void deposit(int money);
	public abstract void withdraw(int money);
}
