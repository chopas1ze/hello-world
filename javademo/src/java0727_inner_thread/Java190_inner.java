package java0727_inner_thread;
/*
 * 지역클래스에서 외부클래스 메서드의 매개변수, 지역변수를
 * 호출하기 위해서는 final이 선언되여 있어야 한다.
 * 하지만, jdk8버전부터는 final이 선언되어 있지 않아도 호출이 가능하다.
 */
class OuterLocal {
	private int x;
	static int y;
	final private int Z = 10;

	public void call(final int a) { // 매개변수를 int a 로 해도 되는건 자바8버전에서부터 
									// final 알아서 붙여줌.
		final int b = 20;
		int c = 30;
		// c = 50; int c 가 final int c 로 인식되기 떄문에 오류뜸.
		class InnerLocal {
			void prn() {
				x = 5;
				y = 150;
				System.out.println("x=" + x);
				System.out.println("y=" + y);
				System.out.println("Z=" + Z);
				System.out.println("a=" + a);
				System.out.println("b=" + b);

				System.out.println("c=" + c); // 자바8버전부터 알아서 final 붙여줌
			}

		}// end InnerLocal

		InnerLocal inner = new InnerLocal();
		inner.prn();

	}// end call()

}// end OuterLocal

public class Java190_inner {

	public static void main(String[] args) {
		OuterLocal outer = new OuterLocal();
		outer.call(100);

	}// end main()

}// end class
