package java0804_jdbc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class InputWin extends Frame implements ActionListener {
	TextField inputTxt;
	Button runBtn;
	TextArea multiArea;

	public InputWin() {
		runBtn = new Button("RUN");
		inputTxt = new TextField(30); //입력받는 글자수
		multiArea = new TextArea();  //아무런 text도 없는 빈 TextArea를 생성한다.
		Panel p = new Panel(); //여러개의 컴퍼넌트를 그룹화시킴.  //FlowLayout(왼쪽->오른쪽)
		p.add(inputTxt);
		p.add(runBtn);
		
		this.add(p, BorderLayout.NORTH);
		this.add(multiArea, BorderLayout.CENTER);
		
		runBtn.addActionListener(this);
		inputTxt.addActionListener(this);
		
		
		setSize(500, 400);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}// end InputWin()

	@Override
	public void actionPerformed(ActionEvent event) {
		String mess = inputTxt.getText();
		//TextField에서 입력한 데이터를 TextArea에 추가
		multiArea.append(mess+"\n");
		//TextField를 초기화한다.
		inputTxt.setText("");
		//TextField로 포커스를 이동
		inputTxt.requestFocus();
		
	}//end actionPerformed()

}// end class

public class Java203_gui {

	public static void main(String[] args) {
		new InputWin();

	}// end main()

}// end class
