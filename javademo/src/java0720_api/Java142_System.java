package java0720_api;

public class Java142_System {

	public static void main(String[] args) {
		int[] arr1 = { 1, 5, 2, 4 };
		int[] arr2 = { 6, 3, 9, 7, 8 };
		int[] arr3 = process(arr1, arr2);
		for (int data : arr3)
			System.out.printf("%3d", data);

	}// end main()

	public static int[] process(int[] arr1, int[] arr2) {
		int[] arr3 = new int[arr1.length + arr2.length];
		/*for (int i = 0; i < arr1.length; i++) {
			arr3[i] = arr1[i];
		}
		for (int j = 0; j < arr2.length; j++) {
			arr3[arr1.length + j] = arr2[j];
		}*/
		
		//src.srcPos,dest,desPos,length
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);   //arr1의 0 인덱스의값을 arr3의 0 인덱스부터 arr1배열만큼 넣는다.
		System.arraycopy(arr2, 0, arr3, arr1.length,arr2.length); //arr2의 0인덱스의값을 arr3의 arr1배열의크기부터 arr2배열만큼 넣는다.
		

		return arr3;

	}

}// end class
