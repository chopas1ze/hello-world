package java0705_basic_operator;

public class Java007_operator {
	/*
	 * 연산자(operator)
	 * 어떠한 기능을 수행하는 기호(+,-, *,/,%, >, <,==, !=....)
	 * 
	 * 피연산자(operand)
	 * 연산자의 작업 대상(변수, 상수, 리터널, 수식)
	 * 
	 * 연산자 종류
	 * 1 산술연산자 : +,-, *,/(몫),%(나머지)
	 * 2 비교연산자 : >, <, >=, <=, !=(다르다), ==(같다) : 논리값
	 * 3 논리연산자 : &&(and), ||(or), !(not) : 논리값
	 * 4 삼항연산자(조건연산자) : 조건식?참:거짓      : 논리값
	 * 5 대입연산자 : =, +=, -=, *=, /=....
	 * 6 단항연산자 : ++(1씩증가),--(1씩감소)
	 */
	/* 
	 * 연산자 우선순위
	 * 단항연산자>산술연산자>비교연산자>논리연산자>삼항연산자>대입연산자
	 */
	public static void main(String[] args) {
		int numX=10;
		int numY=5;
		
		//int=int+int
		int res=numX+numY;
		
		short numA=3;
		short numB=5;
		
		//int데이터 타입 이하끼리 연산이 되면 결과는 무조건 int 데이터 타입이다.
		//ex) char+char = int , byte+byte = int 
		//short data=numA+numB; -> error
		int data=numA+numB;
		
		//다른 데이터 타입끼리 연산이 되면 결과 데이터 타입은 큰 데이터 타입이다.
		//int=short+int 
		int pk=numA+numX;
		
		byte ma=2;
		// byte+shrot = int
		int pn=ma+numA;
		
		
	}//end main()

}//end class
