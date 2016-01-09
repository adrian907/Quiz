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
	private JTextField txtX;
	private static String name;
	private JLabel questionLabel;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private ButtonGroup bg;
	static int qNumber = 1;
	private JComboBox comboBox;
	private String[] comboString;
	private String[][] questionArray;
	private int[][] questionAnswers;
	private int getSelectedArea;
	private int[] userAnswers = new int[11];
	static int answerCounter = 0;
	private float totalScore = 100;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Windows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setLocation(325, 20);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();

		frame.getContentPane().add(panel_1, "name_60267995453810");
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to the Java Quiz v2.4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 27));
		lblNewLabel.setBounds(102, 70, 501, 186);
		panel_1.add(lblNewLabel);

		// //////PANEL 2///////////
		bg = new ButtonGroup();
		radioButton1 = new JRadioButton("");

		// ///////BUTTONS PANEL2/////////
		radioButton1.setSelected(true);
		radioButton1.setBounds(21, 416, 275, 23);
		panel_2.add(radioButton1);

		radioButton2 = new JRadioButton("");

		radioButton2.setBounds(21, 463, 275, 23);
		panel_2.add(radioButton2);

		radioButton3 = new JRadioButton("");

		radioButton3.setBounds(21, 506, 275, 23);
		panel_2.add(radioButton3);

		radioButton4 = new JRadioButton("");

		radioButton4.setBounds(21, 549, 275, 23);
		panel_2.add(radioButton4);

		// //////////////////////////////////////

		bg.add(radioButton1);// This allows only one of the buttons to be
								// clicked
		bg.add(radioButton2);
		bg.add(radioButton3);
		bg.add(radioButton4);

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

		JLabel labelLevel = new JLabel("Choose section:");
		labelLevel.setHorizontalAlignment(SwingConstants.CENTER);
		labelLevel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		labelLevel.setBounds(285, 320, 134, 25);
		panel_1.add(labelLevel);

		// ///COMBO BOX PANEL 1 /////

		comboBox = new JComboBox();

		comboString = new String[] { "AccessControle", "DataTypes",
				"EventHandling", "Exceptions", "Inheritance", "InputOutput",
				"LiteralsAndVariables", "MultiThreading" };
		comboBox.setModel(new DefaultComboBoxModel(comboString));
		comboBox.setBounds(285, 356, 134, 20);

		// ////////////////////////////////
		panel_1.add(comboBox);

		frame.getContentPane().add(panel_2, "name_60269580793189");
		panel_2.setLayout(null);

		questionLabel = new JLabel(
				"asdadasdasdasdddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
		questionLabel.setVerticalAlignment(SwingConstants.TOP);
		questionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		questionLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		questionLabel.setBounds(21, 23, 627, 399);

		panel_2.add(questionLabel);

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
					getScore(getSelectedArea);

					totalScore = getScore(getSelectedArea);
				}
				radioButton1.setSelected(true);
			}
		});
		btnNextButton.setBounds(555, 595, 109, 44);
		panel_2.add(btnNextButton);

		frame.getContentPane().add(panel_3, "name_65995676906472");
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Gratulacje!");
		lblNewLabel_2.setText("Congratulations !");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 25));
		lblNewLabel_2.setBounds(168, 169, 354, 53);
		panel_3.add(lblNewLabel_2);

		txtX = new JTextField();
		txtX.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		txtX.setHorizontalAlignment(SwingConstants.CENTER);
		txtX.setText(totalScore + "%");
		txtX.setBounds(234, 233, 221, 51);
		panel_3.add(txtX);
		txtX.setColumns(10);

		JButton btnEnd = new JButton("OK");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				panel_4.setVisible(true);

			}
		});
		btnEnd.setBounds(284, 363, 125, 43);
		panel_3.add(btnEnd);

		frame.getContentPane().add(panel_4, "name_67783736065234");
		panel_4.setLayout(null);

		JLabel lblCzyChceszPonowi = new JLabel("Do you want to try again?");
		lblCzyChceszPonowi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCzyChceszPonowi
				.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		lblCzyChceszPonowi.setBounds(175, 234, 354, 102);
		panel_4.add(lblCzyChceszPonowi);

		JButton btnNie = new JButton("No");
		btnNie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNie.setBounds(361, 347, 101, 32);
		panel_4.add(btnNie);

		JButton btnTak = new JButton("Yes");
		btnTak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_4.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnTak.setBounds(207, 347, 101, 32);
		panel_4.add(btnTak);

		questionAnswers = new int[10][11];

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
			file = new FileReader("DataTypes.txt");
			break;
		case 3:
			file = new FileReader("EventHandling.txt");
			break;
		case 4:
			file = new FileReader("Exceptions.txt");
			break;
		case 5:
			file = new FileReader("Inheritance.txt");
			break;
		case 6:
			file = new FileReader("InputOutput.txt");
			break;
		case 7:
			file = new FileReader("LiteralsAndVariables.txt");
			break;
		case 8:
			file = new FileReader("MultiThreading.txt");
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
			if (questionAnswers[4][i] - userAnswers[i] == 0) {
				result++;
			}
		}
		return result;
	}

}