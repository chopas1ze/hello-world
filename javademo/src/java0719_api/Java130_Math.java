package java0719_api;

/*
 * 클래스에서 static 키워드가 선언된 맴버변수, 메소드를 호출할때
 * import static을 선언하면 클래스명없이 바로 맴버변수, 메소드를 호출 할 수 있다.
 */
import static java.lang.Math.E;
import static java.lang.Math.sqrt;
import static java.lang.Math.*;  //모든 메소드 호출

/*
 * 수학관련 클래스
 * java.lang.Math
 */
public class Java130_Math {

	public static void main(String[] args) {
		// Math클래스는 생성자가 없고, 어디서든 사용가능하기 위해 모든 메소드에 static 이 선언되어 있음.
		System.out.println(Math.PI); // 원주율 3.141592.....
		System.out.println(Math.max(10, 20)); // 최대값 20
		System.out.println(Math.min(10, 20)); // 최소값 10
		// import
		System.out.println(E); // 지수 2.718281828459045
		System.out.println(sqrt(25)); // 제곱근 5.0
		// System.out.println(Math.sqrt(25));
		System.out.println(pow(2, 3)); // 거듭제곱 8.0

	}// end main()

}// end class
