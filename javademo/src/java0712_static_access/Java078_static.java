package java0712_static_access;

class ThisStatic {

	public ThisStatic() {

	}

	public void prn() {
		System.out.println("this");
	}

	public static void process() {
		System.out.println("static");
	}

	public static void call() {

		// static이 선언된 메소드에서는 비-static자원(맴버변수,메소드를)를 호출할 수 없다.
		// prn();
		
		process(); //메소드 영역에 있으니까  내부에서 ThisStatic.process() 으로 처리함. 
	}
}// end ThisStatic

public class Java078_static {

	public static void main(String[] args) {
		ThisStatic tc = new ThisStatic();
		tc.call();

	}// end main()

}// end class
