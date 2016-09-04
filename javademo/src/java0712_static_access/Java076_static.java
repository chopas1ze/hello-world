package java0712_static_access;
/*
 * 프로그램의 실행과정
 * 1. 소스 코드 작성     Java076_static.java
 * 2. 클래스 파일 생성(컴파일) javac Java076_static.java
 * 3. 클래스 파일 실행(run)  java Java076_static
 * 4. 클래스 로딩 -메모리로 읽어온다.
 *       static키워드를 사용한 변수와 메소드를 자동으로 메모리에 로딩한다
 * 5. main()메소드 실행-main스레드에서 main()메소드를 호출한다.
 * 6. 객체생성(new)
 * 7. 변수,메소드를 호출
 * 8. main()메소드 종료-프로그램 종료
 * 
 * static
 * 1. 같은 데이터 타입으로 생성된 객체끼리는 서로 공유한다.
 * 2. 클래스가 로딩되는 시점에 메모리(메소드영역)에 저장된다.
 * 3. static키워드가 선언된 메소드에서는 this(this는 new로 메모리 생성후 사용가능.new로 메모리에 생성이 안된 시점에서 사용하면 당연히 안됨.),super키워드를 사용할 수 없다. 
 */

class StaticEx {
	int x = 5;
	static int y = 10; // 클래스 로딩때 메소드 영역에 저장된다. 클래스.변수(StaticEx.y) 로 표현 가능. 
            		   // 자바에서 권장

	public StaticEx() {

	}

	public void prn() {
		System.out.printf("%2d %2d\n", x, y);
	}
}

public class Java076_static {

	public static void main(String[] args) {
		StaticEx se = new StaticEx();
		// se.prn();
		se.x = 20;
		StaticEx.y = 30;
		System.out.printf("se.x=%2d  se.y=%2d\n", se.x, StaticEx.y);

		StaticEx ss = new StaticEx();
		// ss.prn();
		System.out.printf("se.x=%2d  se.y=%2d\n", ss.x, StaticEx.y);

	}// end main()

}// end class
