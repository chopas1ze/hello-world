package java0706_statement;

/*
 * [출력결과]
 * station = "KBS" channel= 7 => 닥터포스터
 * station = "KBS" channel= 9 => 국수의 신
 * station = "MBC" => 몬스터
 * station = "EBS" => 한국기행
 */

public class Java023_if {

	public static void main(String[] args) {
		int channel = 7;  //1  
		String station = "MBC";  //2
		if (station == "KBS") {  //3
			if (channel == 7) {  //4
				System.out.println("닥터포스터"); //5 
			} else if (channel == 9) {
				System.out.println("국수의신");
			}
		} else if (station == "MBC") {
			System.out.println("몬스터");
		} else if (station == "EBS") {
			System.out.println("한국기행");
		}

	}// end main()  //6

}// end class
