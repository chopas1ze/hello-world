package java0713_class;

class MomberDAT{
	private static MomberDAT DAT = new MomberDAT();
	private MomberDAT(){
	}
	public static MomberDAT getInstance(){
		return DAT;
	}
	
	private int b = 5;
	
	void prn(){
		System.out.println("ttt");
	}
	public  int getB(){
		return b;
	}
	public void setB(int b, String abc){
		if(abc.equals("1234")){
			this.b=b;	
		}
			}
	}

public class Testtest {

	public static void main(String[] args) {
		MomberDAT ff = MomberDAT.getInstance();
		ff.prn();
		
		ff.setB(6, "1234");
		System.out.println(ff.getB());
	}

}
