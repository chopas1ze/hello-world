package java0719_api;

public class Java139_Wrapper {

	public static void main(String[] args) {
		char data = 'd';
		
		//대문자
		System.out.println(Character.toUpperCase(data));  //D
		
		//소문자
		System.out.println(Character.isLowerCase(data));  //true
		
		//숫자
		System.out.println(Character.isDigit(data));   //false
		
		//알파벳
		System.out.println(Character.isAlphabetic(data));  //true
				
		
		
	}//end main()

}//end class
