package java0722_stream_collection.prob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * [문제]
 *  jumsu.txt 파일로부터 학생의 점수를 읽어들여 총점과 평균을 jumsu.txt 파일 끝에 덧붙여 출력하는 프로그램을 작성하시오.
    단, 평균점수는 소수점 첫 번째 자리까지만 남기고 나머지는 잘라낸다.(truncate) 
    
    [프로그램 실행결과]
    태연:65
	수영:97
	제시카:100
	티파니:86
	써니:88
	총점:436
	평균:87.2
 */
public class Prob02_stream {
	public static void main(String[] args) {
		// 프로그램을 구현하시오.
		File fr = new File(".\\src\\java0722_stream_collection\\prob\\jumsu.txt");
		Scanner sc = null;
		FileWriter fw = null;
		int sum = 0;
		int cnt = 0;
		float avg = 0;

		try {
			sc = new Scanner(fr);
			fw = new FileWriter(fr,true);
			while (sc.hasNextLine()) {
				cnt++;
				String a = sc.nextLine();
				String[] arr = a.split(":");
				for (int i = 0; i < arr.length; i++) {
					if (i == 0) {
						continue;
					}
					if (i == 1) {
						sum += Integer.parseInt(arr[arr.length - 1]);
					}
				}

			}
			avg = (float) sum / cnt;
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fw.write("총점:"+sum+"\r\n");
			fw.flush(); 
			fw.write("평균:"+avg);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}// end main()
}// end class
