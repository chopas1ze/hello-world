package java0706_statement;

/*
 * if(조건식){
 *  	if(조건식){
 *			수행할문장;  
 *	}else{
 *			수행할문장;
 *  }
 *  }else{
 * 			수행할 문장;
 * }
 */
public class Java019_if {

	public static void main(String[] args) {
		boolean member=true; //회원 or 비회원 //1  a
		String grade="일반"; // 회원일때 등급       String은 참조데이터의 클래스의 부분 //2  b
		
		if(member){ //3  c
			if(grade=="VVIP"){  //d  
				System.out.println("30%적립");
			}else{
				System.out.println("10%적립");  //e
				
			}
		}else{
			System.out.println("비회원"); //4
		}
		System.out.println("고객님 감사합니다.");  //5  f

	}//end main*()

}//end class
