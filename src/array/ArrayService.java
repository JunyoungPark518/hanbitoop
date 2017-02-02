package array;

public interface ArrayService {
	//1. ADD
	public String add();
	//2. Find One
	public String findOne(char keyword);
	//3. Find Some
	public String findSome(char keyword);
	//4. List
	public String list();
	//5. Update
	public String update(String before, String after);
	//6. Delete
	public String delete(String delete);
}
