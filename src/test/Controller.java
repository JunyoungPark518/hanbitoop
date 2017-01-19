package test;

import java.util.Scanner;

public class Controller {
	public static void main(String[] args) { // local variable 반드시 initialize 한다.
		Controller c = new Controller();
		c.start();
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		String ssn = "", gender = "", id = "";
		Member member = null; // class object의 초기값은 null
		BMI bmi = null;
		while(true) {
			System.out.println("1. 회원등록 / 2. BMI측정 / 3. 로또 / 4. 성적표 / 0. 종료");
			int choice = sc.nextInt();
			switch(choice) {
			case 0:
				return;
			case 1:
				member = new Member();
				System.out.println("아이디,이름,주민번호앞자리(800101-1)");
				// input ID
				member.setUid(sc.next());
				// input Name
				member.setName(sc.next());
				// input SSN
				ssn = sc.next();
				while(true) {
					char ch = ssn.charAt(7);
					if(ch == '0' || ch == '7' || ch == '8' || ch == '9') {
						System.out.println("다시 입력하세요.");
						ssn = sc.next();
					} else {
						break;
					}
				}
				member.setSsn(ssn);
				gender = member.calcGender(ssn);
				System.out.printf("%s은 %s입니다.\n", member.getName(), gender);	
				System.out.println("회원등록 되었습니다.");
				break;
			case 2:
				bmi = new BMI();
				while(true) {
					System.out.println("아이디?");
					id = sc.next();
					if(id.equals(member.getUid())) {
						bmi.setUid(id);
						System.out.println("몸무게,키?");
						bmi.setHeight(sc.nextDouble() / 100);
						bmi.setWeight(sc.nextDouble());
						System.out.printf("%s은 '%s'입니다.\n", member.getName(), bmi.calcBmi(bmi.getHeight(), bmi.getWeight()));
						break;
					} else {
						System.out.println("아이디를 잘못 입력하셨습니다.");
					}
				}
				break;
			case 3:
				Lotto l = new Lotto();
				l.draw();
				break;
			case 4:
				ReportCard r = new ReportCard();
				System.out.print("Name:");
				r.setName(sc.next());
				while(r.getSubjects()<6) {
					System.out.println("If you want to stop, Type -1");
					System.out.print("Score:");
					r.setScore(sc.nextInt());
					if(r.getScore() == -1) {
						break;
					}
					r.setTotal(r.getTotal() + r.getScore());
					r.setSubjects(r.getSubjects() + 1);
				}
				r.calc();
				System.out.printf("Name: %s\nSubjects: %s\nTotal: %s\nAverage: %s\nGrade: %s",
						r.getName(),r.getSubjects(),r.getTotal(),r.getAverage(),r.getGrade());
				break;
			case 5:
				break;
			default:
				System.out.println("프로그램이 종료됩니다.");
				return;
			}
		}
	}
}
