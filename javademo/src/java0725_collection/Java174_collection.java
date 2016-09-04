package java0725_collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/*
 * [프로그램 출력결과]
 * kim 56 78 12   ??
   hong 46 100 97 ??
   park 96 56 88  ??
 */

class Sawon {
	String name;
	int one;
	int two;
	int three;

	public Sawon(String name, int one, int two, int three) {
		super();
		this.name = name;
		this.one = one;
		this.two = two;
		this.three = three;
	}

	private int count() {
		return one + two + three;
	}

	public String toString() {
		return name + " " + one + " " + two + " " + three + " " + count();
	}

}// end Sawon

public class Java174_collection {

	private static int Vector;
	private static int Sawon;

	public static void main(String[] args) {
	String sn = "./src/java0725_collection/score.txt";
	Vector<Sawon> vt = lines(sn);
	prnDisplay(vt);
/*		File file = new File("./src/java0725_collection/score.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split("[:/]");
				Sawon sn = new Sawon(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
						Integer.parseInt(line[3]));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

		}
*/
	}// end main()

	private static Vector<Sawon> lines(String strName){
		//strName매개변수의 값을 이용해서 Vector에 데이터를 저장한 후
		//리턴하는 프로그램을 구현하시오.
		File file = new File(strName);
		Scanner sc = null;
		Vector<Sawon> vs = null;
		
			try {
				sc = new Scanner(file);
				vs = new Vector<Sawon>();
				while (sc.hasNextLine()) {
					String[] line = sc.nextLine().split("[:/]");
					vs.add(new Sawon(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
							Integer.parseInt(line[3])));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally{
				sc.close();
			}
		
	
		return vs;
	}//end lines()
	
	private static void prnDisplay(Vector<Sawon> vt){
		//vt에 저장된 객체들을 출력하는 프로그램을 구현하세요.
		
		for(Sawon sw : vt){
			System.out.println(sw.toString());
		}
		for(int i = 0;i<vt.size();i++){
			System.out.println(vt.get(i));
		}
			
	}//end prnDisplay()
}// end class
