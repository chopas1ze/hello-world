package java0707_statement;

public class Java045_array {

	public static void main(String[] args) {
		int[][] num = new int[][]{{1,2},{3,4},{5,6}};
		//num.length : 행의 크기를 리턴한다.
		for (int row = 0; row < num.length; row++) {
			//num[row].length : row행에 해당하는 열의 크기를 리턴한다.
			for (int col = 0; col < num[row].length; col++) {
				System.out.printf("%d\t", num[row][col]);

			}
			System.out.println();
		}
		
	}//end main()

}//end class
