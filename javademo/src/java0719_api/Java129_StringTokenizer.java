package java0719_api;

import java.util.StringTokenizer;

public class Java129_StringTokenizer {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("java,,jsp/spring",",/");
		System.out.println("countTkoen:"+st.countTokens());  //3
		while (st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}

		System.out.println("///////////////////////");
		//무조건 구분자 갯수만큼 문자열을 나눈다. 그래서 공백포함 4개로 나눔.
		String[] data="java,,jsp/spring".split("[,/]");
		System.out.println("countToken:"+data.length);  //4 
		for(String ss : data){
			System.out.println(ss);
		}
			
	}//end main()

}//end class
