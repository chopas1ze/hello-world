package java0718_api;

public class Java114_String {

	public static void main(String[] args) {

		String sn = "java";
		String sg = "java";
		String st = new String("java");
		String ss = new String("java");
		
		//== 주소비교
		System.out.printf("sn==sg:%b\n",sn==sg);  // 힙메모리에 기본타입으로 저장된 배열을 먼저 찾아서 있기 때문에 true
		System.out.printf("st=ss:%b\n",st==ss);  // 힙메모리에 객체로 따로 생성되어 있기때문에 false
		
		//equals()   : 메모리에 저장된 문자열(데이터) 비교  // 대소문자도 구별해서 비교
		System.out.printf("sn.equlas(sg):%b\n",sn.equals(sg));
		System.out.printf("sn.equlas(ss):%b\n",st.equals(ss));
		
		//toString() : 메모리에 저장된 문자열 리턴
		System.out.println(sn.toString());
		System.out.println(sn);
		
	}// end main()

}// end class
