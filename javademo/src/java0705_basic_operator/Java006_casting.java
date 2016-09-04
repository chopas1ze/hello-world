package java0705_basic_operator;

/*
 * 자바에서 문자를 표현하기 위해 유니코드를 사용한다.
 * '0' => 48
 * 'a' => 97
 * 'A' => 65
 * 대문자와 소문자의 차이값은 32이다. '소문자 - 32 = 대문자'
 */
public class Java006_casting {
	public static void main(String[] args) {
		char data='a';
		char aa='A';
		char bb='0';
		int asc=data;
		int aaa=aa;
		int bbb=bb;
		
		System.out.println(asc);
		System.out.println(aaa);
		System.out.println(bbb);
		// int - char 은 int로 받게 됨.(큰쪽으로 받게됨) 그래서 괄호 먼저 계산하게하고 char로 형변환시킴.
		// data-32의 결과 리턴 데이터 타입은 int이다.
		
				
				char alpaUpper=(char)(data-32);
		System.out.println(alpaUpper);
		
		//명시적 형변환을 할때 데이터타입 범위안의 값으로 입력해야함.
		//명시적 형변환을 할때 값의 범위에 주의한다.
		short num=128;
		byte one=(byte)num;
		System.out.println(one);
		
		// "sysout" + ctrl + 스페이스 : System.out.println();
				
	}//end main()
}//end class
