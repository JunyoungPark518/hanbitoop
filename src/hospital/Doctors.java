package hospital;

public class Doctors extends Member {
	private String majorTreat, position;
	
	public String getMajorTreat() {
		return majorTreat;
	}
	
	public void setMajorTreat(String majorTreat) {
		this.majorTreat = majorTreat;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return String.format(
				"의사ID: %s\n"
				+ "담당진료과목: %s\n"
				+ "성명: %s\n"
				+ "성별: %s\n"
				+ "전화번호: %s\n"
				+ "이메일: %s\n"
				+ "직급: %s\n", 
				super.uid, majorTreat, super.name, super.gen, super.phone, super.email, position);
	}
}
