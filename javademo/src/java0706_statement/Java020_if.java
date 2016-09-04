package java0706_statement;

/*
 * 다중 if-else
 * if(조건식1){
 * 수행할 문장;
 * }else if(조건식2){
 * 수행할 문장;
 * }else if(조건식3){
 * 수행할 문장;
 * }else{
 * 수행할 문장;
 * }
 * 
 */
public class Java020_if {

	public static void main(String[] args) {  
		char code = 'B';  //1  a
		if (code == 'A') { //2 b
			System.out.println("식품류");
		} else if (code == 'B') { //3 c
			System.out.println("육류");  //d
		} else if (code == 'C') { //4
			System.out.println("야채류");
		} else { //5
			System.out.println("기타");  //6
		}
		System.out.println("마트 코드 븐류"); //7  e

	}// end main()

}// end class
