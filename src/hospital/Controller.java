package hospital;

import java.util.Scanner;

public class Controller {
	public static void main(String[] args) {
		Controller c = new Controller();
		c.insertInfo();
	}
	
	public void insertInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("역할(의사:1, 간호사:2, 환자:3)");
		int role = sc.nextInt();
		System.out.println("-----------공통입력사항------------");
		System.out.println("이름,주민번호(예 800101-1),이메일,휴대폰");
		switch (role) {
		case 1:
			Doctors d = new Doctors();
			d.setDocName(sc.next());
			d.setDocGen(sc.next());
			d.setDocEmail(sc.next());
			d.setDocPhone(sc.next());
			d.setDocId(0);
			System.out.println("---------의사입력사항-----------");
			System.out.println("담당진료과목,직급");
			d.setMajorTreat(sc.next());
			d.setDocPosition(sc.next());
			System.out.printf("[의사]\nID:%d 담당진료과목:%s \n성명:%s 성별:%s 전화번호:%s 이메일:%s 직급:%s", 
					d.getDocId(), d.getMajorTreat(), d.getDocName(), d.getDocGen(),  
					d.getDocPhone(), d.getDocEmail(), d.getDocPosition());
			break;
		case 2:
			Nurses n = new Nurses();
			n.setNurName(sc.next());
			n.setNurGen(getGender(sc.next()));
			n.setNurEmail(sc.next());
			n.setNurPhone(sc.next());
			n.setNurId(0);
			System.out.println("---------간호사입력사항-----------");
			System.out.println("담당진료과목,직급");
			n.setMajorJob(sc.next());
			n.setNurPosition(sc.next());
			System.out.printf("[간호사]\nID:%d 담당진료과목:%s \n성명:%s 성별:%s 전화번호:%s 이메일:%s 직급:%s", 
					n.getNurId(), n.getMajorJob(), n.getNurName(), 
					n.getNurGen(), n.getNurPhone(), n.getNurEmail(), n.getNurPosition());
			break;
		case 3:
			Patients p = new Patients();
			p.setPatName(sc.next());
			p.setPatJumin(sc.next());
			p.setPatEmail(sc.next());
			p.setPatPhone(sc.next());
			p.setPatGen(getGender(p.getPatJumin()));
			p.setPatId(0);
			p.setDocId(0);
			p.setNurId(0);
			System.out.println("---------환자입력사항-----------");
			System.out.println("주소,직업");
			p.setPatAddr(sc.next());
			p.setPatJob(sc.next());
			System.out.printf("[환자]\nID:%d 담당간호사ID:%d 담당의사ID:%d \n환자성명:%s 환자성별:%s 주민번호:%s 주소:%s 전화번호:%s 이메일:%s 직업:%s", 
					p.getPatId(), p.getNurId(), p.getDocId(), p.getPatName(), p.getPatGen(), 
					p.getPatJumin(), p.getPatAddr(), p.getPatPhone(), p.getPatEmail(), p.getPatJob());
			break;
		default:
			System.out.println("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
			break;
		}
	}
	
	public String getGender(String ssn) {
		String gender;
		char ch = ssn.charAt(7);
		if(ch=='1'||ch=='3') {
			gender = "남자";
		} else if(ch=='2'||ch=='4') {
			gender = "여자";
		} else if(ch=='5'||ch=='6') {
			gender = "외국인";
		} else {
			gender = "알 수 없음";
		}
		return gender;
	}
}
