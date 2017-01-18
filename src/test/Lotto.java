package test;

/**
@FILE  : LottoDraw.java
@DATE  : 2016. 12. 27.
@AUTHOR: J.John Park
@STORY
	Collect the lotto, 1~45 random number, the number of ball is 6. 
	if a ball was submitted, except for this ball from list.
	Print is [5,23,12,40,19,22]
 */
public class Lotto {
	private int[] ball; 
	public void draw() {
		int i = 0, draw = 0, ball1 = 0, ball2 = 0, ball3 = 0, ball4 = 0, ball5 = 0, ball6 = 0;
		for(;i<6;i++) {
			draw = (int)(Math.random()*45+1);
			switch(i) {
			case 0:
				ball1 = draw;
				break;
			case 1:
				ball2 = draw;
				i = (ball2 == ball1) ? i-- : i;
				break;
			case 2:
				ball3 = draw;
				i = (ball3 == ball2 || ball3 == ball1) ? i-- : i;
				break;
			case 3:
				ball4 = draw;
				i = (ball4 == ball3 || ball4 == ball2 || ball4 == ball1) ? i-- : i;
				break;
			case 4:
				ball5 = draw;
				i = (ball5 == ball4 || ball5 == ball3 || ball5 == ball2 || ball5 == ball1) ? i-- : i;
				break;
			case 5:
				ball6 = draw;
				i = (ball6 == ball5 || ball6 == ball4 || ball6 == ball3 || ball6 == ball2 || ball6 == ball1) ? i-- : i;
				break;
			}
		}
		System.out.printf("[%d, %d, %d, %d, %d, %d]", ball1, ball2, ball3, ball4, ball5, ball6);
	}
}
