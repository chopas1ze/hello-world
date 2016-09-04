package java0714_inheritance;

class MyGrand {
	public MyGrand() { // 6
		System.out.println("조상생성자"); // 7
	} // 8
}// end MyGrand class

class MyFather extends MyGrand {
	public MyFather() { // 4
		super(); // 5
		System.out.println("부모생성자"); // 9
	} // 10
}// end MyFather class

class My extends MyFather {
	// 자손생성자에서는 반드시 조상생성자를 호출해야한다.
	// 조상생성자 호출이 생략되어 있으면 JVM에서 super()로 호출한다.
	// this = 자신 super = 부모
	public My() { // 2
		super(); // 3
		System.out.println("자손생성자"); // 11
	} // 12
}// end My class

public class Java087_inheritance {

	public static void main(String[] args) {
		My mm = new My(); // 1

	}// end main() // 13

}// end class
