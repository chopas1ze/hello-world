package java0714_inheritance.prob;
/* 
 * Soccer클래스를 상속받아 AllSoccer클래스를 구현하세요.
 * Soccer클래스에서 display( )메소드를 오버라이딩해서
 * 아래와 같이 구현하세요.
 * [출력결과]
 * 이름 :메멍멍
 * 시즌득점: 50 자책골 : 10
 * 시즌경기력  :40 
 * 플레이평점 : ☆☆☆☆
* ***********************************
* 이름 :호멍멍
* 시즌득점 : 65, 자책골 : 0, 퇴장 : 5, 경고 : 4, 친화력 : 20 포지션: fw 
* 시즌경기력 : 65
* 플레이평점: ☆☆☆☆☆
 * 
 * 
 */

class Soccer {
	String name;
	int goal;
	int silgoal;

	public Soccer(String name, int goal, int silgoal) {
		this.name = name;
		this.goal = goal;
		this.silgoal = silgoal;
	}

	void display() {

		int total = goal - silgoal;
		String result = "";
		System.out.printf("이름:%s\n", name);
		System.out.printf("시즌득점 : %d, 자책골 : %d\n", goal, silgoal);
		System.out.printf("시즌경기력 :%d\n", total);
		if (total >= 50)
			result = "☆☆☆☆☆";
		else if (total >= 35)
			result = "☆☆☆☆";
		else if (total >= 20)
			result = "☆☆☆";
		else
			result = "☆☆";
		System.out.println("플레이평점: " + result);
	}

}

class AllSoccer extends Soccer {
	private int err;
	private int war;
	private int friend;
	private String posi;

	public AllSoccer(String name, int goal, int silgoal, int err, int war, int friend, String posi) {
		super(name, goal, silgoal);
		this.err = err;
		this.war = war;
		this.friend = friend;
		this.posi = posi;
	}

	@Override
	void display() {
		// 여기를 구현하세요.
		int total = goal - silgoal - err - war + friend;
		String result = "";
		System.out.printf("이름:%s\n", name);
		System.out.printf("시즌득점:%d, 자책골:%d, 퇴장:%d, 경고:%d, 친화력:%d, 포지션:%s\n", goal, silgoal, err, war, friend, posi);
		System.out.printf("시즌경기력 :%d\n", total);
		if (total >= 50)
			result = "☆☆☆☆☆";
		else if (total >= 35)
			result = "☆☆☆☆";
		else if (total >= 20)
			result = "☆☆☆";
		else
			result = "☆☆";
		System.out.println("플레이평점 : " + result);
	}
}

public class Prob05_inheritance {
	
	public static void main(String[] args) {
		Soccer so = new Soccer("김멍멍", 50, 10);
		so.display();

		System.out.println("***********************************");

		
		AllSoccer ac = new AllSoccer("호멍멍", 60, 0, 5, 4, 20, "fw");
		ac.display();
	}

}
