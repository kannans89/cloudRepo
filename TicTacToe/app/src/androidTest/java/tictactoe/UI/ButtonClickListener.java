package tictactoe.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonClickListener implements ActionListener {
	int currentPlayer=0;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		currentPlayer++;
		JButton button=(JButton) arg0.getSource();
		JFrameConsole.no=Integer.parseInt(button.getText());
		if(currentPlayer%2==0){
			button.setText("0");
		}
		else{
			button.setText("X");
		}
		button.setEnabled(false);
	
		JFrameConsole.playername.setText(JFrameConsole.player[(currentPlayer%2)].name);
		JFrameConsole.status.setText("Inprogress");
	}

}
