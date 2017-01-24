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
		if(money<0) {
			return "0원 이상의 금액을 입금해주세요.";
		} else {
			super.money += money;
			return money + "원이 입금되었습니다.";
		}
	}

	@Override
	public String withdraw(int money) {
		if(super.money >= money) {
			super.money -= money;
			return "출금이 완료되었습니다.";
		} else {
			return "잔액이 부족합니다.";
		}
	}
}
