package java0721_exception_stream;

public class Java147_exception {

	public static void main(String[] args) {
		int[] arr = new int[3];
		try {
			arr[4] = 10; // 문법적으로는 이상이 없다.
			System.out.println(arr[4]); // Exception in thread~~~~
		} catch (ArrayIndexOutOfBoundsException ex) { // 예외값을 받을수 있는 매개변수 선언
			// 예외 정보
			System.out.println(ex.getMessage()); // 현재발생한 예외 정보 //4
			// java.lang.ArrayIndexOutOfBoundsException: 4
			System.out.println(ex.toString());

			// java.lang.ArrayIndexOutOfBoundsException: 4
			// at
			// java147_exception_stream.Java147_exception.main(Java147_exception.java:8)
			ex.printStackTrace();  //예외 경로를 추적
			
		} finally { // 파이널에 꼭 내용이 있을 필요는 없다.
			System.out.println("program end");

		}

	}// end main()

}// end class
