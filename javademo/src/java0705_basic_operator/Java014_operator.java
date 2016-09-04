package java0705_basic_operator;

public class Java014_operator {

	public static void main(String[] args) {
		// 복합 대입 연산자
		int a = 3;
		int b = 4;
		int res;
		res = a + b;
		
		// '=' 연산자를 기준으로 좌변과 우변이 같을때는 대입복합연산자를 사용할 수 있다.
		// res=res+a; 
		res += a; //+,-,*,/,% 
		System.out.println(res);
		
	}// end main()

}// end class
