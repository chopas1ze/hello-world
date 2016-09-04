package java0705_basic_operator.prob;

/*
 * 동전교환프로그램
 * 1 가장적은 동전으로 교환할 수 있는 프로그램작성하시오
 * 2 [출력결과]
 *   500원: 15개
     100원: 2개
     50원: 1개
     10원: 2개
     1원: 7개
 */

public class Prob0705_05 {

	public static void main(String[] args) {
		int money = 7777;
		int mok=money/500;
		
		//여기에 작성하시오
		//    7777-15*500 / 100 = 277 / 10 = 2
		int mok2=(money-mok*500)/100;
		int mok3=((money-mok*500)-(mok2*100))/50;
		int mok4=((money-mok*500)-(mok2*100)-(mok3*50))/10;
		int mok5=((money-mok*500)-(mok2*100)-(mok3*50)-(mok4*10))/1;
		
		System.out.printf("500원: %d개\n100원: %d개\n50원: %d개\n10원: %d개\n1원: %d개\n", mok, mok2, mok3, mok4, mok5);
		
	}//end main()

}//end class
/*
system.out.printf("500원:%d개\n",mok);
money=money&500;  // money %= 500;
mok=money/100;

system.out.printf("100원:%d개\n", mok);

money = money % 100;
mok = money /50;
system.out.printf("50원:%d개\n", mok);

money = money % 50;
mok = money /10;
system.out.printf("10원:%d개\n", mok);

money = money % 10;
system.out.printf("1원:%d개\n", money);
*/




