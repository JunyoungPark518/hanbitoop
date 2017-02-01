package generic;

public class GenericServiceImpl<T> implements GenericService {
	@Override
	public String print(String param) {
		GenericBean<?> g = new GenericBean<String>(param);
		return (String) g.getVal(); 
	}
	
}
