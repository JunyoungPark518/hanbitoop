package test;

public class BMI {
	// instance variable 반드시 initialize를 하지 않는다.
	private String uid; 
	private double height, weight;
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	// setter를 생략하면, readOnly 파일
	// stand alone method
	public String calcBmi(double height, double weight) {
		double bmi = weight / (height * height);
		String result = "";
		if(bmi>30) {
			result = "고도비만";
		} else if(bmi>25) {
			result = "비만";
		} else if(bmi>23) {
			result = "과체중";
		} else if(bmi>18.5) {
			result = "정상";
		} else {
			result = "저체중";
		}
		return result;
	}
}
