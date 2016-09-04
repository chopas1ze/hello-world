package java0707_statement;
/*
 * while(조건식){
 * 수행할 문장;  증감식을 수행할 문장에 넣어야해서 불편.
 * 조건식 = 논리값
 * }
 */

public class Java036_while {

	public static void main(String[] args) {
		for(int i=1;i<=5; i++){
			System.out.println(i);
		}
	System.out.println("////////////////////////");	
		int j = 1;
		while(j<=5){
			System.out.println(j);
			j++;
			
		}
		
	System.out.println("/////////////////////");
	int k=0;
	while(k++<5){
		System.out.println(k); //후증가일때 부등호 확인 <= 면 6까지 찍힘.
	}
	
	}//end main()

}//end class
