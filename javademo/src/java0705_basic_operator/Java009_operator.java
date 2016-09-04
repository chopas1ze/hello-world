package java0705_basic_operator;

public class Java009_operator {

	public static void main(String[] args) {
		int x=3;
		x++; //+1 증가시키고 저장
		System.out.println(x);
		++x;
		System.out.println(x);
		
		int y=4;
		int z=2;
		
		//변수앞에++가 있으면 변수의 값을 먼저 증가시키고 +연산이 수행된다.
		int res = ++y + z; // ++y : 전위연산(1+y+z)  
		System.out.println(res);

		//변수뒤에 ++가 있으면 +을 먼저 수행하고 변수값을 증가한다
		res=y++ + z;  // 후위연산(우선순위가 뒤로밀림 y+z+1)
		System.out.println(res); 
		
	}//end main()

}//end class

// ctrl + '+ or -' 폰트크기 조절