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
	public String deposit(int money) {
		if(checkMoney(money)) {
			super.money += money;
			return money + Account.DEPOSIT_SUCCESS;
		} else {
			return Account.DEPOSIT_FAIL;
		}
	}

	@Override
	public String withdraw(int money) {
		if(checkMoney(super.money-money)) {
			super.money -= money;
			return Account.WITHDRAW_SUCCESS;
		} else {
			return Account.WITHDRAW_FAIL;
		}
	}

	@Override
	public boolean checkMoney(int money) {
		return money>=0;
	}
}
