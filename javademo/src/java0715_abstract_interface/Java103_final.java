package java0715_abstract_interface;
/*
 * final
 * 1 변수 : 상수 
 *   int num=10;
 *    num=20;
 *   final int DATA=5;
 *    data=10;(X)
 * 2 메소드 : 오버라이딩 할 수 없다.
 *   final void prn(){}   //상속이 되야 오버라이딩이 되기 때문.
 * 3 클래스 : 상속을 할 수 없다.
 *    final class Test{ }  
 */

class FinalTest {
	final int CODE = 1;

	final void process() {
		System.out.println("process");
	}

	void call() {
		System.out.println("call");
	}

}// end FinalTest/////

class UserFinal extends FinalTest {
	@Override
	void call() {
		super.call();
	}
	// void process(){}   //오류  
}

final class Basic {

}

//class Expand extends Basic {}  //오류


public class Java103_final {

	public static void main(String[] args) {

	}// end main()

}// end class
