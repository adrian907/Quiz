import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Windows {

	private JFrame frame;
	private JTextField scoreText;
	private JLabel questionLabel;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private ButtonGroup buttonGroup;
	private int qNumber = 1;
	private JComboBox comboBox;
	private String[] comboString;
	private String[][] questionArray;
	private int[][] questionAnswers;
	private int getSelectedArea;
	private int[] userAnswers = new int[11];
	private int answerCounter = 0;
	private float totalScore = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windows window = new Windows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Windows() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setLocation(325, 20);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		questionAnswers = new int[10][11];

		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();

		frame.getContentPane().add(panel_1, "name_60267995453810");
		panel_1.setLayout(null);

		// ////////////PANEL 1 - LABEL WELCOME ////////////////////////

		JLabel lblWelcome = new JLabel("Welcome to the Java Quiz v2.4");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Microsoft JhengHei", Font.BOLD, 27));
		lblWelcome.setBounds(102, 70, 501, 186);
		panel_1.add(lblWelcome);

		// //////////////// BUTTONS PANEL2//////////////////////////

		buttonGroup = new ButtonGroup();

		radioButton1 = new JRadioButton("");
		radioButton1.setSelected(true);
		radioButton1.setBounds(21, 416, 643, 23);
		panel_2.add(radioButton1);

		radioButton2 = new JRadioButton("");
		radioButton2.setBounds(21, 463, 643, 23);
		panel_2.add(radioButton2);

		radioButton3 = new JRadioButton("");
		radioButton3.setBounds(21, 506, 643, 23);
		panel_2.add(radioButton3);

		radioButton4 = new JRadioButton("");
		radioButton4.setBounds(21, 549, 643, 23);
		panel_2.add(radioButton4);

		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		buttonGroup.add(radioButton4);

		// ///////////// PANEL 1 - START BUTTON ///////////////////////////

		JButton startButton = new JButton("Start!");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				getSelectedArea = comboBox.getSelectedIndex();
				try {
					questionTable(getSelectedArea + 1);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out
							.println("STh's wrong with creating question table.");
				}
				questionLabel.setText(questionArray[0][0]);
				radioButton1.setText(questionArray[0][1]);
				radioButton2.setText(questionArray[0][2]);
				radioButton3.setText(questionArray[0][3]);
				radioButton4.setText(questionArray[0][4]);

				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		startButton.setBounds(285, 502, 133, 53);
		panel_1.add(startButton);

		JLabel labelSection = new JLabel("Choose section:");
		labelSection.setHorizontalAlignment(SwingConstants.CENTER);
		labelSection.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		labelSection.setBounds(285, 320, 134, 25);
		panel_1.add(labelSection);

		// ////////////////////COMBO BOX PANEL 1 //////////////////////////

		comboBox = new JComboBox();

		comboString = new String[] { "AccessControle", "Arrays", "Collections",
				"DataTypes", "EventHandling", "Exceptions", "InputOutput",
				"LiteralsAndVariables", "MultiThreading", "Maps" };
		comboBox.setModel(new DefaultComboBoxModel(comboString));
		comboBox.setBounds(285, 356, 134, 20);

		panel_1.add(comboBox);

		// //////////////////////PANEL 2 ////////////////////////////////

		frame.getContentPane().add(panel_2, "name_60269580793189");
		panel_2.setLayout(null);

		// ///////////// PANEL 2 - QUESTION LABEL ///////////////////

		questionLabel = new JLabel();
		questionLabel.setVerticalAlignment(SwingConstants.TOP);
		questionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		questionLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		questionLabel.setBounds(21, 23, 643, 399);

		panel_2.add(questionLabel);

		// ///////////////// PANEL 2 - NEXT BUTTON////////////////////////

		JButton btnNextButton = new JButton("Next");
		btnNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				questionLabel.setText(questionArray[qNumber][0]);
				radioButton1.setText(questionArray[qNumber][1]);
				radioButton2.setText(questionArray[qNumber][2]);
				radioButton3.setText(questionArray[qNumber][3]);
				radioButton4.setText(questionArray[qNumber][4]);

				if (radioButton1.isSelected() == true)
					userAnswers[answerCounter] = 1;
				if (radioButton2.isSelected() == true)
					userAnswers[answerCounter] = 2;
				if (radioButton3.isSelected() == true)
					userAnswers[answerCounter] = 3;
				if (radioButton4.isSelected() == true)
					userAnswers[answerCounter] = 4;

				answerCounter++;
				qNumber++;
				if (qNumber == 10) {
					panel_2.setVisible(false);
					panel_3.setVisible(true);
					qNumber = 1;
					answerCounter = 0;
					totalScore = (getScore(getSelectedArea) / 9) * 100;

					String txt = "" + (int) totalScore + "%";
					scoreText.setText(txt);
				}
				radioButton1.setSelected(true);
			}
		});
		btnNextButton.setBounds(555, 595, 109, 44);
		panel_2.add(btnNextButton);

		// //////////////////////// PANEL 3 //////////////////////////

		frame.getContentPane().add(panel_3, "name_65995676906472");
		panel_3.setLayout(null);

		// //////////// PANEL 3 - LABEL CONGRATULATIONS ///////////////
		JLabel lblCongratulations = new JLabel("Gratulacje!");
		lblCongratulations.setText("Congratulations !");
		lblCongratulations.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongratulations
				.setFont(new Font("Microsoft JhengHei", Font.BOLD, 25));
		lblCongratulations.setBounds(168, 169, 354, 53);
		panel_3.add(lblCongratulations);

		// /////////////PANEL 3 - SCORETEXT ////////////////////////

		scoreText = new JTextField();
		scoreText.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		scoreText.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(scoreText);
		scoreText.setBounds(253, 301, 187, 51);
		scoreText.setColumns(10);

		// ////////////////PANEL 3 BUTTON OK ////////////////////////
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				panel_4.setVisible(true);
			}
		});
		btnOK.setBounds(288, 394, 125, 43);
		panel_3.add(btnOK);

		JLabel lblNewLabel = new JLabel("Your score is :");
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(253, 239, 187, 36);
		panel_3.add(lblNewLabel);

		// //////////////////////////PANEL 4 //////////////////////

		frame.getContentPane().add(panel_4, "name_67783736065234");
		panel_4.setLayout(null);

		// ///////////////// PANEL 4 - LABEL TRY AGAIN ////////////

		JLabel lblTryAgain = new JLabel("Do you want to try again?");
		lblTryAgain.setHorizontalAlignment(SwingConstants.CENTER);
		lblTryAgain.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		lblTryAgain.setBounds(176, 197, 354, 102);
		panel_4.add(lblTryAgain);

		// //////////////// PANEL 4 - BUTTON NO////////////////////

		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNo.setBounds(362, 310, 101, 32);
		panel_4.add(btnNo);

		// ////////////// PANEL 4 - BUTTON YES ///////////////////////

		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_4.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnYes.setBounds(208, 310, 101, 32);
		panel_4.add(btnYes);

		// ///////////////////////////////////////////////////////////

	}

	public String[][] questionTable(int i) throws FileNotFoundException {
		StringBuilder sb;
		String line;

		questionArray = new String[10][5];

		FileReader file = null;

		switch (i) {
		case 1:
			file = new FileReader("AccessControle.txt");
			break;
		case 2:
			file = new FileReader("Arrays.txt");
			break;
		case 3:
			file = new FileReader("Collections.txt");
			break;
		case 4:
			file = new FileReader("DataTypes.txt");
			break;
		case 5:
			file = new FileReader("EventHandling.txt");
			break;
		case 6:
			file = new FileReader("Exceptions.txt");
			break;
		case 7:
			file = new FileReader("InputOutput.txt");
			break;
		case 8:
			file = new FileReader("LiteralsAndVariables.txt");
			break;
		case 9:
			file = new FileReader("MultiThreading.txt");
			break;
		case 10:
			file = new FileReader("Maps.txt");
			break;

		}

		try (BufferedReader br = new BufferedReader(file)) {
			for (int j = 0; j < 10; j++) {
				sb = new StringBuilder();
				line = br.readLine();
				sb.append("<html>");
				while (!line.equals("<<<<<")) {
					sb.append(line);
					sb.append("<br>");
					sb.append(System.lineSeparator());
					line = br.readLine();

				}
				sb.append("</html>");

				questionArray[j][0] = sb.toString();

				for (int k = 1; k < 5; k++) {
					line = br.readLine();
					if (line.equals("<<<")) {
						questionArray[j][k] = br.readLine();
						questionAnswers[i][j] = k;
					} else {
						questionArray[j][k] = line;
					}
				}
			}

		} catch (IOException e) {
			System.out.println("Error");
		}

		return questionArray;
	}

	public float getScore(int j) {
		int result = 0;
		for (int i = 1; i < 10; i++) {
			if (questionAnswers[j + 1][i] - userAnswers[i] == 0) {
				result++;
			}
		}
		return result;
	}
}