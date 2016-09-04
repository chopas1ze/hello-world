package java0721_exception_stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Java159_stream {

	public static void main(String[] args) {
		File file = new File("sample.txt"); // File클래스는 파일안의 내용을 보는건 아니고 파일의
											// 등록정보정도를 확인.
		// System.out.println(file.exists());
		// System.out.println(file.isFile());
		// System.out.println(file.canWrite());
		FileWriter fw = null;
		try {
			/*
			 * FileWriter("대상파일",mode) mode의 값이 true이면 apeend이고, false이면 update이다. 
			 * 생략하면 mode의 값은 false이다.(기본값)
			 */
			fw = new FileWriter(file, true);
			fw.write("java\r\n"); // buffer //파일 대상 없으면 만들어줌. read은 안만듬.
			// \r = 유니코드 13 \n == 유니코드10
			fw.flush(); // buffer의 내용을 대상file에 보내고 buffer를 clear한다.
			fw.write("test");
			// fw.write(97); //write(int c)<- 유니코드값
			// fw.flush();
			System.out.println("저장종료");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close(); // close시 fw.flush()가 실행되고 close됨.

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// end main()

}// end class
