package java0714_inheritance;

class SuperConst {
	int x=5;
	int y=19;

	public SuperConst(int x, int y) { // 4 //생성자가 있기 때문에 기본생성자를 제공하지 않는다.
		this.x = x; // 5 // 멤버변수 앞에 this를 붙인다.
		this.y = y; // 6
		System.out.printf("x=%d y=%d\n", x, y); // 7 // 매개변수 대신 멤버변수를 출력하고싶으면
											     	// this붙인다.
		
	} // 8
}// end SuperConst class

class SubConst extends SuperConst {
	SubConst() { // 2 // 기본생성자의 접근제어자는 클래스의 접근제어자를 따라서 명시됨.
		super(10, 20); // 3
	} // 9
}// end SubConst class

public class Java088_inheritance {

	public static void main(String[] args) {
		SubConst sc = new SubConst(); // 1

	}// end main() // 10

}// end class
