package hospital;

public abstract class Treatment  {
	// instance variable 반드시 initialize를 하지 않는다.
	protected double height, weight;
	
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
	
	public abstract String treat();
}
