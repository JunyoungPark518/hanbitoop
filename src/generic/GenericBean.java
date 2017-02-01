package generic;

public class GenericBean<T> {
	private T val;
	
	public GenericBean(T val) {
		this.val = val;
	}

	public T getVal() {
		return val;
	}
}
