import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Badminton_Score_Tracker extends JFrame {

	int count = 0;
	int count1 = 0;
	int Awon = 0;
	int Bwon = 0;
	String winner = "";
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();

	JButton buttonundoA = new JButton();
	JButton buttonundoB = new JButton();
	JButton buttonreset = new JButton();
	JButton button_new = new JButton();

	JLabel scoreA = new JLabel();
	JLabel scoreB = new JLabel();
	
	JTextField playerA = new JTextField();
	JTextField playerB = new JTextField();
	JLabel labelA = new JLabel();
	JLabel labelB = new JLabel();
	JFrame frame = new JFrame();
	JLabel matchState = new JLabel(); 
	

	private String playerAName;
	private String playerBName;
	private boolean matchStarted;

	void initialize() {
		int topMargin = 100;
		Font labelFont = new Font("Arial", Font.PLAIN, 25);
		Font font = new Font("Arial", Font.PLAIN, 40);
		
		JLabel title = new JLabel(); 
		title.setBounds(200, 20, 300, 40);
		title.setText("Badminton Score Tracker");
		title.setFont(labelFont);
		frame.add(title);

		matchState.setBounds(300, 300, 300, 10);
		matchState.setFont(new Font("Arial", Font.PLAIN, 20));
		matchState.setVisible(false);
		frame.add(matchState);
		
		labelA.setBounds(170, topMargin + 20, 100, 25);
		labelA.setFont(labelFont);
		playerA.setBounds(75, topMargin + 20, 100, 25);
		playerA.setSize(250,30);
		frame.add(labelA);
		frame.add(playerA);
		
		labelB.setBounds(460, topMargin + 20, 100, 25);
		labelB.setFont(labelFont);
		playerB.setBounds(375, topMargin + 20, 100, 25);
		playerB.setSize(250,30);
		frame.add(labelB);
		frame.add(playerB);
		
		
		
		scoreA.setText("0");
		scoreA.setBounds(190, topMargin + 50, 200, 100);
		scoreA.setFont(font);
		frame.add(scoreA);
		
		scoreB.setFont(font);
		scoreB.setText("0");
		scoreB.setBounds(490, topMargin + 50, 200, 100);
		frame.add(scoreB);
		
		
		buttonA.setBackground(Color.PINK);
		buttonA.setBounds(50, topMargin + 200, 300, 200);
		buttonA.setFocusable(false);
		buttonA.setFont(font);
		buttonA.setText("0");
		frame.add(buttonA);
		
		
		buttonB.setBackground(Color.YELLOW);
		buttonB.setBounds(350, topMargin + 200, 300, 200);
		buttonB.setFocusable(false);
		buttonB.setFont(font);
		buttonB.setText("0");
		frame.add(buttonB);

		buttonundoA.setBackground(Color.RED);
		buttonundoA.setBounds(50, topMargin + 430, 300, 50);
		buttonundoA.setFocusable(false);
		buttonundoA.setText("Undo");
		buttonundoA.setEnabled(false);
		frame.add(buttonundoA);



		buttonundoB.setBackground(Color.RED);
		buttonundoB.setBounds(350, topMargin + 430, 300, 50);
		buttonundoB.setFocusable(false);
		buttonundoB.setText("Undo");
		buttonundoB.setEnabled(false);
		frame.add(buttonundoB);


		buttonreset.setBackground(Color.ORANGE);
		buttonreset.setBounds(50, topMargin + 560, 600, 40);
		buttonreset.setFocusable(false);
		buttonreset.setText("Reset");
		frame.add(buttonreset);

		button_new.setBackground(Color.LIGHT_GRAY );
		button_new.setBounds(50, topMargin + 610, 600, 40);
		button_new.setFocusable(false);
		button_new.setText("New Game");
		frame.add(button_new);


		
		buttonA.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{

				if (e.getSource() == buttonA) 
				{
         		count++; // increment the counter by 1
         		buttonA.setText(String.valueOf(count));
         		playerAName = "".equals(playerA.getText()) ? "Player 1" : playerA.getText() ;
				playerBName = "".equals(playerB.getText()) ? "Player 2" : playerB.getText();
				labelA.setText(playerAName);
				labelB.setText(playerBName);
				playerA.setVisible(false);
				playerB.setVisible(false);
				buttonundoA.setEnabled(true);
         		repaint();

	         	if(!matchStarted) 
	         	{
					playerAName = "".equals(playerA.getText()) ? "Player 1" : playerA.getText();
					playerBName = "".equals(playerB.getText()) ? "Player 2" : playerB.getText();
					labelA.setText(playerAName);
					labelB.setText(playerBName);
					playerA.setVisible(false);
					playerB.setVisible(false);
					matchStarted = true;
				}

	         	

				if (count>=20)
				{

					if(count == 21 && count1 < 20)
					{
					Awon++;
					scoreA.setText(""+Awon);

					count = 0;
					count1 = 0;
					buttonundoA.setEnabled(false);
		         	buttonundoB.setEnabled(false);
					buttonA.setText(String.valueOf(count));
				    buttonB.setText(String.valueOf(count1));
					}
					
					
					else if (count>=20 &&  count1>=20)
					 {
					 	
					 	buttonA.setText(String.valueOf(count));
			         	repaint();
					 	int countA= count - count1;
						if(countA==2)
						{
						Awon++;
		         		scoreA.setText(""+Awon);
		         		count = 0;
						count1 = 0;
						buttonundoA.setEnabled(false);
		         		buttonundoB.setEnabled(false);
						buttonA.setText(String.valueOf(count));
					    buttonB.setText(String.valueOf(count1));
			         		
		         		}
		         		
					 }

					else{}
					
				}


				if(Awon==2)
				{
		            labelA.setBounds(125, topMargin + 20, 100, 25);
					labelA.setSize(250,30);
					labelA.setText(playerAName + " wins!!");
					count = 0;
					count1 = 0;
					buttonA.setText(String.valueOf(count));
				    buttonB.setText(String.valueOf(count1));
				    buttonundoA.setEnabled(false);
		         	buttonundoB.setEnabled(false);
		         	buttonA.setEnabled(false);
		         	buttonB.setEnabled(false);
				}

				
			}

		}
		});

			buttonB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == buttonB) {
         		count1++; // increment the counter by 1
         		buttonB.setText(String.valueOf(count1));
         		playerAName = "".equals(playerA.getText()) ? "Player 1" : playerA.getText() ;
				playerBName = "".equals(playerB.getText()) ? "Player 2" : playerB.getText();
				labelA.setText(playerAName);
				labelB.setText(playerBName);
				playerA.setVisible(false);
				playerB.setVisible(false);
				buttonundoB.setEnabled(true);
         		repaint();


         		if(!matchStarted) 
		         	{
					playerAName = "".equals(playerA.getText()) ? "Player 1" : playerA.getText() ;
			        playerBName = "".equals(playerB.getText()) ? "Player 2" : playerB.getText();
					labelA.setText(playerAName);
					labelB.setText(playerBName);
					playerA.setVisible(false);
					playerB.setVisible(false);
					matchStarted = true;
					}

         		if (count1>=20)
				{

					if(count1 == 21 && count < 20)
					{
						Bwon++;
						scoreB.setText(""+Bwon);

						count = 0;
						count1 = 0;
						buttonundoA.setEnabled(false);
		         		buttonundoB.setEnabled(false);
						buttonA.setText(String.valueOf(count));
					    buttonB.setText(String.valueOf(count1));
					}
					
					
				    else if (count>=20 &&  count1>=20)
					 {
					 	
					 	buttonB.setText(String.valueOf(count1));
			         	repaint();
					 	int countB= count1 - count;
						if(countB==2)
						{
						Bwon++;
		         		scoreB.setText(""+Bwon);
		         		count = 0;
						count1 = 0;
						buttonundoA.setEnabled(false);
		         		buttonundoB.setEnabled(false);
						buttonA.setText(String.valueOf(count));
					    buttonB.setText(String.valueOf(count1));
			         		
		         		}
		         		
					 }

					else{}
					
				}



				if(Bwon==2)
				{

					labelB.setBounds(400, topMargin + 20, 100, 25);
					labelB.setSize(250,30);
					labelB.setText(playerBName + " wins!!");
					count = 0;
					count1 = 0;
					buttonA.setText(String.valueOf(count));
				    buttonB.setText(String.valueOf(count1));
				    buttonundoA.setEnabled(false);
		         	buttonundoB.setEnabled(false);
		         	buttonA.setEnabled(false);
		         	buttonB.setEnabled(false);
				}
				
			}

		}
		
	});


		buttonundoA.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				
         		count--; // decrement the counter by 1
         		buttonA.setText(String.valueOf(count));
         		repaint();

         		if(count1 >= 21 && count < 20)
					{
						Bwon++;
						scoreB.setText(""+Bwon);
						count = 0;
						count1 = 0;
						buttonA.setText(String.valueOf(count));
					    buttonB.setText(String.valueOf(count1));
					}

					else if (count>=20 &&  count1>=20) 
					{
						int countB1= count1 - count;
						if(countB1==2)
						{
						Bwon++;
		         		scoreB.setText(""+Bwon);
		         		count = 0;
						count1 = 0;
						buttonA.setText(String.valueOf(count));
					    buttonB.setText(String.valueOf(count1));		
		         		}
					}

				    else if (count==0) {
						buttonundoA.setEnabled(false);
					
					}

					else{}

				if(Bwon==2)
				{
					labelB.setBounds(400, topMargin + 20, 100, 25);
					labelB.setSize(250,30);
					labelB.setText(playerBName + " wins!!");
					count = 0;
					count1 = 0;
					buttonA.setText(String.valueOf(count));
				    buttonB.setText(String.valueOf(count1));
				}



		}
		});

		buttonundoB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				
         		count1--; // decrement the counter by 1
         		buttonB.setText(String.valueOf(count1));
         		repaint();
				
				if(count >= 21 && count1 < 20)
					{
						Awon++;
						scoreA.setText(""+Awon);
						count = 0;
						count1 = 0;
						buttonA.setText(String.valueOf(count));
					    buttonB.setText(String.valueOf(count1));
					}

					else if (count>=20 &&  count1>=20) 
					{
						int countB1= count - count1;
						if(countB1==2)
						{
							Awon++;
			         		scoreA.setText(""+Awon);
			         		count = 0;
							count1 = 0;
							buttonA.setText(String.valueOf(count));
						    buttonB.setText(String.valueOf(count1));
		
		         		}	
		         	}

		         	else if (count1==0) {
						buttonundoB.setEnabled(false);
					
					}

					else{}
						
		         	if(Awon==2)
					{
						labelA.setBounds(125, topMargin + 20, 100, 25);
					    labelA.setSize(250,30);
						labelA.setText(playerAName + " wins!!");
						count = 0;
						count1 = 0;
						buttonA.setText(String.valueOf(count));
					    buttonB.setText(String.valueOf(count1));
					}
				  
		

					
				
			

		}
		});

		buttonreset.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {

						
		         		count = 0;
		         		count1 = 0;
		         		Awon = 0;
		         		Bwon = 0;

		  			    labelA.setText(playerAName);
						labelB.setText(playerBName);

						scoreA.setText(""+Awon);
						scoreB.setText(""+Bwon);

						buttonA.setEnabled(true);
		                buttonB.setEnabled(true);

		         		buttonA.setText(String.valueOf(count));
		         		buttonB.setText(String.valueOf(count1));

		         		buttonundoA.setEnabled(false);
		         		buttonundoB.setEnabled(false);
		         		repaint();
						
					

				}
				});

			button_new.addActionListener(new ActionListener() 
			{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				count = 0;
		        count1 = 0;
		        Awon=0;
		        Bwon=0;
		        buttonA.setText(String.valueOf(count));
		        buttonB.setText(String.valueOf(count1));
		        scoreA.setText(""+Awon);
		        scoreB.setText(""+Bwon);

		        labelA.setText("");
		        labelA.setBounds(170, topMargin + 20, 100, 25);
		        labelB.setText("");
		        labelB.setBounds(460, topMargin + 20, 100, 25);
		        playerA.setText("");
		        playerB.setText("");


				playerA.setVisible(true);
				playerB.setVisible(true);

				buttonA.setEnabled(true);
		        buttonB.setEnabled(true);

				buttonundoA.setEnabled(false);
		        buttonundoB.setEnabled(false);
			
		        repaint();
			}
		});

		frame.setBounds(100, 20, 720, 800);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);

	}
	

	public static void main(String[] args)
 	 {
		new Badminton_Score_Tracker().initialize();

	}

	
}
