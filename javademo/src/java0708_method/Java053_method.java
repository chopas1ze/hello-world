package java0708_method;


//call By Reference 참조데이터 타입의 값을 넘겨주면 주소가 복사된다.
public class Java053_method {

	public static void main(String[] args) {
		int[] arr=new int[]{2,5};
		callByReference(arr);
		System.out.printf("arr[0]=%d, arr[1]=%d\n",arr[0],arr[1]);
	}//end main()
	
	public static void callByReference(int[] data){
		int temp;
		temp=data[0];
		data[0]=data[1];
		data[1]=temp;
		System.out.printf("data[0]=%d, data[1]=%d\n",data[0],data[1]);
	}//end callByReference()
}//end class()

