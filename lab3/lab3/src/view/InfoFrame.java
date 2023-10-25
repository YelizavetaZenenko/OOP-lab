package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Insets;

public class InfoFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	
	private java.net.URL url =
		      InfoFrame.class.getResource("/resource/liza.jpg");
		  private BufferedImage img = null;

		  {
		    try {
		      img = ImageIO.read(url);  
		    } catch (IOException e1) {
		      e1.printStackTrace();
		    }
		  }
		  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoFrame frame = new InfoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InfoFrame() {
		getContentPane().setEnabled(false);
		setTitle("Developer information");
		setBounds(50, 100, 396, 345);
		setResizable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout); 
		

		
		JPanel panel = new JPanel() {
		      public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        Graphics2D g2d =(Graphics2D) g;
		        Image scaledImg = img.getScaledInstance(getWidth(),
		            getHeight(),Image. SCALE_SMOOTH);
		        g2d.drawImage(scaledImg, 0, 0, this);

		      }
		    };
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setTabSize(1);
		
		textArea.setText("The program was created by:\r\nZenenko Yelizaveta\r\nStudent of KI 222\r\nlizazenenko@gmail.com");
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		getContentPane().add(textArea, gbc_textArea);
		setResizable(false);
		
		
	}

}
