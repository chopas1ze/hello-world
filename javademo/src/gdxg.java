
public class gdxg {
	long a, b;

	long add() {
		return a + b;
	}

	
	static long add(long a, long b){
		return a+b;
	}
	
int iv = 10;
static int cv =20;
int iv2 = cv;
//static int cv2 = iv;
static int  cv2=new gdxg().iv;
	
void ap(){
		System.out.println(iv);
		System.out.println(cv);
	}

	void ap(int a) {
	
}
	
static void ap1(){
	
}
	
	public static void main(String[] args) {
		 b bb = new b();
bb.a=5;
		
	System.out.println(gdxg.add(100, 200));
	gdxg a = new gdxg();
	System.out.println(a.add());
		System.out.println(a.iv2);
		a.ap();

}// end main()

}// end class

class b extends gdxg {

    
}
