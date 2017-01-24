package hospital;

public class BMI extends Treatment {
	// setter를 생략하면, readOnly 파일
	// stand alone method
	@Override
	public String treat() {
		double bmi = weight / (height * height);
		String result = "";
		if(bmi>30) {
			result = "고도비만";
		} else if(bmi>25) {
			result = "비만";
		} else if(bmi>23) {
			result = "과체중";
		} else if(bmi>18.5) {
			result = "정상";
		} else {
			result = "저체중";
		}
		return result;
	}
}
