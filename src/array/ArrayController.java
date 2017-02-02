package array;

import java.util.Scanner;

public class ArrayController {
	public static void main(String[] args) {
		ArrayService service = new ArrayServiceImpl();
		Scanner sc = new Scanner(System.in);
		// 매 알고리즘이 완성되면 배열 arr을 프린트하기
		// 추가
		System.out.println(service.add());
		// 검색(1).. 첫글자가 H로 시작하는 단어를 출력
		System.out.println(service.findOne(sc.next().charAt(0)));
		// 검색(some).. 첫글자가 J로 시작하는 단어를 출력
		System.out.println(service.findSome(sc.next().charAt(0)));
		// 전체 출력
		System.out.println(service.list());
		// 수정 (JS를 Javascript)로 변경
		System.out.println(service.update(sc.next(), sc.next()));
		// 삭제 (Spring을 삭제)
		System.out.println(service.delete(sc.next()));
	}
}
