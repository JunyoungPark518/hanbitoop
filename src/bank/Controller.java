package bank;

import java.util.Date;
import java.util.Scanner;

import test.Member;

public class Controller {
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		Member member = null;
		Account account = null;
		String temp = "";
		while(true) {
			System.out.println("0.종료 / 1.회원등록 / 2.통장개설 / 3.입금 / 4.출금 / 5.조회 / 6.해지");
			switch(sc.nextInt()) {
			case 0:
				return;
			case 1:
				member = new Member();
				System.out.println("아이디를 입력하세요.");
				member.setUid(sc.next());
				System.out.println("이름을 입력하세요.");
				member.setName(sc.next());
				while(true) {
					System.out.println("주민번호(ex:900101-1)를 입력하세요.");
					temp = sc.next();
					char ch = temp.charAt(7);
					if(ch == '7' || ch == '0' || ch == '8' || ch == '9') {
						System.out.println("주민번호가 올바르지 않습니다.");
					} else {
						break;
					}
				}
				member.setSsn(temp);
				System.out.println("회원등록이 완료되었습니다.");
				break;
			case 2:
				String accountType = "저축예금";
				while(true) {
					System.out.println("아이디를 입력하세요.");
					if(sc.next().equals(member.getUid())) {
						System.out.println("예금 타입은 어떻게 되나요?");
						accountType = sc.next();
						account = new Account(member.getUid(), accountType);
						StringBuffer sb = new StringBuffer();
						sb.append("["+Account.BANK_NAME+"]\n");
						sb.append("계좌번호: " + account.getAccountNo() + "\n");
						sb.append(String.format("예금종류: %s %s님\n", account.getAccountType(), member.getName()));
						sb.append("가입일: " + account.getCreateDate() + "\n");
						sb.append("잔액: " + account.getMoney() + "\n");
						System.out.println(sb.toString());
						break;
					} else {
						System.out.println("아이디를 잘못 입력하셨습니다.");
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
}
