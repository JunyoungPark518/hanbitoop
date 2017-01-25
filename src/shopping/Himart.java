package shopping;

import javax.swing.JOptionPane;

public class Himart {
	public static void main(String[] args) {
		CustomerServiceImpl service = new CustomerServiceImpl();
		Customer c = service.customer;
		while(true) {
			switch(JOptionPane.showInputDialog("뭐살래?\n1.TV\n2.폰\n3.청소기\n4.PC\n5.잔액확인\n0.영수증 출력 및 종료")) {
			case "1" :
				TV tv = new TV();
				JOptionPane.showMessageDialog(null, service.buy(tv));
				break;
			case "2" :
				Smartphone sm = new Smartphone();
				JOptionPane.showMessageDialog(null, service.buy(sm));
				break;
			case "3" :
				Cleaner cl = new Cleaner();
				JOptionPane.showMessageDialog(null, service.buy(cl));
				break;
			case "4" :
				Computer pc = new Computer();
				JOptionPane.showMessageDialog(null, service.buy(pc));
				break;
			case "5" :
				JOptionPane.showMessageDialog(null, "남은 잔액:" + c.getMoney());
				break;
			default:
				JOptionPane.showMessageDialog(null, service.getBill());
				return;
			}
		}
	}
}
