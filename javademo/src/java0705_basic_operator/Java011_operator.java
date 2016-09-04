package java0705_basic_operator;

public class Java011_operator {

	public static void main(String[] args) {
		int x=5;
		int y=3;
		int z=5;
		
		System.out.println(true && true);  //and(둘다 true 여만 true)
		System.out.println(false || true); // or(둘중 하나만 true 여도 true)
		System.out.println(!true); //not (반대)
		//true && true
		System.out.println(x>y && x==z);
		//false || true
		System.out.println(x<=y || x>y);
		//false && true
		System.out.println(x<y && x==z);
		
		
	}//end main()

}//end class
