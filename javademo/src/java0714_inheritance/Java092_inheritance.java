package java0714_inheritance;

/*
다음과 같은 결과가 나오도록 수정하시오
(단, main()안의 내용수정과 새로운 Method추가하지마시오)

**** x,y,z에 값채우기***  //
10을 넘겨받은 생성자
10   20   을 넘겨받은 생성자
10   20   30  을 넘겨받은 생성자
10   20   30
합 : 60

*/

class SuperClass {
	int x, y, z;

	public SuperClass() { // 10
		System.out.println("**** x,y,z에 값채우기***"); // 11
	} // 12

	public SuperClass(int k) { // 8
		this(); // 9
		this.x = k; // 13
		System.out.println(k + "을 넘겨받은 생성자"); // 14
	} // 15

	public SuperClass(int a, int b) { // 6
		this(a); // 7
		this.y = b; // 16
		System.out.println(a + "   " + b + "   을 넘겨받은 생성자"); // 17
	} // 18

	public SuperClass(int a, int b, int c) { // 4
		this(a, b); // 5
		z = c; // 19
		System.out.println(a + "   " + b + "   " + c + "   을 넘겨받은 생성자"); // 20
	}

	public void display() { // 22
		System.out.printf("%d %d %d\n", x, y, z); // 23
	} // 24
}

class SubClass extends SuperClass {

	public SubClass(int a, int b, int c) { // 2
		// 여기를 구현하세요.//////////////////////
		super(a, b, c); // 3
		display(); // or super.display();  //21
		sumData(); // 25

	}

	public void sumData() { // 26
		System.out.println("합 : " + (x + y + z)); // 27
	} // 28
}

public class Java092_inheritance {

	public static void main(String[] args) {
		SubClass ss = new SubClass(10, 20, 30); // 1

	}// end main() //29

}// end class
