package java0706_statement;

/*
 * switch(식){
 *   case 값1 : 문장1; break;
 *   case 값2 : 문장2; break;
 *   case 값3 : 문장3; break;
 *   default : 문장4;
 * }
 * 
 * 식의 결과리턴타입 : byte, short, int,  char, enum(7버전부터),String(7버전부터) 자바는 boolean 은 안됨. 자바스크립트는 됨.
 * 
 * switch~case에서 break을 만나면 현재 수행중인 조건문을 완전히 빠져나와
 *   다음문장을 수행한다.
 *   범위가 있는값은 if ~ else 를 사용하고 결과값이 딱 떨어지는값은 switch ~ case를 사용. 
 */
public class Java024_switch {

	public static void main(String[] args) {
		int jumsu = 100; //1
		char res;//2

		switch (jumsu / 10) { //3
		case 10://4
			//res = 'A';  break가 없으면 다음 케이스의 문장을 수행하고 break되어 빠져나옴.  
			//break;
		case 9:
			res = 'A'; //5
			break; //6
		case 8:
			res = 'B';
			break;
		case 7:
			res = 'C';
			break;
		case 6:
			res = 'D';
			break;
		default:
			res = 'F';
		}

		System.out.printf("%d점수는 %c학점입니다.\n",jumsu,res); //7
	}// end main()

}// end class
