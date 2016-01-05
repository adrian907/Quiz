import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Windows {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtX;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		
		frame.getContentPane().add(panel_1, "name_60267995453810");
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Witaj w programie JavaQuiz v1.3.");
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
		lblNewLabel.setBounds(99, 11, 247, 38);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Wpisz swoje imie:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblNewLabel_1.setBounds(151, 60, 134, 14);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(151, 85, 134, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Rozpocznij Quiz");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnNewButton.setBounds(151, 189, 134, 38);
		panel_1.add(btnNewButton);
		
		JLabel lblWybierzPoziom = new JLabel("Wybierz poziom:");
		lblWybierzPoziom.setHorizontalAlignment(SwingConstants.CENTER);
		lblWybierzPoziom.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		lblWybierzPoziom.setBounds(151, 128, 134, 14);
		panel_1.add(lblWybierzPoziom);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(173, 153, 93, 20);
		panel_1.add(comboBox);
	
		
		
		frame.getContentPane().add(panel_2, "name_60269580793189");
		panel_2.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("A");
		chckbxNewCheckBox.setBounds(24, 92, 71, 23);
		chckbxNewCheckBox.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxB = new JCheckBox("B");
		chckbxB.setBounds(24, 131, 71, 23);
		chckbxB.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		panel_2.add(chckbxB);
		
		JCheckBox chckbxD = new JCheckBox("D");
		chckbxD.setBounds(24, 206, 71, 23);
		chckbxD.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		panel_2.add(chckbxD);
		
		JCheckBox chckbxC = new JCheckBox("C");
		chckbxC.setBounds(24, 170, 71, 23);
		chckbxC.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		panel_2.add(chckbxC);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(24, 22, 388, 44);
		panel_2.add(lblNewLabel_3);
		
		
		frame.getContentPane().add(panel_3, "name_65995676906472");
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Gratulacje! Tw\u00F3j wynik to : ");
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
		
		JLabel lblCzyChceszPonowi = new JLabel("Czy chcesz spróbowac raz jeszcze? ");
		lblCzyChceszPonowi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCzyChceszPonowi.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
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
	}
}
