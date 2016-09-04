package java0708_method;

public class Java049_method {

	
	public static void main(String[] args) {
		//매개변수가 선언된 메소드를 호출할 때 매개변수에 정의된
		//데이터 타입과 일치하는 값을 넘겨준다.
		process("홍길동"); //1
		test(3000); //3
		
	}//end main()  //5

	public static void test(int point){
		System.out.println(point+"포인트 적립되었습니다.");  //4
	}//end test()
	
	public static void process(String name){  //1
		System.out.println(name+"님은 회원입니다."); //2
	}//end process()
	
}//end class()
