package starcraft;

public class Terran extends Unit {
	private boolean fly;
	public Terran(String name, boolean fly) {
		super.name = name;
		super.energy = 100;
		this.fly = fly;
	}
	// @Override는 추상 메서드를 일반 메서드로 바꾸는 역할도 함
	@Override
	public void decEnergy() {
		super.energy -= 3;
	}
}
