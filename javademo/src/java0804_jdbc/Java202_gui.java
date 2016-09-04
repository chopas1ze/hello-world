package java0804_jdbc;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WinUser extends Frame {
	public WinUser() {
		setSize(300, 400);
		setVisible(true);
		//this.addWindowListener(new UserAdapter());
		this.addWindowListener(new WindowAdapter(){
		@Override
		public void windowClosing(WindowEvent e) {
		System.exit(0);
		}
		});
		
	}// end WinUser()

	class UserAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}//end UserAdapter

}// end WinUser

public class Java202_gui {

	public static void main(String[] args) {
		WinUser user = new WinUser();

	}// end main()

}// end class
