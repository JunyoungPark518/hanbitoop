package hospital;

import javax.swing.JOptionPane;

public class Controller {
	public void start() {
		int role = inputInt("역할(의사:1, 간호사:2, 환자:3)");
		switch (role) {
		case 1:
			Doctors d = new Doctors();
			d.setDocName(input("이름"));
			d.setDocGen(input("주민번호(예 800101-1)"));
			d.setDocEmail(input("이메일"));
			d.setDocPhone(input("휴대폰"));
			d.setDocId(0);
			d.setMajorTreat(input("담당진료과목"));
			d.setDocPosition(input("직급"));
			show(String.format("[의사]\nID:%d 담당진료과목:%s \n성명:%s 성별:%s 전화번호:%s 이메일:%s 직급:%s", 
					d.getDocId(), d.getMajorTreat(), d.getDocName(), d.getDocGen(),  
					d.getDocPhone(), d.getDocEmail(), d.getDocPosition()));
			break;
		case 2:
			Nurses n = new Nurses();
			n.setNurName(input("이름"));
			n.setNurGen(getGender(input("주민번호(예 800101-2)")));
			n.setNurEmail(input("이메일"));
			n.setNurPhone(input("휴대폰"));
			n.setNurId(0);
			n.setMajorJob(input("담당진료과목"));
			n.setNurPosition(input("직급"));
			show(String.format("[간호사]\nID:%d 담당진료과목:%s \n성명:%s 성별:%s 전화번호:%s 이메일:%s 직급:%s", 
					n.getNurId(), n.getMajorJob(), n.getNurName(), 
					n.getNurGen(), n.getNurPhone(), n.getNurEmail(), n.getNurPosition()));
			break;
		case 3:
			Patients p = new Patients();
			p.setPatName(input("이름"));
			p.setPatJumin(input("주민번호(예 800101-1)"));
			p.setPatEmail(input("이메일"));
			p.setPatPhone(input("휴대폰"));
			p.setPatGen(getGender(p.getPatJumin()));
			p.setPatId(0);
			p.setDocId(0);
			p.setNurId(0);
			p.setPatAddr(input("주소"));
			p.setPatJob(input("직업"));
			show(String.format("[환자]\nID:%d 담당간호사ID:%d 담당의사ID:%d \n환자성명:%s 환자성별:%s 주민번호:%s 주소:%s 전화번호:%s 이메일:%s 직업:%s", 
					p.getPatId(), p.getNurId(), p.getDocId(), p.getPatName(), p.getPatGen(), 
					p.getPatJumin(), p.getPatAddr(), p.getPatPhone(), p.getPatEmail(), p.getPatJob()));
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
