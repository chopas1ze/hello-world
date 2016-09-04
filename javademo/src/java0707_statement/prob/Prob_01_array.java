package java0707_statement.prob;
/*
 * 4행 4열 data배열에 가로 세로 합계를 구하는 프로그램을 구현하시오.
 * [출력결과]
 *  1   2   3   6
 *  4   5   6  15
 *  7   8   9  24
 * 12  15  18  45
 */

public class Prob_01_array {

	public static void main(String[] args) {
		int[][] data = new int[4][4];
		int cnt = 1;
		int sum = 0;
		// 여기를 구현하시오.
		for (int row = 0; row < data.length-1; row++) {
			sum = 0;
			for (int col = 0; col < data[row].length-1; col++) {
				data[row][col] = cnt;
				cnt += 1;
				sum += data[row][col];

				System.out.printf("%d\t", data[row][col]);
			}
			data[row][data[row].length - 1] = sum;
			System.out.printf("%d\t", sum);
			System.out.println();
		}
		sum = 0;
		for (int col = 0; col < data.length; col++) {
			sum = 0;
			for (int row = 0; row < data[row].length-1; row++) {
				sum += data[row][col];
			}
			data[data.length-1][col]=sum;
			System.out.printf("%d\t", sum);
		}
	}// end main()

}// end class
