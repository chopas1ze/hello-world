package java0721_exception_stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class Java160_stream {

	public static void main(String[] args) {
		File file = new File("sample.txt");
		FileReader fr = null; 
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			try {
				while ((line = br.readLine()) != null) {
					System.out.println(line);// br.readLine()으로 넣으면 읽어오고 엔터 읽어오고
												// 엔터되면서 매번 다음줄꺼를 읽어온다.
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		System.out.println("/////////////////////////////////////////");
		Scanner sc = null;
		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}// end main()

}// end class
