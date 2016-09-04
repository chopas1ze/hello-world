package java0705_basic_operator;

public class Java005_casting {

	public static void main(String[] args) {

		/*
		 * 형변환(casting)
		 * 1 값의 타입을 다른타입으로 변환하는 것이다.
		 * 2  묵시적형변환
		 *     작은 값의 데이터 타입을 큰 값의 데이터 타입으로 변환할때 발생한다.
		 *     int num;
		 *     short data=50;
		 *     num=data;
		 *     
		 *    명시적형변환
		 *    큰 값의 데이터 타입을 작은 값의 데이터 타입으로 변화할때 발생한다.
		 *    double paran=10.5;
		 *    num=(int)paran;
		 */
		
		// 작은타입의 변수를 더 큰타입의 변수로 형변환시 묵시적 형변환이 된다.
		int numX = 5;
		// double res = (double)numX; 원래대로라면 이렇게 표현
		double res = numX; //묵시적 형변환
		//" " 안에 문자열을 넣으면 그대로 출력됨 (문자와 문자열은 다름)
		// + : 호출
		System.out.println("res:"+res);
		
		// 큰 타입의 변수에서 작은 타입의 변수로 형변환시는 꼭 명시해야 한다
		short pa=(short)numX; //명시적 형변환
		System.out.println("pa:"+pa);
		
		
		
	}//end main()
} //end class
// end마다 습견 들여 주석 처리