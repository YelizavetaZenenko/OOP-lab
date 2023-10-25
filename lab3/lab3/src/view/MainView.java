package view;

import java.awt.TextComponent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import model.Timber;
import model.Wood;
import store.ProductStore;
import store.WoodDirectory;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView {
	private InfoFrame infoFrame = new InfoFrame();
	private WoodDirectory wd = new WoodDirectory();
	private ProductStore ps = new ProductStore(); 
	private JFrame frmLabOop;

	private JTextArea textArea;

	private DlgWood dlgWood = new DlgWood();
	private DlgTimber dlgTimber = new DlgTimber();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()  {
			public void run() {
				try {
					MainView window = new MainView();
					window.frmLabOop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLabOop = new JFrame();
		frmLabOop.setTitle("Lab 3 OOP");
		frmLabOop.setBounds(100, 100, 450, 300);
		frmLabOop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLabOop.getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		frmLabOop.getContentPane().add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(textArea, popupMenu);

		JMenuItem menuItemTextAreaClear = new JMenuItem("Clear");
		menuItemTextAreaClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClearTextArea();
			}
		});
		popupMenu.add(menuItemTextAreaClear);

		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenu menuWood = new JMenu("Wood");
		menuBar.add(menuWood);

		JMenuItem menuItemShow = new JMenuItem("Show");
		menuItemShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onWoodShowClick();
			}
		});
		menuWood.add(menuItemShow);

		JMenuItem menuItemAddWood = new JMenuItem("Add");
		menuItemAddWood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAddWood();
			}
		});
		menuWood.add(menuItemAddWood);

		JMenuItem menuItemDelWood = new JMenuItem("Delete");
		menuWood.add(menuItemDelWood);

		JMenuItem menuItemEditWood = new JMenuItem("Edit");
		menuWood.add(menuItemEditWood);

		JMenu menuProduct = new JMenu("Product");
		menuBar.add(menuProduct);

		JMenuItem menuItemShowProduct = new JMenuItem("ShowAll");
		menuItemShowProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onProductShowClick();

			}
		});
		menuProduct.add(menuItemShowProduct);


		JMenu menuAddProduct = new JMenu("Add");
		menuProduct.add(menuAddProduct);

		JMenuItem menuItemAddTimber = new JMenuItem("Timber");
		menuItemAddTimber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAddTimber();
			}
		});
		menuAddProduct.add(menuItemAddTimber);

		JMenuItem menuItemInfo = new JMenuItem("Info");
		menuItemInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onInfoClick();
			}
		});

		menuBar.add(menuItemInfo);
	}
	public void onInfoClick() {
		infoFrame.setLocation(infoFrame.getLocation().x + infoFrame.getWidth(), infoFrame.getLocation().y);
		infoFrame.setVisible(true);
	}
	
	public void onWoodShowClick() {
		textArea.setText(wd.toString());

	}
	
	protected void onClearTextArea() {
		textArea.setText("");
	}
	
	protected void onAddWood() {
		dlgWood.setVisible(true);
		Wood newWood = dlgWood.getObject();
		if(newWood != null) {
			wd.add(newWood);
		}
		onWoodShowClick();
	}

	protected void onAddTimber() {
		dlgTimber.onClear();
		dlgTimber.setWoodDirectory(wd);
		dlgTimber.setVisible(true);
		Timber newTimber = dlgTimber.getObject();
		if(newTimber != null) {
			ps.add(newTimber);
		}
		onProductShowClick();
	}
	
	public void onProductShowClick() {
		textArea.setText(ps.toString());
	}

	public JTextArea getTextArea() {
		return textArea;
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
