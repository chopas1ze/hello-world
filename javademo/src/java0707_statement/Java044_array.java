package java0707_statement;

public class Java044_array {

	public static void main(String[] args) {
		int[][] num = new int[3][2]; // 2차원 배열 int[행][열]
		num[0][0] = 1;
		num[0][1] = 2;
		num[1][0] = 3;
		num[1][1] = 4;
		num[2][0] = 5;
		num[2][1] = 6;

		/*
		 * System.out.printf("%d\t", num[0][0]); System.out.printf("%d\n",
		 * num[0][1]); System.out.printf("%d\t", num[1][0]);
		 * System.out.printf("%d\n", num[1][1]); System.out.printf("%d\t",
		 * num[2][0]); System.out.printf("%d\n", num[2][1]);
		 */
		
		//num.length : 행의 크기를 리턴한다.
		for (int row = 0; row < num.length; row++) {
			//num[row].length : row행에 해당하는 열의 크기를 리턴한다.
			for (int col = 0; col < num[row].length; col++) {
				System.out.printf("%d\t", num[row][col]);

			}
			System.out.println();
		}
		for(int col=0;col<2;col++){
			for(int row=0; row<3; row++){
				System.out.printf("%d\t",num[row][col]);
				
			}
			System.out.println();
		}
		
		
		
	}// end main()

}// end class
