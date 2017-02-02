package hashset;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = {"Java", "JSP", "Spring", "JS", "HTML"};
		HashSet<String> set = new HashSet<String>();
		for(String i:arr){
			set.add(i);
		}
		for(String i : arr) {
			System.out.printf("'%s'  ", i);
		}
		System.out.println();
//		System.out.println("SET:" + set);
		System.out.println("삭제를 원하는 값 입력");
		String del = sc.next();
		String temp = "";
		for(int i=0; i<arr.length; i++) {
			if(!del.equals(arr[i])) {
				temp = del + "값이 존재하지 않습니다.";
			} else {
				arr[i] = arr[arr.length-1];
				arr[arr.length-1] = "";
				temp = del + "값이 제거되었습니다.";
				break;
			}
		}
		System.out.println(temp);
		for(int i=0; i<arr.length-1; i++) {
			System.out.printf("'%s'  ", arr[i]);
		}
	}
}
