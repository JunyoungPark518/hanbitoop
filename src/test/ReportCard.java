package test;

/**
@FILE  : ReportCard.java
@DATE  : 2016. 12. 23.
@AUTHOR: J.John Park
@STORY
	한 학생의 점수들을 입력받고 총 점수 및 평균 점수를 환산하여 등급을 매기는 프로그램을 작성.
	점수를 입력받는 부분에서 -1을 입력받게 되면 프로그램이 중지되며, 기존에 입력받은 값들을 토대로 결과를 출력.
 */
public class ReportCard {
	private String name;
	private int score, average, total, subjects;
	private char grade;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getAverage() {
		return average;
	}
	
	public void setAverage(int average) {
		this.average = average;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getSubjects() {
		return subjects;
	}
	
	public void setSubjects(int subjects) {
		this.subjects = subjects;
	}
	
	public char getGrade() {
		return grade;
	}
	
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	public void calc() {
		average = total / subjects;
		if(average >= 90){
			grade = 'A';
		} else if(average >= 80) {
			grade = 'B';
		} else if(average >= 70) {
			grade = 'C';
		} else {
			grade = 'D';
		}
		
	}
}
