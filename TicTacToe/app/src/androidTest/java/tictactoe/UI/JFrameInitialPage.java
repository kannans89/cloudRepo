package tictactoe.UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.techlabs.frame.practise4.SecondFrame;

public class JFrameInitialPage {
	JTextField name1;
	JTextField name2;
	JButton start;
	JLabel labelName1;
	JLabel labelName2;
	
	public JFrameInitialPage() {
		name1=new JTextField();
		name2=new JTextField();
		name1.setPreferredSize( new Dimension( 100, 20 ) );
		name2.setPreferredSize( new Dimension( 100, 20 ) );
		labelName1=new JLabel("Payer 1 name: ");
		labelName2=new JLabel("Payer 2 name: ");
		start=new JButton("START");
	}
	
	public void run() {
		JFrame frame = new JFrame("TIC-TAC-TOE");
	    JPanel panel = new JPanel();
	    panel.setLayout(new FlowLayout());
	    
	    start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				JFrameConsole frame2=new JFrameConsole(name1.getText(),name2.getText());
				frame2.run();
			}
		});
	    
	    panel.add(labelName1);
	    panel.add(name1);
	    panel.add(labelName2);
	    panel.add(name2);
	    panel.add(start);
	    frame.add(panel);
	    frame.setSize(280, 230);
//	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}

}
