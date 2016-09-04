package java0715_abstract_interface;

interface TestB {
	void prn();
}
/* int prn(){
 * }
 */

interface TestC {
	void prn();
}
     

class TestD {
	void prn() {
		System.out.println("TestD");
	}

}

class TestE extends TestD {
	@Override // 컴파일 단계에서 오버라이딩 검사를 해준다.
	void prn() {
		System.out.println("TestE"); // 결과는 TestE 찍힘. 오버라이딩 된것이기 때문에.
	}
}



class TestA implements TestB, TestC{

	@Override
	public void prn() {  //마지막 상속 인터페이스의 오버라이딩이 된다. TestC
		
	}

	/* public int prn(){  // TestB
	 * return e;
	 * }
	 * public void prn(){   // TestC
	 * }
	 * 오류 뜬다. 메소드명이 같은데 리턴 타입이 다르기 때문. 
	 */
	
}// end TestA/////////////

public class Java101_interface {

	public static void main(String[] args) {
		TestE te = new TestE();
		te.prn();

	}// end main()

}// end class
