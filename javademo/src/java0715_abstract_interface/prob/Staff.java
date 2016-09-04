package java0715_abstract_interface.prob;

public class Staff extends Person {

	public Staff(String name, String jumin) {
		super(name, jumin);
	}

	@Override
	public char gender() {
		// 주민번호를 이용해서 성별을 구한후 반환하는 로직을 구현하세요.
		if (getJumin().charAt(6) == '1' || getJumin().charAt(6) == '3') {
			return '남';
		} else {
			return '여';
		}

	}

	@Override
	public int getYear() {
		// 주민번호를 이용한 년도4자리를 구한후 반환하는 로직을 구현하세요.
		if (getJumin().charAt(6) == '1' || getJumin().charAt(6) == '2') {
			return 1900 + Integer.parseInt(getJumin().substring(0, 2));
		} else {
			return 2000 + Integer.parseInt(getJumin().substring(0, 2));
		}

	}

	@Override
	public int getMonth() {
		int num = Integer.parseInt(getJumin().substring(2, 4));
		return num;
	}

	@Override
	public int getDATE() {
		int num = Integer.parseInt(getJumin().substring(4, 6));
		return num;
	}

}// end Staff
