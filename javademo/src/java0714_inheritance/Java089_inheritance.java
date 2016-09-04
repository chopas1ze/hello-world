package java0714_inheritance;

class Parent {
	String name;
	int age;

	public Parent() { // 무인자 생성자는 항상 생성해두는것을 권장.

	}

	public Parent(String name, int age) { // 4
		this.name = name; // 5
		this.age = age; // 6
	} // 7

}// end Parent class

class Sun extends Parent {
	String dept;

	public Sun() {

	}

	public Sun(String name, int age, String dept) { // 2
		super(name, age); // 3
		this.dept = dept; // 8
	} // 9

	public void prn() { // 11
		System.out.printf("%s %d %s\n", name, age, dept); // 12
	} // 13
}// end Sun class

public class Java089_inheritance {

	public static void main(String[] args) {
		Sun ss = new Sun("홍길동", 50, "기획부"); // 1
		ss.prn(); // 10

	}// end main() // 14

}// end class