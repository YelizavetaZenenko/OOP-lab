package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import model.Waste;


public class DlgWaste extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel panel;
	private JTextField textFieldWeight;
	
	private Waste object = null;

	public Waste getObject() {
		return object;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgWaste dialog = new DlgWaste();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgWaste() {
		setTitle("Waste information");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 244, 153);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Waste, kg", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			{
				textFieldWeight = new JTextField();
				panel.add(textFieldWeight);
				textFieldWeight.setColumns(10);
			}
		}
		{
			buttonPane = new JPanel();
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
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPanel, getContentPane(), buttonPane, okButton, cancelButton, panel, textFieldWeight}));
	}

	public void onClear() {
		object = null;
		textFieldWeight.setText("");
		this.setVisible(false);
		
	}
	protected void onOk() {

		float weight = Float.parseFloat(textFieldWeight.getText());

		object = new Waste(weight);
		this.setVisible(false);

	}

	public JTextField getTextFieldWeight() {
		return textFieldWeight
				;
	}
	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
}
