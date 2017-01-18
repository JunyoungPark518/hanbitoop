package test;

public class SSN {
	private String gender, ssn;
	
	public String getGender() {
		return gender;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public void modify() {
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
	}
}
