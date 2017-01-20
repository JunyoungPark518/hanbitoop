package bank;

import javax.swing.*;

import test.Member;

public class Controller {
	public void start() {
		Member member = null;
		Account account = null;
		String temp = "";
		while(true) {
			switch(inputInt("1.회원등록\n2.통장개설\n3.입금\n4.출금\n5.조회\n6.해지\n0.종료")) {
			case 0:
				return;
			case 1: // 회원등록
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
			case 2: // 통장개설
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
			case 3: // 입금
				if(input("아이디를 입력하세요.").equals(member.getUid()) && account != null) {
					account.setMoney(account.getMoney() + inputInt("얼마를 입금하시겠습니까?"));
					show(String.format("입금이 완료되었습니다.\n현재 잔액은 %d원입니다.", account.getMoney()));
				} else {
					notCase(account);
				}
				break;
			case 4: // 출금
				if(input("아이디를 입력하세요.").equals(member.getUid()) && account != null) {
					int withdraw = inputInt("얼마를 출금하시겠습니까?");
					if(account.getMoney() - withdraw >= 0) {
						account.setMoney(account.getMoney() - withdraw);
						show(String.format("출금이 완료되었습니다.\n현재 잔액은 %d원입니다.", account.getMoney()));
					} else {
						show("잔액이 부족하여 출금할 수 없습니다.");
					}
				} else {
					notCase(account);
				}
				break;
			case 5: // 조회
				if(input("아이디를 입력하세요.").equals(member.getUid()) && account != null) {
					show(String.format("%s님의 현재 잔액은 %d원입니다.", member.getName(), account.getMoney()));
				} else {
					notCase(account);
				}
				break;
			case 6: // 해지
				if(input("아이디를 입력하세요.").equals(member.getUid()) && account != null) {
					account = (input("정말 해지하실 건가요?\n해지하시려면 '해지'를 입력하세요.").equals("해지")) ? null : account;
					if(account==null) {
						show("해지가 완료되었습니다.");
					}
				} else {
					notCase(account);
				}
				break;
			}
		}
	}
	
	// 사용 편의를 위한 추가 생성 메서드
	private String input(String str) {
		return JOptionPane.showInputDialog(str);
	}
	
	private void show(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	private int inputInt(String str) {
		return Integer.parseInt(JOptionPane.showInputDialog(str));
	}
	
	private void notCase(Account a) {
		if(a == null) {
			show("통장을 먼저 개설하세요.");
		} else {
			show("아이디를 잘못 입력하셨습니다.");
		}
	}
}
