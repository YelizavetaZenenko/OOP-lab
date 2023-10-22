package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class MainGui {

	private JFrame frmZenenkoYelizaveta;
	private JTextField txtFieldName;
	private JTextField textFieldMark;
	private JCheckBox chckbxNewCheckBox;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private AbstractButton burl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frmZenenkoYelizaveta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZenenkoYelizaveta = new JFrame();
		frmZenenkoYelizaveta.setTitle("Zenenko Yelizaveta");
		frmZenenkoYelizaveta.setBounds(100, 100, 450, 300);
		frmZenenkoYelizaveta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{154, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		frmZenenkoYelizaveta.getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(3, 3, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmZenenkoYelizaveta.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		txtFieldName = new JTextField();
		txtFieldName.setToolTipText("Name");
		txtFieldName.setText("SomeStudent");
		GridBagConstraints gbc_txtFieldName = new GridBagConstraints();
		gbc_txtFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldName.gridx = 0;
		gbc_txtFieldName.gridy = 1;
		panel.add(txtFieldName, gbc_txtFieldName);
		txtFieldName.setColumns(10);

		chckbxNewCheckBox = new JCheckBox("Budjet");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 2;
		panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		textFieldMark = new JTextField();
		textFieldMark.setToolTipText("Marks");
		textFieldMark.setText("60 75 90 100");
		GridBagConstraints gbc_textFieldMark = new GridBagConstraints();
		gbc_textFieldMark.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMark.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMark.gridx = 0;
		gbc_textFieldMark.gridy = 3;
		panel.add(textFieldMark, gbc_textFieldMark);
		textFieldMark.setColumns(10);

		btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnCalculate();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		panel.add(btnNewButton, gbc_btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		frmZenenkoYelizaveta.getContentPane().add(scrollPane, gbc_scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		lblNewLabel = new JLabel("Result of calcilation");
		scrollPane.setColumnHeaderView(lblNewLabel);
	}
	public JTextField getTxtFieldName() {
		return txtFieldName;
	}
	public JCheckBox getChckbxNewCheckBox() {
		return chckbxNewCheckBox;
	}
	public JTextField getTextFieldMark() {
		return textFieldMark;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	protected void cnCalculate() {
		String text = textFieldMark.getText();
		String [] marks = text.trim().split(" ");

		int[] numbers = new int[marks.length];

		for (int i = 0; i < marks.length; i++) {
			numbers[i] = Integer.parseInt(marks[i]);
		}
		
		for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 90 && numbers[i] <= 100) {
                numbers[i] = 5;
            } else if (numbers[i] >= 75 && numbers[i] <= 89) {
                numbers[i] = 4;
            }
            else if (numbers[i] >= 60 && numbers[i] <= 74) {
                numbers[i] = 3;
            }
            else if (numbers[i] >= 0 && numbers[i] <= 59) {
                numbers[i] = 2;
            }
        }
		
		int minScore = numbers[0];
		
		for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minScore) {
                minScore = numbers[i]; 
            }
        }
		
        String name = txtFieldName.getText();
		
		 StringBuilder sb = new StringBuilder();
		 sb.append("Name: ").append(name).append("\n");
		 sb.append("Marks: ");

	        for (int i = 0; i < numbers.length; i++) {
	            sb.append(numbers[i]);
	            if (i < numbers.length - 1) {
	                sb.append(", "); 
	            }
	        }
			 sb.append("\nMin marks: ").append(minScore);
	        textArea.setText(sb.toString());

		if(chckbxNewCheckBox.isSelected() == true & minScore >= 5) {
			textArea.append("\nScholarship 2000");

		}
		else if (chckbxNewCheckBox.isSelected() == true & minScore >= 4) {
			textArea.append("\nScholarship 1500");
		}
		else if (chckbxNewCheckBox.isSelected() == true & minScore < 4) {
			textArea.append("\nStudent not receives scholarship, there is a rating less than 4");
		}
		else 
			textArea.append("\nStudent not receives scholarship");
		System.out.println(minScore);
		
	}

}
