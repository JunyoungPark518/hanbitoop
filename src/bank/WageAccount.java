package bank;

import java.util.Calendar;

import util.RandomGen;

public class WageAccount extends Account{
	
	public WageAccount(String uid, String accountType) {
		accountNo = RandomGen.getRandomNum(999999, 100000);
		createDate = Calendar.getInstance().get(Calendar.YEAR) + "년 "
				+ Calendar.getInstance().get(Calendar.MONTH) + 1 + "월 "
				+ Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "일";
		super.uid = uid;
		super.accountType = accountType;
		money = 0;
	}
	
	@Override
	public void deposit(int money) {
		// TODO Auto-generated method stub
		super.money += money;
	}

	@Override
	public void withdraw(int money) {
		// TODO Auto-generated method stub
		if(super.money - money >= 0) {
			super.money -= money;
		} else {
			super.money = money;
		}
	}
}
