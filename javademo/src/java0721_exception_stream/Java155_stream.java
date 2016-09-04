package java0721_exception_stream;

import java.io.IOException;
import java.io.InputStream;

/* ENTER키를 누르면 2가지의 효과(유니코드)
 * carriage return : 줄의 처음으로 이동(13)  기호 \r
 * line feed : 다음 줄로 이동(10)  	    	   기호 \n
 * 
 * 네트워크 쳇팅시스템에서 사용함.
 */

public class Java155_stream {

	public static void main(String[] args) {
		InputStream is = System.in;
		System.out.printf("이름 : ");
		int data;

		try {
			while ((data = is.read()) != 10) {
				System.out.println((char) data);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// end main()

}// end class
