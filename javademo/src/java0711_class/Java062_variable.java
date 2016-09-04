package java0711_class;
/*
 * 클래스에서 정의하는 변수 종류
 * 맴버변수(정의되는 위치=class) : 멤버변수는 초기값을 할당하지 않으면 JVM(자바가상머신)에서 
 *         				        기본값을 할당한다.
 *     	class Test{
 *     int data=10; //맴버변수
 *     void test(){int x=5;  //지역변수}
 *     void sample(int z 매개변수){int y=6;}
 *     }
 *     
 * 지역변수(method) : 지역변수를 JVM(자바가상머신)에서 제공하는 기본값이 없다.
 * 매개변수(method) : 메소드에서 인자값을 받기위한 변수이다.
 */

class MemberVar {
	byte var_byte; //0
	short var_short;  //0
	int var_int;  //0
	long var_long;  //0L   L을 안붙이면 int 데이터타입으로 인식.
	float var_float;  //0.0F
	double var_double; //0.0
	char var_char; //\u0000  공백을 의미
	boolean var_boolean; // false
	int[] data; //null

}

public class Java062_variable {

	public static void main(String[] args) {
		int num;
		// System.out.printf("num=%d\n",num);  //int num; 일때 오류.
		
		MemberVar mv = new MemberVar();
		System.out.printf("var_byte=%d\n",mv.var_byte); //0
		System.out.printf("var_short=%d\n",mv.var_short);  //0
		System.out.printf("var_int=%d\n",mv.var_int);  //0
		System.out.printf("var_long=%d\n",mv.var_long);  //0
		System.out.printf("var_float=%f\n",mv.var_float);  //0.0
		System.out.printf("var_double=%f\n",mv.var_double);  //0.0
		System.out.printf("var_char=%c\n",mv.var_char); // ' '
		System.out.printf("var_boolean=%b\n",mv.var_boolean);  //false
		System.out.printf("var_data=%s\n",mv.data);
		
	}// end main()

}// end class
