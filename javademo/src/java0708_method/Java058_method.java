package java0708_method;
/*
 * [실행결과]
 * tset avaj
 */

public class Java058_method {
	static char[] arr = { 'j', 'a', 'v', 'a', ' ', 't', 'e', 's', 't' };

	public static void main(String[] args) {
		System.out.println(reverse(arr));   // 리턴타입이 char배열일때만 이렇게 호출. 배열안의 요소가 호출됨.
		System.out.println(new int[]{1,2,3});  // 숫자는 호출안됨. 주소나옴 [IQ15db9742
	}// end main()
	public static int[] process(){
		return new int[]{1,2,3};
	}
	
	public static char[] reverse(char[] data) {
		// data의 요소 앞뒤를 바꿔서 리턴하는 프로그램을 구현하세요.
		char[] num=new char[data.length];
		for(int i =0; i<num.length;i++){
			num[i]=data[data.length-1-i];
			
		}
		return num;

	}// end main()

}// end class
