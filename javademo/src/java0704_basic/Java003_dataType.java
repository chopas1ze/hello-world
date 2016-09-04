package java0704_basic;

//주석 : 코드에 대한 설명을 의미한다.
//한라인에 대한 주석

/*
  여러 라인에 대한 주석. 줄마다 * 없어도 상관없음.	
 */

/* 
 *자바에서 재공하는 데이터타입
 *1 기본 데이터 타입(소문자) 정수의 기본은 int 실수는 double
 * 숫자:정수=> byte(1byte), short(2byte), int(4byte), long(8byte) 실수=> float(4byte), double(8byte)
 * 문자: char(2byte)
 * 논리: boolean(1byte)
 *2 창조 데이터 타입
 * 배열, 클래스, 인터페이스
 * 
 * 시스템에서 인식하는 데이터 타입의 크기
 * byte < short,char < int < long < float < double
 */

public class Java003_dataType {

	public static void main(String[] args) {
		// 변수 : 하나의 값을 저장하기 위한 메모리 공간
		int num = 10;

		// data변수에 저장할 수 있는 값의 데이터 타입은 int이므로
		// double타입인 3.5은 data변수에 저장 할 수 없다.
		// int data=3.5;

		//  byte,short 값이 그 타입에 맞다면 알아서 그 타입에 들어감
		// -128 ~ 127
		byte check = 127;
		// -32768 ~ 32767
		short kt = 127;
		// int값 43은 long에 넣어도 남는 공간이 있으니 들어가서 오류가 발생하지 않기때문에, long 값 뒤에 기호 L이나 l을 넣어줘야함
		long ko = 43L;
		// float 값 뒤에는 F를 붙여준다
		float avg = 4.5F;
		double sum = 9.3;
		// 메모리에 저장할때 문자는 소문자만 허용.
		char alpa='a';
		// true, false 는 소문자
		boolean is=true;
		// bootlean is=false 는 안됨. 이미 메모리에 변수를 저장했기 때문.
		is=false;
		
	}//end main()
}//end class
