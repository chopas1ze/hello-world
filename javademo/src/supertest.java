
public class supertest {

	public static void main(String[] args) {
		child c = new child();
		c.method();
	}//end main()

}//end class

class Parent{
	int x = 10;
	public Parent() {
			System.out.println("50");
	}
	
}//end Parent

class child extends Parent {
	public child() {
	}
	int x= 20;
	void method(){
		System.out.println("x="+x);
		System.out.println("this.x="+this.x);
		System.out.println("super.x="+super.x);
	}
}