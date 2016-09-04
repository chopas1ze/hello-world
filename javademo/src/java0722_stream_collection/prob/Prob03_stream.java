package java0722_stream_collection.prob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Stream;

/*
 * [문제]
 *  sun.txt파일에서 데이터를 읽어온후 ‘\t’와 ‘ ‘을 ‘-‘ 로 변환하여
 *  프로그램을 구현하시오.
 *   
 * [프로그램 실행결과]
 * hello-world-!!!
 * java-programming
 * jsp-servlet-programming!
 */
public class Prob03_stream {
	public static void main(String args[]) {
		String[] lines = readLines(".\\src\\java0722_stream_collection\\prob\\sun.txt");

		for (int i = 0; i < lines.length; i++) {
			printLine(lines[i]);
		}
	}

	public static String[] readLines(String fileName) {
		/*
		 * 파라미터로 전달받은 txt파일을 읽어 들여, 파일의 줄 수에 해당하는 String[]을 생성하여 해당 String[]에 한
		 * 라인씩 저장해서 반환한다.
		 */
		
		File f = new File(fileName);
		Scanner sc = null;
		String[] arr = null;
		try {
			sc = new Scanner(f);
			arr = new String[3];
			while(sc.hasNextLine()){
				for (int i = 0; i < arr.length; i++) {
					arr[i]=sc.nextLine();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			sc.close();
		}
	
		
		
/*		FileReader fr = null;
		BufferedReader br = null;
		LineNumberReader lr = null;
		String[] arr = null;
		String a = "";		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			lr = new LineNumberReader(fr);
			arr = new String[lr.getLineNumber()];
			while ((a = br.readLine()) != null) {
				for (int i = 0; i < arr.length; i++) {
					arr[i]=a;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
		return arr;
	}// end readLines()

	public static void printLine(String line) {
		/*
		 * 문자열을 받아들여 ‘\t’와 ‘ ‘을 ‘-‘ 로 변환하여 콘솔에 출력한다.
		 */

		System.out.println(line.replaceAll("\\s{1,2}", "-"));

	}// end printLine()
}// end class
