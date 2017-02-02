package hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashSetController2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = {"Java", "JSP", "Spring", "JS", "HTML"};
		String result = "";
		// 1. 추가 .. 위에 주어진 배열 arr 을 set에 추가하기
		Set<String> set = new HashSet<String>();
			for (String i : arr) {
				set.add(i);
			}
			
		// 2. 검색(1).. 첫글자가 H로 시작하는 단어를 출력
		Iterator<String> iter = set.iterator();
		System.out.println("검색(H)");
		while(iter.hasNext()) {
		for(String i : set) {
				if('H'==i.charAt(0)) {
					System.out.println(i);
					break;
				}
			}
		}
		// 3. 검색(some).. 첫글자가 J로 시작하는 단어를 출력
		System.out.println("검색(J)");
		for(String i : set) {
			if('J'==i.charAt(0)) {
				System.out.println(i);
			}
		}
		// 4. 전체 출력
		System.out.println("전체 출력");
		for(String i : set) {
			System.out.println(i);
		}
		// 5. 수정 (JS를 Javascript)로 변경
		System.out.println("수정");
		for(String i : set) {
			if("JS".equals(i)) {
				i = "Javascript";
			}
			System.out.println(i);
		}
		// 6. 삭제 (Spring을 삭제)
		System.out.println("삭제");
		for(String i : set) {
			if("Spring".equals(i)) {
				set.remove(i);
			}
			System.out.println(i);
		}
	}
}
