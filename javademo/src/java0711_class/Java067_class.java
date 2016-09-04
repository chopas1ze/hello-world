package java0711_class;



/*피자의 반지름을 10, 도넛의 반지름은 2로 한다.
 * 
 * [실행결과]
 * 자바피자의 면적은 314.0
 * 자바도넛의 면적은 12.56
 */

class Circle {
	int radius; // 원의 반지름을 저장하는 멤버 변수
	String name; // 원의 이름을 저장하는 멤버 변수

	public double getArea() { // 멤버 메소드
		return 3.14 * radius * radius;
	}
}// end class////////////////////////

public class Java067_class {

	public static void main(String[] args) {
		// 여기를 구현하세요.////////////////////
		Circle cc = new Circle();
		cc.name = "자바피자";
		cc.radius = 10;
		System.out.println(cc.name + "의 면적은 " + cc.getArea());

		Circle dd = new Circle();
		dd.name = "자바도넛";
		dd.radius = 2;
		System.out.println(dd.name + "의 면적은 " + dd.getArea());
		
	/*
	    Circle pizza; // 객체에 대한 레퍼런스 변수 pizza 선언
		pizza = new Circle(); // Circle 객체 생성
		pizza.radius = 10; // 피자의 반지름을 10으로 설정
		pizza.name = "자바피자"; // 피자의 이름 설정
		double area = pizza.getArea(); // 피자의 면적 알아내기
		System.out.println(pizza.name + "의 면적은 " + area);

		Circle donut = new Circle(); // Circle 객체생성
		donut.radius = 2; // 도넛의 반지름을 2로 설정
		donut.name = "자바도넛"; // 도넛의 이름 설정
		area = donut.getArea(); // 도넛의 면적 알아내기
		System.out.println(donut.name + "의 면적은" + area);
*/
	}// end main()

}// end class
