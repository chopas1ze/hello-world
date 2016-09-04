package java0719_api;

import static java.lang.Math.*;

public class Java131_math {

	public static void main(String[] args) {
		// 0.0부터 1.0미만 사이의 난수 발생
		double ran = random();
		System.out.println(ran); //0.18839376579282774
		
		//0.0~10.0 미만 사이의 수 
		ran=ran*10;
		System.out.println(ran); //9.000020778682075
		
		//0~10미만
		int num=(int)floor(ran);  //floor() 소숫점 이하값을 버림. 리턴타입은 더블.  2.5 -> 2
		//int num=(int)ran;   <- 반올림이 됨.  2.5 -> 3
		System.out.println(num);  //9
		
		
		
	}// end main()

}// end class
