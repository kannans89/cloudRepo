package tictactoe.UI;

import com.techlabs.tictactoe.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class JFrameConsole {
	ButtonClickListener listener = new ButtonClickListener();
	JButton[] button=new JButton[9];
	JPanel panel;
	JFrame frame;
	JButton reset=new JButton("RESET");
	public static JLabel playername;
	public static JLabel status;
	public static int no;
	int cellno;
	ResultAnalyzer analyzer;
	Board board;
	Game g;
	static Player[] player=new Player[2];
	public JFrameConsole(String name1, String name2) {
		player[0]=new Player(1,name1);
		player[1]=new Player(2,name2);
		board=new Board();
		analyzer=new ResultAnalyzer(board);
		
		for(int i=0;i<9;i++){
			button[i]=new JButton(""+i);
			button[i].addActionListener(listener);   
			button[i].addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0) {
				new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override
					public void run() {
						checkResult();
					}
				}, 
				100 
				);
				}
			});
		}
	}
	public void run() {
		frame = new JFrame("TIC-TAC-TOE");
	    panel = new JPanel();
	    playername=new JLabel(player[0].name);
	    status=new JLabel("Start");
	    status.setForeground(Color.GREEN);
	    panel.setLayout(new FlowLayout());
	    
	    
		g=new Game(player, analyzer, board);
	    
	    for(int i=0;i<9;i++){
	    	panel.add(button[i]);
	    }
	    
	    panel.add(playername);
	    panel.add(status);
	    frame.add(panel);
	    frame.setSize(160, 230);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	
	private void checkResult() {
			System.out.println(no);
			g.play(no);
			analyzer.checkResult();
			State res=analyzer.getResult();
			if(res==State.INPROGRESS){
				System.out.println("inprogress");
			}
			else if(res==State.WIN){
				System.out.println(player[analyzer.getWinner()-1].name+" wins");
				playername.setText(player[analyzer.getWinner()-1].name+" wins");
				status.setForeground(Color.red);
				status.setText("<html><center>GAME OVER<center></html>");
				for(int i=0;i<9;i++){
					button[i].setEnabled(false);
				}
				
				
			}
			else if(res==State.DRAW){
				System.out.println("draw");
				playername.setText("");
				status.setText("draw");
			}
			System.out.println();
	}
}
