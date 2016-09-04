package java0721_exception_stream.prob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * [문제]score.txt 파일의 점수 정보를 읽어 들여서 각 학생의 점수 총합을 
 *       콘솔창에 출력하는 입출력 프로그램을 main() 메서드에 구현하시오.
 * 
 * [프로그램 실행결과]
 * kim의 점수 통합 :146
 * hong의 점수 통합 :243
 * park의 점수 통합 :240
 */
public class Prob001_stream {

	public static void main(String[] args) {
		// 각 학생의 총점을 출력하는 프로그램을 구현하시오.
		File file = new File("./src/java0721_exception_stream/prob/score.txt");
		Scanner sc = null;
	/*	String[] arr = new String[3];

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLine();
			}
			for (int i = 0; i < arr.length; i++) {
				StringTokenizer st = new StringTokenizer(arr[i], ":/");
				String a = "";
				int aa = 0;
				int bb = 0;
				int cc = 0;
				int dd = 0;
				while (st.hasMoreTokens()) {
					a = st.nextToken();
					bb = Integer.parseInt(st.nextToken());
					cc = Integer.parseInt(st.nextToken());
					dd = Integer.parseInt(st.nextToken());
				}
				System.out.printf("%s의 점수 통합 : %d\n", a, bb + cc + dd);
			}
		}
*/
		
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(sc.hasNextLine()){
			StringTokenizer st = new StringTokenizer(sc.nextLine(), ":/");
			System.out.printf("%s의 점수 통합 : %d\n",st.nextToken(),Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
		}
	}// end main()

}// end class
