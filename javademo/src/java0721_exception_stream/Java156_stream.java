package java0721_exception_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Java156_stream {

	public static void main(String[] args) {
		// 바이트스트림
		InputStream is = System.in; // 콘솔은 1바이트씩 처리되어 InputStream 으로 함.

		// 바이트 스트림과 문자 스트림 연결
		InputStreamReader ir = new InputStreamReader(is);

		// 문자스트림
		BufferedReader br = new BufferedReader(ir);

		int x = 0;
		int y = 0;

		try {
			// String line="";
			// line=br.readLine(); //입출력 부문에서 에러뜨면 throws 의심을 해야함.
			// System.out.println(line);
			System.out.print("x:");
			x = Integer.parseInt(br.readLine());
			System.out.printf("y:");
			y = Integer.parseInt(br.readLine());
			System.out.printf("x+y=%d\n", x + y);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}// end main()

}// end class
