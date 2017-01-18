package test;

import java.util.Scanner;

public class Controller {
	public static void main(String[] args) { // local variable 반드시 initialize 한다.
		Controller c = new Controller();
		c.start();
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. BMI체크 / 2. SSN / 3. 로또 / 4. 성적표 / 나머지. 종료");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				BMI patients = new BMI();
				patients = new BMI();
				System.out.println("이름, 나이, 키, 몸무게, SSN?");
				patients.setName(sc.next());
				patients.setAge(sc.nextInt());
				patients.setHeight(sc.nextDouble());
				patients.setWeight(sc.nextDouble() / 100);
				patients.calcBmi();
				System.out.printf("%s은 '%s'입니다.\n", patients.getName(), 
						patients.getResult());			
				break;
			case 2:
				SSN ssn = new SSN();
				ssn.setSsn(sc.next());
				ssn.modify();
				System.out.printf("%s", ssn.getGender());			
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
			default:
				System.out.println("프로그램이 종료됩니다.");
				return;
			}
		}
	}
}
