package java0718_api;

/*
 * [출력결과]
 * 홍길동님은 남성입니다.
 * 응삼이님은 여성입니다.
 */
public class Java117_String {

	public static void main(String[] args) {
			String p1="홍길동,561203-1597650";
			String p2="응삼이,030628-4056892";
			display(p1);
			display(p2);
			

	}//end main()

	public static void display(String str){
		//여기를 구현하세요.
		int index = str.indexOf("-");
		if(str.charAt(index+1)=='1' || str.charAt(index+1)=='3'){
			System.out.println(str.substring(0,3)+"님은 남성입니다.");
					}
		else{
			System.out.println(str.substring(0,3)+"님은 여성입니다.");
		}
		
				
		/* String[] arr=str.split(",");
		 * char data=arr[1].charAt(7);
		 * if(data=='1' || data=='3')
		 * system.out.printf("%s님은 남성입니다.\n",arr[0]);
		 * else if(data=='2' || data=='4')
		 * system.out.printf("%s님은 여성입니다.\n",arr[0]);
		 * else
		 * system.out.println("잘못입력하셨습니다");
		 */
			
		
		
	}//end display()
	
}//end class
