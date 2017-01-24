package hospital;

import javax.swing.JOptionPane;

public class Controller {
	public final static String DOC_SPEC = 
			"INPUT AS 의사ID,담당진료과목,성명,SSN,전화번호,이메일,직급";
	public final static String NUR_SPEC = 
			"INPUT AS 간호사ID,담당진료과목,성명,SSN,전화번호,이메일,직급";
	public final static String PAT_SPEC = 
			"INPUT AS 환자ID,성명,SSN,주소,전화번호,이메일,직업";
	public final static String EXE_OPTION = 
			"1.REG-DOCTOR\n"
			+ "2.REG-NURSE\n"
			+ "3.REG-PATIENT\n"
			+ "4.CHECK BMI\n"
			+ "0.종료";
	public void start() {
		BMI bmi = null;
		Doctors d = null;
		Nurses n = null;
		Patients p = null;
		while(true) {
			switch (inputInt(EXE_OPTION)) {
			case 1:
				String docInfo = input(DOC_SPEC);
				String[] docInfoArr = docInfo.split(",");
				d = new Doctors();
				d.setUid(Integer.parseInt((docInfoArr[0])));
				d.setMajorTreat(docInfoArr[1]);
				d.setName(docInfoArr[2]);
				d.setSsn(docInfoArr[3]);
				d.setPhone(docInfoArr[4]);
				d.setEmail(docInfoArr[5]);
				d.setPosition(docInfoArr[6]);
				show(d.toString());
				break;
			case 2:
				String nurInfo = input(NUR_SPEC);
				String[] nurInfoArr = nurInfo.split(",");
				n = new Nurses();
				n.setUid(Integer.parseInt(nurInfoArr[0]));
				n.setMajorJob(nurInfoArr[1]);
				n.setName(nurInfoArr[2]);
				n.setGen(evalGender(nurInfoArr[3]));
				n.setPhone(nurInfoArr[4]);
				n.setEmail(nurInfoArr[5]);
				n.setPosition(nurInfoArr[6]);
				show(n.toString());
				break;
			case 3:
				String patInfo = input(PAT_SPEC);
				String[] patInfoArr = patInfo.split(",");
				p = new Patients();
				p.setUid(Integer.parseInt(patInfoArr[0]));
				// 의사 및 간호사를 입력하지 않았다면 NullPointerException이 출력. 
				p.setNurId(n.getUid());
				p.setDocId(d.getUid());
				p.setName(patInfoArr[1]);
				p.setGen(evalGender(patInfoArr[2]));
				p.setSsn(patInfoArr[2]);
				p.setAddr(patInfoArr[3]);
				p.setPhone(patInfoArr[4]);
				p.setEmail(patInfoArr[5]);
				p.setJob(patInfoArr[6]);
				show(p.toString());
				break;
			case 4:
				bmi = new BMI();
				int id = 0;
				while(true) {
					id = inputInt("환자 아이디 입력");
					if(id == p.getUid()) {
						bmi.setHeight(inputDouble("몸무게?") / 100);
						bmi.setWeight(inputDouble("키?"));
						show(String.format("%s은 '%s'입니다.\n", p.getName(), bmi.treat()));
						break;
					} else {
						show("아이디를 잘못 입력하셨습니다.");
					}
				}
				break;
			case 0:
				show("프로그램을 종료합니다.");
				return;
			default:
				show("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
				break;
			}
		}
	}
	
	public String evalGender(String ssn) {
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
	
	private double inputDouble(String str) {
		return Double.parseDouble(JOptionPane.showInputDialog(str));
	}
}
