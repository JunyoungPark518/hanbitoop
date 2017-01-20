package test;

import javax.swing.JOptionPane;

public class Controller {
	public void start() {
		String ssn = "", gender = "", id = "";
		Member member = null; // class object의 초기값은 null
		BMI bmi = null;
		while(true) {
			switch(inputInt("1. 회원등록 / 2. BMI측정 / 3. 로또 / 4. 성적표 / 0. 종료")) {
			case 0:
				return;
			case 1:
				member = new Member();
				System.out.println("아이디,이름,주민번호앞자리(800101-1)");
				// input ID
				member.setUid(input("아이디"));
				// input Name
				member.setName(input("이름"));
				// input SSN
				ssn = input("주민번호앞자리(800101-1)");
				while(true) {
					char ch = ssn.charAt(7);
					if(ch == '0' || ch == '7' || ch == '8' || ch == '9') {
						ssn = input("다시 입력하세요.");
					} else {
						break;
					}
				}
				member.setSsn(ssn);
				gender = member.calcGender(ssn);
				show(String.format("%s은 %s입니다.\n회원등록 되었습니다.", member.getName(), gender));
				break;
			case 2:
				bmi = new BMI();
				while(true) {
					id = input("아이디?");
					if(id.equals(member.getUid())) {
						bmi.setUid(id);
						bmi.setHeight(inputDouble("몸무게?") / 100);
						bmi.setWeight(inputDouble("키?"));
						show(String.format("%s은 '%s'입니다.\n", member.getName(), bmi.calcBmi(bmi.getHeight(), bmi.getWeight())));
						break;
					} else {
						show("아이디를 잘못 입력하셨습니다.");
					}
				}
				break;
			case 3:
				Lotto l = new Lotto();
				l.draw();
				break;
			case 4:
				ReportCard r = new ReportCard();
				r.setName(input("이름"));
				while(r.getSubjects()<6) {
					r.setScore(inputInt("If you want to stop, Type -1\nScore?"));
					if(r.getScore() == -1) {
						break;
					}
					r.setTotal(r.getTotal() + r.getScore());
					r.setSubjects(r.getSubjects() + 1);
				}
				r.calc();
				show(String.format("Name: %s\nSubjects: %s\nTotal: %s\nAverage: %s\nGrade: %s",
						r.getName(),r.getSubjects(),r.getTotal(),r.getAverage(),r.getGrade()));
				break;
			case 5:
				break;
			default:
				show("프로그램이 종료됩니다.");
				return;
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
	
	private double inputDouble(String str) {
		return Double.parseDouble(JOptionPane.showInputDialog(str));
	}
}
