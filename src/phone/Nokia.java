package phone;

public class Nokia extends Phone {
	public final static String BRAND = "NOKIA";
	protected String move;
	protected boolean portable; // 이동성
	
	protected void setMove(String move) {
		this.move = move;
	}
	public String getMove() {
		return move;
	}
	// boolean type 만 getter를 is로 바꾼다.
	// 참인지 거짓인지만 불러오는 역할을 하기 때문이다.
	public boolean isPortable() {
		return portable;
	}
	
	public void setPortable(boolean portable) {
		this.portable = portable;
		if(portable) {
			setMove("이동 가능");
		} else {
			setMove("이동 불가능");
		}
	}
	
	// Phone 클래스에서 상속받았기 때문에 직접 접근이 가능하다(protected).
	// 또 이 클래스가 레벨이 가장 낮은 자식 클래스라면 해당 클래스의 접근 제어자들을 private으로 둔다.
	@Override
	public String toString() {
		return String.format("%s때문에 %s한 상태에서 '%s'에게 '%s'이라고 말했다.", BRAND, move, super.receiver, super.call);
	}
}
