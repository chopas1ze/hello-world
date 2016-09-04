package java0719_api;

/*
 * java.lang.String : 불변
 * java.lang.StringBuffer: 가변, 비동기화
 * java.lang.StringBuilder : 가변, 동기화
 */
public class Java125_StringBuffer {

	public static void main(String[] args) {
		String sg = new String("java test");
		sg.replace("java", "jsp");
		System.out.println(sg); // java test <- 불변 //heap영역에 스트링 버퍼 메모리 생성하고
								// String 문자를 복사해온후 버퍼안에서 변경한 상태라 변경안됨.
								// 메모리 자체 내용은 변하지 않는다는것.
		String ss = sg.replace("java", "jsp");
		System.out.println(ss); // jsp test //StringBuffer 내용을 가지고 새로운 객체로 생성하기 때문에 가변.

		System.out.println("///////////////////////");
		StringBuffer sb = new StringBuffer("spring test");
		sb.replace(0, 6, "framework");  // 0인덱스부터 6 미만을 framework로 교체 framework test
		System.out.println(sb);
		
	}// end main()

}// end class
