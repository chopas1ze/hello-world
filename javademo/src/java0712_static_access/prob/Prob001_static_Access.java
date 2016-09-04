package java0712_static_access.prob;

/* main( )메소드를 아래 출력결과를 참조하여 구현하시오.
 * 
 *  [출력결과]
 * 고양이가 움직입니다.
 * 강아지는 8개월입니다.
 * 고양이는 13개월입니다.
 * 현재 우리집 애완동물 수는 2마리입니다.
 */

class Pet {
	private String type; // 애완동물 종류
	private int age; // 애완동물 개월수
	static int count = 0; // 애완동물 수

	public Pet() {

	}

	Pet(String type, int age) {
		this.type = type;
		this.age = age;
	}

	static int getCount() {
		return count;
	}

	public void move() {
		System.out.println(this.type + "가 움직입니다.");
	}

	public String getType() {
		return this.type;
	}

	public int getAge() {
		return this.age;
	}
}

public class Prob001_static_Access {

	public static void main(String[] args) {

		Pet aa = new Pet("고양이", 0);
		aa.move();

		Pet bb = new Pet("강아지", 8);
		System.out.printf("%s는 %d개월입니다.\n", bb.getType(), bb.getAge());
		Pet.count++;
		
		Pet cc = new Pet("고양이", 13);
		System.out.printf("%s는 %d개월입니다.\n", cc.getType(), cc.getAge());
		Pet.count++;
		
		System.out.printf("현재 우리집 애완동물 수는 %d마리입니다.",Pet.count);
		
	}// end main()
}// end class
