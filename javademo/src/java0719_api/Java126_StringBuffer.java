package java0719_api;

public class Java126_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("java test");

		// 4인덱스에 ",jsp"문자열을 삽입한다.
		sb.insert(4, ",jsp");
		System.out.println(sb); // java,jsp test 공백이 밀림.

		// 4인덱스부터 8미만 사이의 문자열을 삭제한다.
		sb.delete(4, 8);
		System.out.println(sb); //java test
		
		//0인덱스의 문자를 삭제한다.
		sb.deleteCharAt(0); 
		System.out.println(sb);  //ava test
		
		//" sample" 문자열을 추가한다.
		sb.append(" sample");
		System.out.println(sb);	//ava test sample
		
		//문자열을 반대로 변경해서 리턴한다.
		sb.reverse();
		System.out.println(sb);  //elpmas tset ava
		
		String data = "mybatis orm";
		StringBuffer ss = new StringBuffer(data);
		ss.reverse();
		System.out.println(ss); //mro sitabym
		
		char[] arr = new char[]{'k','o','r','e','a'};
		String sn = new String(arr);
		StringBuffer sf = new StringBuffer(sn);
		sf.reverse();  //reverse() 는 StringBuffer 에만 정의되어 있음.
		System.out.println(sf);  //aerok
		
	}// end main()

}// end class
