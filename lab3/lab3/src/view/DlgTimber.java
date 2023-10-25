package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import model.Timber;
import model.Wood;
import store.WoodDirectory;


import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DlgTimber extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLength;
	private JTextField textFieldHeight;
	private JTextField textFieldWidth;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel;
	private JComboBox<Object> comboBox;
	
	private Timber object = null;
	
	public Timber getObject() {
		return object;
	}
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTimber dialog = new DlgTimber();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTimber() {
		setModal(true);
		setTitle("Timber information");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Length, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			{
				textFieldLength = new JTextField();
				panel_1.add(textFieldLength);
				textFieldLength.setColumns(10);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Height, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			{
				textFieldHeight = new JTextField();
				panel_2.add(textFieldHeight);
				textFieldHeight.setColumns(10);
			}
		}
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Width, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			{
				textFieldWidth = new JTextField();
				panel.add(textFieldWidth);
				textFieldWidth.setColumns(10);
			}
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Wood selection", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addGap(91))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		{
			comboBox = new JComboBox<Object>();
			panel_3.add(comboBox);
		}
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onOk();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onClear();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JTextField getTextFieldLength() {
		return textFieldLength;
	}
	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}
	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}
	public JComboBox<Object> getComboBox() {
		return comboBox;
	}

	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
	public void setWoodDirectory(WoodDirectory wd) {
		ComboBoxModel<Object> model = new DefaultComboBoxModel<>(wd.getArr());
		comboBox.setModel(model);
	}
	protected void onOk() {

            float length = Float.parseFloat(textFieldLength.getText());
            float height = Float.parseFloat(textFieldHeight.getText());
            float width = Float.parseFloat(textFieldWidth.getText());

            Wood wood = (Wood) comboBox.getSelectedItem();
            object = new Timber(wood, length, height, width);
            this.setVisible(false);

    }

	public void onClear() {
		object = null;
		textFieldLength.setText("");
		textFieldHeight.setText("");
		textFieldWidth.setText("");
	}


}
