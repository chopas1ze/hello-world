package java0721_exception_stream;

import java.util.Scanner;

public class Java158_stream {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String name="";
		int x = 0;
		int y = 0;
		double key=0.0;
		//한줄에 한칸뛰고 입력시 y값도 같이 읽지만 x,y로 하면 중간,때문에 int값으로 못 읽어서 에러.
		System.out.printf("데이터 입력 name x y key:");  
		name=sc.next();       //nextLine하면 한라인 전부를 읽어서 안됨.
		x = sc.nextInt(); 
		y = sc.nextInt();
		key = sc.nextDouble();
		
		System.out.printf("%s %d %d %.1f\n",name,x,y,key);
		
		sc.close();

	}// end main()

}// end class
