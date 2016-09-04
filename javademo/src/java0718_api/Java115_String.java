package java0718_api;

public class Java115_String {

	public static void main(String[] args) {
		String str = new String("koREa,jsp,java");
		System.out.println("문자열 길이:" + str.length()); // 14
		System.out.println("대문자:" + str.toUpperCase()); // KOREA,JSP,JAVA
		System.out.println("소문자:" + str.toLowerCase()); // korea,jsp,java
		System.out.println("문자:" + str.charAt(1)); // o
		System.out.println("인덱스:" + str.indexOf('R')); // 2
		System.out.println("범위:" + str.substring(5)); // ,jsp,java 5이하 뒷 출력
		System.out.println("범위:" + str.substring(2, 8)); // REa,js 2부터 8미만

		String[] arr = str.split(","); // ,를 기준으로 구분하여 배열을 나눈다.
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%s\n", i, arr[i]);
		}

		int x = 10;
		int y = 20;
		System.out.printf("%d+%d=%d\n",x,y,x+y);
		
		//int => String 타입으로 힙영역에 복사해온것.
		String s1=String.valueOf(x);    // static 이 선언되어 있기 떄문에 new없이 호출가능.
		String s2=String.valueOf(y);
		System.out.printf("%s+%s=%s\n",s1,s2,s1+s2);  // +는 문자열 연결의 의미로 사용됨.
		
		char[] data={'1','2','3'};
		String s3=String.valueOf(data);
		System.out.println(s3);
		
		
		
	}// end main()

}// end class
