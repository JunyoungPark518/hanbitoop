package hospital;

public abstract class BMI {
	// instance variable 반드시 initialize를 하지 않는다.
	private double height, weight;
	
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
	public abstract String calcBmi(double height, double weight);
}
