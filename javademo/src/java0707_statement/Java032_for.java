package java0707_statement;

//3의 배수만 제외하고 출력하는 프로그램을 구현하세요.
//for문에서는 continue를 만나면 증감식으로 이동한다.
//반복문에서 continue를 만나면 조건식으로 이동하는것도 맞다. 
public class Java032_for {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++){
			if(i%3==0){
				// 반복문에서만 continue키워드를 사용한다.
				continue; // 증감식으로 무조건 이동한다. 
			}
			System.out.println(i);
		}
		
	}//end main()
}//end class
