package phone;

import javax.swing.*;

public class Controller {

	public void start() {
		Phone phone = new Phone();
		Nokia nokia = null;
		Iphone iPhone = null;
		GalaxyNote galaxy = null;
//		show("기능선택: \n1.삼성전화기 \n2.노키아 \n3.아이폰 \n4.갤럭시 \n0.종료");
		while(true) {
			switch(input("기능선택: \n"
					+ "1.삼성전화기 \n"
					+ "2.노키아 \n"
					+ "3.아이폰 \n"
					+ "4.갤럭시 \n"
					+ "0.종료")) {
			case "1":
				phone.setReceiver(input("받는 사람"));
				phone.setCall(input("전달할 메시지"));
				show(phone.toString());
				break;
			case "2":
				nokia = new Nokia();
				nokia.setPortable(true);
				nokia.setReceiver(input("받는 사람"));
				nokia.setCall(input("전달할 메시지"));
				show(nokia.toString());
				break;
			case "3":
				iPhone = new Iphone();
				iPhone.setPortable(true);
				iPhone.setReceiver(input("검색엔진"));
				iPhone.setData(input("어떤 것을 검색하겠어요?"));
				show(iPhone.toString());
				break;
			case "4":
				galaxy = new GalaxyNote();
				galaxy.setPortable(true);
				galaxy.setSize(input("화면 사이즈"));
				galaxy.setReceiver(input("검색엔진"));
				galaxy.setData(input("어떤 것을 검색하겠어요?"));
				show(galaxy.toString());
				break;
			case "0":
				show("프로그램이 종료됩니다.");
				return;
			}
		}
	}
	
	public String input(String str) {
		return JOptionPane.showInputDialog(str);
	}
	
	public void show(String str) {
		JOptionPane.showMessageDialog(null, str);
	}

}
