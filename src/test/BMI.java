package test;

public class BMI {
	private String name, result; // instance variable 반드시 initialize를 하지 않는다
	private int age;
	private double height, weight, bmi;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
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
	
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	
	public double getBmi() {
		return bmi;
	}
	
	public String getResult() {
		return result;
	}
	
	// setter를 생략하면, readOnly 파일
	public void calcBmi() {
		bmi = weight / (height * height);
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
	}
}
