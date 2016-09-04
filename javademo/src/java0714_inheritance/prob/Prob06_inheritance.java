package java0714_inheritance.prob;

/*
 * 아이스크림 총수량 로직을 구현하세요.(수량 - 재고)
 * 아이스크림 할인율 로직을 구현하세요.
 * 할인율 : 총수량이 200개 이상일시 30% 할인
 *       총수량이 100개이상 200미만일시 20% 할인
 *       총수량이 100개미만일시 10% 할인
 * 아이스크림 매출 로직을 구현하세요. (총수량 x 단가 x 할인율 = 매출)
 * IceCream클래스의 prn() 메소드를 IceCreamEX 클래스에 오버라이딩 하여 출력결과와 같이 구현하세요.
 * 
 * [출력결과]
 *   이름             수량           재고             총수량          단가         할인율             매출
	스크류바	 250	 50	      200	 1000	 0.2	 39400	
	설레임	 457	 12	      445	 1500	 0.3	 200250	

 */
class IceCream {
	private String name;
	private int cnt;
	private int jego;

	IceCream(String name, int cnt, int jego) {
		this.name = name;
		this.cnt = cnt;
		this.jego = jego;

	}

	public String getName() {
		return name;
	}

	public int getCnt() {
		return cnt;
	}

	public int getJego() {
		return jego;
	}

	public void prn() {
		System.out.printf("%s\t %d\t %d\t\n", name, cnt, jego);
	}
}// end IceCream class

 class IceCreamEX extends IceCream {
	int danga;
	public IceCreamEX(String name, int cnt, int jego, int danga) {
		super(name, cnt, jego);
		this.danga=danga;
			}

	private int hab() {
		//총수량을 구하시오.
		//return super.getCnt() - super.getJego();
		return -1;
	}

	private double halin() {
		//할인율을 적용하시오.
		/*if (hab() >= 200) {
			return 0.3;0
		} else if (hab() >= 100 && hab() < 200) {
			return 0.2;
		}
		return 0.1;*/
		return 0.1;
	}
	
	private double sum() {
		//매출을 구하시오.
		//return hab()*halin()*danga;
		return 0.1;
	}
	
	//prn()메소드 오버라이딩
	/*public void prn() {
		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f\t %.0f\t\n", super.getName(), super.getCnt(), super.getJego(),hab(),danga,halin(),sum());
	}*/
}// end IceCreamEX class

class Prob06_inheritance {

	public static void main(String[] args) {
		System.out.println("   이름            수량           재고            총수량           단가         할인율             매출");
		IceCreamEX ice = new IceCreamEX("스크류바",250,53,1000);
		ice.prn();
		IceCreamEX ice2 = new IceCreamEX("설레임",457,12,1500);
		ice2.prn();
		
		
		

	} // end main()

}// end class
