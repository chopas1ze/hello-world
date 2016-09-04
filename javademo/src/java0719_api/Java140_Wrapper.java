package java0719_api;

/*
 * sn변수에 저장된 문자열중에서 숫자갯수를 출력하는 프로그램을 구현하시오.
 * [출력결과]
 * 숫자갯수:3
 */

public class Java140_Wrapper {

	public static void main(String[] args) {
     String sn="korea12 paran3";
     char[] ab=sn.toCharArray();
     int cnt = 0;
     for(int i = 0; i<ab.length;i++){
    	 if(Character.isDigit(ab[i])){
    		 cnt += 1;
    	 }
     }
     System.out.println("숫자갯수:"+cnt);
     
	}// end main()

}// end class
