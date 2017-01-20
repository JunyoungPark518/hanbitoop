package bank;

import javax.swing.*;

import test.Member;

public class Controller {
	public void start() {
		Member member = null;
		Account account = null;
		String temp = "";
		while(true) {
			switch(inputInt("0.종료 / 1.회원등록 / 2.통장개설 / 3.입금 / 4.출금 / 5.조회 / 6.해지")) {
			case 0:
				return;
			case 1:
				member = new Member();
				member.setName(input("이름을 입력하세요."));
				while(true) {
					temp = input("주민번호(ex:900101-1)를 입력하세요.");
					char ch = temp.charAt(7);
					if(ch == '7' || ch == '0' || ch == '8' || ch == '9') {
						show("주민번호가 올바르지 않습니다.");
					} else {
						break;
					}
				}
				member.setSsn(temp);
				member.setUid(input("아이디를 입력하세요."));
				show(member.getName() + "님 회원등록이 완료되었습니다.");
				break;
			case 2:
				String accountType = "저축예금";
				while(true) {
					if(input("아이디를 입력하세요.").equals(member.getUid())) {
						accountType = input("예금 타입은 어떻게 되나요?");
						account = new Account(member.getUid(), accountType);
						StringBuffer sb = new StringBuffer();
						sb.append("["+Account.BANK_NAME+"]\n");
						sb.append("계좌번호: " + account.getAccountNo() + "\n");
						sb.append(String.format("예금종류: %s %s님\n", account.getAccountType(), member.getName()));
						sb.append("가입일: " + account.getCreateDate() + "\n");
						sb.append("잔액: " + account.getMoney() + "\n");
						show(sb.toString());
						break;
					} else {
						show("아이디를 잘못 입력하셨습니다.");
					}
				}
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			}
		}
	}
	
	private String input(String str) {
		return JOptionPane.showInputDialog(str);
	}
	
	private void show(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	private int inputInt(String str) {
		return Integer.parseInt(JOptionPane.showInputDialog(str));
	}
}
