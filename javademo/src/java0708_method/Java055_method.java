package java0708_method;

public class Java055_method {

	public static void main(String[] args) {
		int data = 9;
		boolean res = process(data);
		if (res) { //true
			System.out.printf("%d는(은) 짝수입니다.\n", data);
		} else {
			System.out.printf("%d는(은) 홀수입니다.\n", data);
		}
	}

	public static boolean process(int data) {
		// data매개변수의 값이 짝수 이면 true;
		// 홀수이면 false을 리턴하는 프로그램을 구현하세요.
		if (data % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}// end process()

}// end class
