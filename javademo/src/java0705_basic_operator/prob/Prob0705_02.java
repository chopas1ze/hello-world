package java0705_basic_operator.prob;

/*
 * data변수의 값이 대문자 이면 'A', 소문자이면 'a'을 
 * 출력하는 프로그램을 구현하시오.
 * [실행결과]
 * a
 */
public class Prob0705_02 {

	public static void main(String[] args) {
		char data='b'; //A ~ Z  a~z
		//여기에 작성하시오
		char result=data>='A' && data<='Z'?'A':'a';
		System.out.println(result);
		 
	}

}



