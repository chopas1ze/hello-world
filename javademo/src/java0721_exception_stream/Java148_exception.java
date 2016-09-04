package java0721_exception_stream;

public class Java148_exception {

	public static void main(String[] args) {
		StringBuffer sb = null;
		try {  //try영역에서 빠져나오면 그후론 다시 트라이로 가지 않는다.
			sb.reverse();
			System.out.println(sb);
		} catch (NullPointerException ex) {
			sb = new StringBuffer("java");
			System.out.println(sb.reverse());

		} finally {
			System.out.println("program end");
		}

	}// end main()

}// end class
