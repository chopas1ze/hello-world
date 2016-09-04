package java0721_exception_stream.prob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*[문제]
 * data.txt 파일에는 PRODUCT 테이블의 컬럼 이름들이 저장되어있다. 
 * 이 컬럼 이름들을 Java 의 변수명으로 변환하여 콘솔창에 출력하는
 *  makeVariable() 메소드를 구현하시오. 
 * Java 의 변수명은 camel case 가 적용된 형태로 변환해야 한다
 * 
 * [실행결과]
 * prodNo
 * prodName
 * price
 * amount
 * maker
 * regDate
 */

public class Prob002_stream {
	public static void main(String[] args) {
		String fileName = ".\\src\\java0721_exception_stream\\prob\\data.txt";
		makeVariable(fileName);
	}// end main()

	private static void makeVariable(String fileName) {
		// 구현하세요.
		File file = new File(fileName);
		Scanner sc = null;
		//String[] arr = new String[6];

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (sc.hasNextLine()) {
			String a =sc.nextLine().toLowerCase();
			String b ="";
			if(a.matches(".*[_].*")==true){
				String[] ho = a.split("_");
				for(int i = 0;i<ho.length-1;i++){
					b += ho[i]+(char)(ho[ho.length-1].charAt(0)-32)+ho[ho.length-1].substring(1);
				}
			
				System.out.println(b);
			}else{
				System.out.println(a);
			}
			
			
			
/*			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLine().toLowerCase();
				String a = "";
				String[] ad = arr[i].split("_");
				switch (ad.length) {
				case 1:
					a += ad[ad.length - 1];
					break;
				case 2:
					a += ad[ad.length - 2] + ((char) (ad[ad.length - 1].charAt(0) - 32))
							+ ad[ad.length - 1].substring(1);
					break;
				}
				System.out.println(a);
			}          
			*/

		}
	}// end makeVariable()
}// end class


	// sc.nextLine().toLowerCase();
/*
 * if (sc.nextLine().matches(".*[_].*")) { String[] arr =
 * sc.nextLine().split("_"); for(int i = 0;i<arr.length;i++){ String buff =
 * arr[i]; } System.out.println(sc.nextLine()); }
 */

// sc.nextLine().charAt(sc.nextLine().indexOf("_") + 1)

// sc.nextLine().charAt(index).toUpperCase();

// System.out.println(sc.nextLine());
