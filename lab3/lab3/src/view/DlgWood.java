package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Wood;

public class DlgWood extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDensity;
	private JTextField textFieldName;
	private JTextField textFieldId;
	private Wood object = null;
	private JButton okButton;
	private JButton cancelButton;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgWood dialog = new DlgWood();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgWood() {
		setModal(true);
		setTitle("Wood information:");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Id", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			{
				textFieldId = new JTextField();
				panel.add(textFieldId);
				textFieldId.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			{
				textFieldName = new JTextField();
				panel.add(textFieldName);
				textFieldName.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Density, kg/m^3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			{
				textFieldDensity = new JTextField();
				panel.add(textFieldDensity);
				textFieldDensity.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.CENTER);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onOK();
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
						onCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public Wood getObject() {
		return object;
	}


	protected void onOK() {
		int id = Integer.parseInt(textFieldId.getText());
		String name = textFieldName.getText();
		float density = Float.parseFloat(textFieldDensity.getText());
		object = new Wood(id, name, density);
		this.setVisible(false);
	}

	protected void onCancel() {
		object = null;
		this.setVisible(false);
	}

	public JTextField getTextFieldId() {
		return textFieldId;
	}
	public JTextField getTextFieldName() {
		return textFieldName;
	}
	public JTextField getTextFieldDensity() {
		return textFieldDensity;
	}
	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}

}
