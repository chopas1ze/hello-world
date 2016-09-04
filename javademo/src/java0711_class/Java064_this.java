package java0711_class;

/* 
 * this: 객체 자신을 의미한다. 힙영역에 객체가 생성된 다음에 사용할수  있다.
 * this.맴버변수
 * this.메소드()
 * this()
 */

class CustomerList {
	String name;
	char gen;
	String addr;

	public CustomerList() { // 2
		this("홍길동", '남', "충청남도"); // 3
	} // 9

	public CustomerList(String name, char gen, String addr) { // 4
		// 멤버변수와 매개변수가 다를때는 맴버변수에 this키워드를 사용하지 않아도 된다.
		// name=n;

		// 멤버변수와 매개변수가 같을때는 멤버변수에 this키워드를 사용한다.
		this.name = name; // this에 붙는 변수는 멤버변수 //5
		this.gen = gen; // 6
		this.addr = addr; // 7
	} // 8

	public void prn() {
		System.out.printf("%s %c %s\n", name, gen, addr);
	}

	public void call() {
		this.prn();
		// prn(); // this.이 붙어서 알아서 실행됨. 일반적으로 this 안붙이고 사용함.
	}
}// end CustomerList

public class Java064_this {

	public static void main(String[] args) {
/*		CustomerList cm = new CustomerList("이도룡", '남', "서울 종로구 가산동");
		cm.prn();

		CustomerList cs = new CustomerList(); // 1
		cs.prn(); // 10
	*/	// cs.call();
		System.out.println("////////////////////////////////");
		CustomerList[] cc = new CustomerList[2];
		// cc[0]=cm;
		cc[0] = new CustomerList("이도룡", '남', "서울 종로구 가산동");
		cc[1] = new CustomerList();

		for (int i = 0; i < cc.length; i++) {
			cc[i].prn();
		}
		
	}// end main()

}// end class
