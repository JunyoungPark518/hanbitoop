package thread;

public class ThreadController {
	public static void main(String[] args) {
		ATM at = new ATM();
		Runnable hong = new User("홍길동", at);
		Runnable park = new User("박준용", at);
		Runnable kk = new User("ㅋㅋㅋ", at);
		Thread thr1 = new Thread(hong);
		thr1.start();
		Thread thr2 = new Thread(park);
		thr2.start();
		Thread thr3 = new Thread(kk);
		thr3.start();
		
	}
	
}

class ATM {
	// synchronized는 동기화를 하기 위해 선언하는 키워드
		public synchronized void inchul(String name) {
			System.out.println(name + "님이 인출요청함");
			for(int i=0; i<=5; i++) {
				if(i==5) {
					System.out.println(name+"님이 인출중 입니다");
				}
			}
			System.out.println(name + "님이 인출해 나감");
		}
}

class User implements Runnable{
	private String name;
	private ATM atm;
	public User(String name, ATM atm) {
		super();
		this.atm = atm;
		this.name = name;
	}
	@Override
	public void run() {
		atm.inchul(name);
	}
}