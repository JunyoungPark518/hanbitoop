package starcraft;

public abstract class Unit {
	protected String name;
	protected int energy;
	public abstract void decEnergy();
	// getter, setter는 추상화하면 안된다.
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("%s: %d", name, energy);
	}
}
