import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

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
	private JTextField nameTextField;
	private JTextField txtX;
	private String name;
	private String[][] qpa;
	private String[][] qca;
	private HashMap<Integer, String> map;
	private JLabel questionLabel;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private ButtonGroup bg;
	static int qNumber = 0;
	private JComboBox comboBox;
	private String[] comboString;
	private String[][] questionArray;
	// private int[] questionID;
	private HashMap questionTypeID;
	private Collection<Integer> questionID;

	// JLabel lblmess;
	// JButton btnext;
	// int qaid;

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
		frame.setBounds(100, 100, 460, 400);
		frame.setLocation(430, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		questionTypeID = new HashMap<String, Integer>();
		questionTypeID.put("DatatTypes", 0);

		questionID = questionTypeID.values();

		frame.getContentPane().add(panel_1, "name_60267995453810");
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Witaj w programie JavaQuiz v2.2.");
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
		lblNewLabel.setBounds(99, 11, 247, 38);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Wpisz swoje imie:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblNewLabel_1.setBounds(151, 60, 134, 14);
		panel_1.add(lblNewLabel_1);

		nameTextField = new JTextField();
		nameTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name = nameTextField.getText();
			}
		});
		nameTextField.setBounds(151, 85, 134, 32);
		panel_1.add(nameTextField);
		nameTextField.setColumns(10);

		// //////PANEL 2///////////
		bg = new ButtonGroup();
		radioButton1 = new JRadioButton("");

		// ///////BUTTONS PANEL2/////////
		radioButton1.setSelected(true);
		radioButton1.setBounds(24, 134, 275, 23);
		panel_2.add(radioButton1);

		JRadioButton radioButton2 = new JRadioButton("");
		radioButton2.setBounds(24, 180, 275, 23);
		panel_2.add(radioButton2);

		JRadioButton radioButton3 = new JRadioButton("");
		radioButton3.setBounds(24, 226, 275, 23);
		panel_2.add(radioButton3);

		JRadioButton radioButton4 = new JRadioButton("");
		radioButton4.setBounds(24, 273, 275, 23);
		panel_2.add(radioButton4);

		// //////////////////////////////////////

		bg.add(radioButton1);// This allows only one of the buttons to be
								// clicked
		bg.add(radioButton2);
		bg.add(radioButton3);
		bg.add(radioButton4);

		JButton startButton = new JButton("Rozpocznij Quiz!");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				 name = nameTextField.getText();
				 questionLabel.setText(qpa[qNumber][0]);
				 radioButton1.setText(qpa[qNumber][1]);
				 radioButton2.setText(qpa[qNumber][2]);
				 radioButton3.setText(qpa[qNumber][3]);
				 radioButton4.setText(qpa[qNumber][4]);
				//assignLabels(1);
			}
		});
		startButton.setBounds(151, 287, 134, 38);
		panel_1.add(startButton);

		JLabel labelLevel = new JLabel("Wybierz dzia³:");
		labelLevel.setHorizontalAlignment(SwingConstants.CENTER);
		labelLevel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		labelLevel.setBounds(151, 157, 134, 14);
		panel_1.add(labelLevel);

		// ///COMBO BOX PANEL 1 /////

		comboBox = new JComboBox();
		comboString = new String[] { "Strings", "Java Core", "Generics" };
		comboBox.setModel(new DefaultComboBoxModel(comboString));
		comboBox.setBounds(173, 182, 93, 20);

		// ////////////////////////////////
		panel_1.add(comboBox);

		frame.getContentPane().add(panel_2, "name_60269580793189");
		panel_2.setLayout(null);

		questionLabel = new JLabel("");
		questionLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		questionLabel.setBounds(24, 22, 402, 78);
		panel_2.add(questionLabel);

		JButton btnNextButton = new JButton("Next");
		btnNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				questionLabel.setText(qpa[qNumber + 1][0]);
				radioButton1.setText(qpa[qNumber + 1][1]);
				radioButton2.setText(qpa[qNumber + 1][2]);
				radioButton3.setText(qpa[qNumber + 1][3]);
				radioButton4.setText(qpa[qNumber + 1][4]);

				qNumber++;
				if (qNumber == 9) {
					panel_2.setVisible(false);
					panel_3.setVisible(true);
					qNumber = 0;
				}
			}
		});
		btnNextButton.setBounds(317, 303, 109, 44);
		panel_2.add(btnNextButton);

		frame.getContentPane().add(panel_3, "name_65995676906472");
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Gratulacje " + name
				+ "! Tw\u00F3j wynik to : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 25));
		lblNewLabel_2.setBounds(64, 36, 333, 32);
		panel_3.add(lblNewLabel_2);

		txtX = new JTextField();
		txtX.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		txtX.setHorizontalAlignment(SwingConstants.CENTER);
		txtX.setText("x %");
		txtX.setBounds(151, 100, 144, 51);
		panel_3.add(txtX);
		txtX.setColumns(10);

		JButton btnEnd = new JButton("OK");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				panel_4.setVisible(true);
			}
		});
		btnEnd.setBounds(174, 199, 101, 32);
		panel_3.add(btnEnd);

		frame.getContentPane().add(panel_4, "name_67783736065234");
		panel_4.setLayout(null);

		JLabel lblCzyChceszPonowi = new JLabel(
				"Czy chcesz spróbowac raz jeszcze? ");
		lblCzyChceszPonowi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCzyChceszPonowi
				.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		lblCzyChceszPonowi.setBounds(38, 28, 354, 102);
		panel_4.add(lblCzyChceszPonowi);

		JButton btnNie = new JButton("Nie");
		btnNie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNie.setBounds(243, 180, 101, 32);
		panel_4.add(btnNie);

		JButton btnTak = new JButton("Tak");
		btnTak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_4.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnTak.setBounds(89, 180, 101, 32);
		panel_4.add(btnTak);

		qpa = new String[10][5];

		qpa[0][0] = "How to run Java program on the command prompt?";
		qpa[0][1] = "javac JavaProgram";
		qpa[0][2] = "java JavaProgram";
		qpa[0][3] = "javac JavaProgram.java";
		qpa[0][4] = "No one";

		qpa[1][0] = "What is the use of the println method?";
		qpa[1][1] = "It is used to print text on the screen.";
		qpa[1][2] = "It is used to print text on the screen with the line break.";
		qpa[1][3] = "It is used to read text from keyboard.";
		qpa[1][4] = "It is used to read text from a file.";

		qpa[2][0] = "How to read a character from the keyboard?";
		qpa[2][1] = "char c=System.read()";
		qpa[2][2] = "char c=System.in.read()";
		qpa[2][3] = "char c=(char)System.read()";
		qpa[2][4] = "char c=(char)System.in.read()";

		qpa[3][0] = "Which one is a single-line comment?";
		qpa[3][1] = "/...";
		qpa[3][2] = "//...";
		qpa[3][3] = "/*...";
		qpa[3][4] = "/*...*/";

		qpa[4][0] = "How do you declare an integer variable x?";
		qpa[4][1] = "int x";
		qpa[4][2] = "x as Integer";
		qpa[4][3] = "Int[] x";
		qpa[4][4] = "No one is correct.";

		qpa[5][0] = "How do you convert a string of number to a number?";
		qpa[5][1] = "int num=Integer.parseInt(str_num)";
		qpa[5][2] = "int num=str_num.toInteger()";
		qpa[5][3] = "int num=(int)str_num";
		qpa[5][4] = "int num=(Integer)str_num";

		qpa[6][0] = "What is the value of x? int x=3>>2";
		qpa[6][1] = "1";
		qpa[6][2] = "0";
		qpa[6][3] = "3";
		qpa[6][4] = "-3";

		qpa[7][0] = "How to do exit a loop?";
		qpa[7][1] = "Using exit";
		qpa[7][2] = "Using break";
		qpa[7][3] = "Using continue";
		qpa[7][4] = "Using terminate";

		qpa[8][0] = "What is the correct way to allocate one-dimensional array?";
		qpa[8][1] = "int[size] arr=new int[]";
		qpa[8][2] = "int arr[size]=new int[]";
		qpa[8][3] = "int[size] arr=new int[size]";
		qpa[8][4] = "int[] arr=new int[size]";

		qpa[9][0] = "What is the correct way to allocate two-dimensional array?";
		qpa[9][1] = "int[size][] arr=new int[][]";
		qpa[9][2] = "int arr=new int[rows][cols]";
		qpa[9][3] = "int arr[rows][]=new int[rows][cols]";
		qpa[9][4] = "int[][] arr=new int[rows][cols]";

		// qca stores pairs of question and its correct answer
		qca = new String[10][2];

		qca[0][0] = "How to run Java program on the command prompt?";
		qca[0][1] = "java JavaProgram";

		qca[1][0] = "What is the use of the println method?";
		qca[1][1] = "It is used to print text on the screen with the line break.";

		qca[2][0] = "How to read a character from the keyboard?";
		qca[2][1] = "char c=(char)System.in.read()";

		qca[3][0] = "Which one is a single-line comment?";
		qca[3][1] = "//...";

		qca[4][0] = "How do you declare an integer variable x?";
		qca[4][1] = "int x";

		qca[5][0] = "How do you convert a string of number to a number?";
		qca[5][1] = "int num=Integer.parseInt(str_num)";

		qca[6][0] = "What is the value of x? int x=3>>2";
		qca[6][1] = "0";

		qca[7][0] = "How to do exit a loop?";
		qca[7][1] = "Using break";

		qca[8][0] = "What is the correct way to allocate one-dimensional array?";
		qca[8][1] = "int[] arr=new int[size]";

		qca[9][0] = "What is the correct way to allocate two-dimensional array?";
		qca[9][1] = "int[][] arr=new int[rows][cols]";

	}

	public void assignLabels(int i) {
		File file;
		switch (i) {
		case 1: {
			file = new File("DataTypes.txt");
			break;
		}
		case 2: {
			file = new File("DataTypes.txt");
			break;
		}
		case 3: {
			file = new File("DataTypes.txt");
			break;
		}
		case 4: {
			file = new File("DataTypes.txt");
			break;
		}

		}

//		try (BufferedReader br = new BufferedReader(new FileReader(
//				"DataTypes.txt"))) {
//			StringBuilder sb = new StringBuilder();
//			String line = br.readLine();
//
//			while (!line.equals("<<<<<")) {
//				sb.append(line);
//				sb.append(System.lineSeparator());
//				line = br.readLine();
//			}
//			questionLabel.setText(sb.toString());
//
//			radioButton1.setText(br.readLine());
//			radioButton2.setText(br.readLine());
//			radioButton3.setText(br.readLine());
//			radioButton4.setText(br.readLine());
//		} catch (IOException e) {
//			System.out.println("Error");
//		}

	}

	public String[][] questionTable() {

		questionArray = new String[10][4];
		for (int i = 1; i < 10; i++) {
			try (BufferedReader br = new BufferedReader(new FileReader(
					"DataTypes.txt"))) {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (!line.equals("<<<<<")) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				questionArray[i][0] = sb.toString();
				questionArray[i][1] = br.readLine();
				questionArray[i][2] = br.readLine();
				questionArray[i][3] = br.readLine();
				// questionArray[i][4] = ;

			} catch (IOException e) {
				System.out.println("Error");
			}
		}

		return questionArray;
	}

}
