package java0715_abstract_interface;

public class Java108_binding {

	public static void main(String[] args) {

		Object obj = new Object();
		System.out.println(obj.toString());

		String stn = new String("java");
		System.out.println(stn.toString());

		obj = stn;
		// 오버라이딩 되어있는지 확인해서 있으면 오버라이딩 된 메소드 실행.
		System.out.println(obj.toString());

	} // end main()

}// end class
