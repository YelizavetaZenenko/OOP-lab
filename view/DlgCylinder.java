package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import model.Cylinder;
import model.Wood;
import store.WoodDirectory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

public class DlgCylinder extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLength;
	private JTextField textFieldDiameter;	

	private Cylinder object = null;
	public Cylinder getObject() {
		return object;
	}
	
	private JButton okButton;
	private JButton cancelButton;
	private JComboBox<Object> comboBoxCylinder;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCylinder dialog = new DlgCylinder();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCylinder() {
		setTitle("Cylinder information");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 334, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Length, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setToolTipText("");
			panel.setBounds(28, 10, 118, 46);
			contentPanel.add(panel);
			{
				textFieldLength = new JTextField();
				panel.add(textFieldLength);
				textFieldLength.setColumns(10);
			}
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Diameter, m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(163, 10, 118, 46);
			contentPanel.add(panel_1);
			{
				textFieldDiameter = new JTextField();
				panel_1.add(textFieldDiameter);
				textFieldDiameter.setColumns(10);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Wood selection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(28, 66, 268, 46);
			contentPanel.add(panel_2);
			panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
			{
				comboBoxCylinder = new JComboBox<Object>();
				panel_2.add(comboBoxCylinder);
			}
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
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
				cancelButton = new JButton("Cancel");
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
	public JTextField getTextFieldDiameter() {
		return textFieldDiameter;
	}
	public JComboBox<Object> getComboBoxCylinder() {
		return comboBoxCylinder;
	}
	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}

	public void onClear() {
		object = null;
		textFieldLength.setText("");
		textFieldDiameter.setText("");
		this.setVisible(false);
	}
	
	public void setWoodDirectory(WoodDirectory wd) {
		ComboBoxModel<Object> model = new DefaultComboBoxModel<>(wd.getArr());
		comboBoxCylinder.setModel(model);
	}
	
	protected void onOk() {

		float length = Float.parseFloat(textFieldLength.getText());
		float diameter = Float.parseFloat(textFieldDiameter.getText());

		Wood wood = (Wood) comboBoxCylinder.getSelectedItem();
		object = new Cylinder(wood, length, diameter);
		this.setVisible(false);

	}
}
