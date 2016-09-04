package java0707_statement.prob;

/*
1+1+2+1+2+3+1+2+3+4+1+2+3+4+5=??

출력결과
sum=35
*/
public class Prob_03 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;

		for (int b = 1; b <= 5; b++) {
			i = 0;
			for (int c = 1; c <= 5; c++) {
				if (b >= c) {
					i = i + 1;
					sum = sum + i;
				}
			}
		}
		System.out.printf("sum=%d",sum);
	}// end main()

}// end class

// int sum=0;
// for(int i=1;1<=5;1++){
// for(int j=1;j<=i;j++){
// sum+=j;

