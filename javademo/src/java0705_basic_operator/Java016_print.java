package java0705_basic_operator;

public class Java016_print {

	public static void main(String[] args) {
		System.out.println("java"); //줄바꾸기 자동됨
		System.out.print("jsp\t"); // \t 탭키 
		System.out.print("spring\n"); // \n 엔터키
		
/*
 * 출력기호
 * %d : 정수 
 * %f : 실수    (f실수값 소수자리 지정은  %.숫자f  이다.)
 * %c : 문자 ''
 * %b : 논리(boolean)
 * %s : 문자열 ""
   \" : " 문자로 사용.  \는 키보드에 있는 기호를 문자로 사용할때 사용
   %% : %를 문자로 사용
   %^s : ^ = 자릿수  ex) %5s 자릿수 안에서 출력되고 빈공간은 공백으로 됨.
   %5.1f : 소수점 포함하여 5자리에 출력. 숫자가 크면 자릿수는 무시함.
  */
		
		// System.out.printf("출력형식",값1,값2,값3...);
		System.out.printf("%s님의 평균은 %.1f 이므로 %c입니다.\n","홍길동",95.0,'A');
		// 
	System.out.printf("당신의 색깔은 \"%s\"입니다.\n","빨강");
	System.out.printf("%d %% %d=%d\n", 3,2,3%2);
	System.out.printf("%s\n", "abcdefghi");
	System.out.printf("%5s\n", "ab");
	System.out.printf("%6s\n", "자바");
	System.out.printf("%f\n",12345.45);
	System.out.printf("%5.1f\n",12.4);
	}//end main()

}//end class
