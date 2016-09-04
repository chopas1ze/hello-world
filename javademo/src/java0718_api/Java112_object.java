package java0718_api;

/*
 * JAVA API(Application Programming Interface)
 * Object
 * 1 클래스 중에서 최상의 클래스이다.
 * 2 Object을 제외한 모든 클래스들은 Object을 상속받고 있다.
 * 3 java.lang패키지(자주 사용하는 클래스를 모아둠)에서 제공하는 클래스이다.
 */
public class Java112_object {

	public static void main(String[] args) {
		Object obj = new Object();
		// java.lang.Object@15db9742 객체타입값과 해쉬코드 리턴
		System.out.println(obj.toString());

		int x = 5;
		
		int y = 5;

		//Object 가 포함하고 있는 클래스 
		
		//==값비교(기본데이터)
		System.out.printf("x=%d y=%d x==y;%b\n",x,y,x==y);
		
		Object ojt = new Object();
		//==주소비교(참조데이터)
		System.out.printf("obj==ojt;%b\n",obj==ojt);
		
		//equals 주소비교=객체비교에만 사용 한다.
		System.out.printf("obj.equals(ojt)=%b\n",obj.equals(ojt));
		
		//class java.lang.Object
		System.out.println(obj.getClass());

		//java.lang.Object
		System.out.println(obj.getClass().getName());
		
		//java.lang.Object@15db9742
		System.out.println(obj);                    // 주소를 가져온다
		System.out.println(obj.toString()); 	    // 주소를 가져온다
		
	}// end main()

}// end class
