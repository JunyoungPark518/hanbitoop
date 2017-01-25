package bank;

import java.util.Calendar;
import util.RandomGen;

public abstract class Account {
	public final static String BANK_NAME = "한빛뱅크";
	public final static String ACCOUNT_TYPE = "통장 BASE";
	public final static String WITHDRAW_SUCCESS = "출금이 완료되었습니다.";
	public final static String WITHDRAW_FAIL = "잔액이 부족합니다.";
	public final static String DEPOSIT_SUCCESS = "원이 입금되었습니다.";
	public final static String DEPOSIT_FAIL = "0원 이상의 금액을 입금해주세요.";
	protected String uid, accountType, createDate;
	protected int money, accountNo;
	
	// Overloading, 던져지는 parameter들만 다르면 된다. 중복정의.
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
	
	public abstract boolean checkMoney(int money);
	public abstract String deposit(int money);
	public abstract String withdraw(int money);
}
