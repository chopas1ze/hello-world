package java0715_abstract_interface;

class ExamA {

}

class ExamB extends ExamA {

}

class ExamC extends ExamB {

}

class ExamD extends ExamC {

}

public class Java111_binding {

	public static void main(String[] args) {
		ExamB bb = new ExamB();
		System.out.println(bb instanceof ExamA); // true

		ExamA aa = new ExamA();
		System.out.println(aa instanceof ExamB); // false
		
	} // end main()

}// end class
