package java0712_static_access;

class OrderStatic {
	// 실행순서
	static { // 1
		System.out.println("static");
	}

	public OrderStatic() { // 3
		System.out.println("constructor");
	}

	public void prn() { // 5
		System.out.println("prn");
	}

}// end class

public class Java077_static {

	public static void main(String[] args) {
		OrderStatic ss = new OrderStatic(); // 2
		ss.prn(); // 4
	}// end main()

}// end class
