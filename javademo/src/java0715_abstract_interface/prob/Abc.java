package java0715_abstract_interface.prob;

/*
 * String sn=new String("java");

//문자 하나씩 가지고 올때
//배열 생각 sn[index]
char data=sn.charAt(2); //v
System.out.println(data)

// 문자 어디부터 ~ 어디까지 가지고 올때 사용  뒤의 숫자는 미만을 의미한다.
String ko=sn.substring(0,3); //jav
String mm=sn.substring(1,2); //a

// 스트링 값을 숫자로 변환 해준다.
String ss=new String("2124");
int num=Integer.parseInt(ss.substring(1,3)); 

 */

class A{
	public String x(){return "A.X";}
	public String z(){return "z";}
	int b = 5;
}
class B extends A{
	public String x(){return "B.X";}
	public String y(){return "y";}
	
}
public class Abc {

	public static void main(String[] args) {
		A obj = new B();
		System.out.println(obj.z());
		System.out.println(obj.b);
		
		String sn = new String("java");
		
		char data = sn.charAt(1);
		System.out.println(data);
		
		String ko=sn.substring(0,2);
		System.out.println(ko);
		String to=sn.substring(1, 2);
		System.out.println(to);
		
		String ss = new String("2152");
		int num=Integer.parseInt(ss.substring(0,1));
		System.out.println(num);
	}
	

}


