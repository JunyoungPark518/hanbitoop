package generic;

public class GenericController {
	public static void main(String[] args) {
		GenericService service = new GenericServiceImpl<String>();
		System.out.println(service.print("Hello Generic!!!"));
	}
}
