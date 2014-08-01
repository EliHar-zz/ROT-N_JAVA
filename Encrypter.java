//********************************************************************************************
// Assignment 4
// Written by Elias Haroun, ID: 6241824
// For COMP 249 Section (PP)  -   Winter 2014
// Due date 11 April 14
//********************************************************************************************




import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This program allows the user to encrypt/decrypt a message using the Rot-n encryption system through an interesting looking GUI.
 * The user has multiple encryption options, and can choose whether they want to process numbers or not.
 * The user also has the freedom to change font and color of the text displayed as well as the background
 * @author Elias Haroun
 * @version 1.0
 */
public class Encrypter {

	private ButtonGroup bg1;
	private JRadioButton encryptRadioButton;
	private JRadioButton decryptRadioButton;
	private JCheckBox digitsCheck;
	private String selectedFont;
	private JSplitPane textPanel ;
	private JTextArea beforeText ;
	private JTextArea afterText;
	private JButton clearButton;
	private JButton processButton;
	private JFrame mainWindow;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Encrypter window = new Encrypter();
			window.mainWindow.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Encrypter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setAlwaysOnTop(false);
		mainWindow.setResizable(false);
		mainWindow.setBackground(new Color(0, 102, 204));
		mainWindow.setTitle("Rot-N Encrypter/Decrypter");
		mainWindow.setForeground(new Color(0, 0, 128));
		mainWindow.getContentPane().setFont(new Font("Marion", Font.PLAIN, 13));
		mainWindow.getContentPane().setBackground(new Color(0, 102, 204));

		// add the header panel
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(UIManager.getBorder("MenuBar.border"));
		headerPanel.setBackground(new Color(0, 102, 204));
		headerPanel.setLayout(new BorderLayout(10,0));
		mainWindow.getContentPane().add(headerPanel, BorderLayout.NORTH);

		// logo Image
		ImageIcon image = new ImageIcon("icon.png");
		JLabel pic = new JLabel(image);
		headerPanel.add(pic, BorderLayout.LINE_START);

		// Window label
		JLabel RotTitle = new JLabel("Rot-N");
		RotTitle.setFont(new Font("Impact", Font.ITALIC, 100));
		RotTitle.setForeground(new Color(255, 150, 0));
		headerPanel.add(RotTitle, BorderLayout.CENTER);

		// Window label
		JLabel title2 = new JLabel("   Text Encrypter / Decrypter");
		title2.setFont(new Font("Impact", Font.PLAIN, 30));
		title2.setForeground(new Color(255, 222, 0));
		headerPanel.add(title2, BorderLayout.SOUTH);

		// Option panel
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(0, 102, 204));
		mainWindow.getContentPane().add(optionsPanel, BorderLayout.WEST);
		optionsPanel.setLayout(new GridLayout(0, 1, 0, 0));

		// add a sub option panel
		JPanel subOptionsPanel = new JPanel();
		subOptionsPanel.setBackground(new Color(0, 102, 204));
		optionsPanel.add(subOptionsPanel);
		subOptionsPanel.setLayout(new GridLayout(9, 1, 0, 0));

		// Encrypt radio button
		encryptRadioButton = new JRadioButton("Encrypt");
		encryptRadioButton.setToolTipText("Encrypt");
		encryptRadioButton.setSelected(true);
		encryptRadioButton.setActionCommand("encrypt");
		encryptRadioButton.setBackground(new Color(0, 102, 204));
		encryptRadioButton.setForeground(new Color(240, 255, 255));
		subOptionsPanel.add(encryptRadioButton);

		// Decrypt radio button
		decryptRadioButton = new JRadioButton("Decrypt");
		decryptRadioButton.setToolTipText("Decrypt");
		decryptRadioButton.setActionCommand("decrypt");
		decryptRadioButton.setBackground(new Color(0, 102, 204));
		decryptRadioButton.setForeground(new Color(240, 255, 255));
		subOptionsPanel.add(decryptRadioButton);

		// group radio button
		bg1 = new ButtonGroup();
		bg1.add(encryptRadioButton);
		bg1.add(decryptRadioButton);

		// Digits check
		digitsCheck = new JCheckBox("Process digits");
		digitsCheck.setForeground(new Color(224, 255, 255));
		digitsCheck.setBackground(new Color(0, 102, 204));
		subOptionsPanel.add(digitsCheck);


		// select font label
		JLabel selectfont = new JLabel("Select font:");
		selectfont.setBackground(new Color(0, 102, 204));
		selectfont.setForeground(new Color(240, 255, 255));
		subOptionsPanel.add(selectfont);

		// Font selector
		String[] fontStrings = {"Arial", "Times New Roman", "Courier New", "Impact", "Comic Sans MS"};

		final JComboBox fontSelectBox = new JComboBox(fontStrings);

		fontSelectBox.setSelectedIndex(0);
		fontSelectBox.setForeground(new Color(0, 0, 128));
		fontSelectBox.setBackground(new Color(240, 248, 255));
		fontSelectBox.setMaximumRowCount(5);
		fontSelectBox.setToolTipText("Select font");
		subOptionsPanel.add(fontSelectBox);

		/**
		 * This method takes a method of an anonymous calss to perform the action
		 */
		fontSelectBox.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {


				switch (fontSelectBox.getSelectedIndex()) {

				case 0: selectedFont = "Arial";
				beforeText.setFont(new Font(selectedFont, Font.PLAIN, 14));
				afterText.setFont(new Font(selectedFont, Font.PLAIN, 14));

				break;
				case 1: selectedFont = "Times New Roman";
				beforeText.setFont(new Font(selectedFont, Font.PLAIN, 16));
				afterText.setFont(new Font(selectedFont, Font.PLAIN, 16));
				break;
				case 2: selectedFont = "Courier New";
				beforeText.setFont(new Font(selectedFont, Font.PLAIN, 14));
				afterText.setFont(new Font(selectedFont, Font.PLAIN, 14));
				break;
				case 3: selectedFont = "Impact";
				beforeText.setFont(new Font(selectedFont, Font.PLAIN, 16));
				afterText.setFont(new Font(selectedFont, Font.PLAIN, 16));
				break;
				case 4: selectedFont = "Comic Sans MS";
				beforeText.setFont(new Font(selectedFont, Font.PLAIN, 14));
				afterText.setFont(new Font(selectedFont, Font.PLAIN, 14));
				}
			}
		});

		// select Font color label
		JLabel selectColor = new JLabel("Select text color:");
		selectColor.setBackground(new Color(0, 102, 204));
		selectColor.setForeground(new Color(240, 255, 255));
		subOptionsPanel.add(selectColor);


		//Font color selector
		String[] textColor  = {"Black / Black", "Red / Blue", "Blue / Red", "Green / Yellow", "Purple / Green", "Orange / Purple"};

		final JComboBox colorSelectBox = new JComboBox(textColor);

		colorSelectBox.setSelectedIndex(0);
		colorSelectBox.setForeground(new Color(0, 0, 128));
		colorSelectBox.setBackground(new Color(240, 248, 255));
		colorSelectBox.setMaximumRowCount(6);
		colorSelectBox.setToolTipText("Select font color");
		subOptionsPanel.add(colorSelectBox);

		colorSelectBox.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {

				switch (colorSelectBox.getSelectedIndex()) {

				case 0: 
					beforeText.setForeground(new Color(0, 0, 0));
					afterText.setForeground(new Color(0, 0, 0));
					break;
				case 1: 
					beforeText.setForeground(new Color(255, 0, 0));
					afterText.setForeground(new Color(0, 0, 255));
					break;
				case 2:
					beforeText.setForeground(new Color(0, 0, 255));
					afterText.setForeground(new Color(255, 0, 0));
					break;
				case 3: 
					beforeText.setForeground(new Color(40, 200, 30));
					afterText.setForeground(new Color(255, 255, 0));
					break;
				case 4:
					beforeText.setForeground(new Color(187, 0, 250));
					afterText.setForeground(new Color(40, 200, 30));
					break;
				case 5:
					beforeText.setForeground(new Color(255, 187, 0));
					afterText.setForeground(new Color(187, 0, 250));
				}
			}
		});


		// select bg color label
		JLabel selectBgColor = new JLabel("Select Background color:   ");
		selectBgColor.setBackground(new Color(0, 102, 204));
		selectBgColor.setForeground(new Color(240, 255, 255));
		subOptionsPanel.add(selectBgColor);

		// color selector
		String[] textColorArray =  {"Baby Blue", "White", "Black"};
		final JComboBox BGColorSelectBox = new JComboBox(textColorArray);

		BGColorSelectBox.setSelectedIndex(0);
		BGColorSelectBox.setForeground(new Color(0, 0, 128));
		BGColorSelectBox.setBackground(new Color(240, 248, 255));
		BGColorSelectBox.setMaximumRowCount(3);
		BGColorSelectBox.setToolTipText("Select bacground color");
		subOptionsPanel.add(BGColorSelectBox);

		/**
		 * This method takes a method of an anonymous calss to perform the action
		 */
		BGColorSelectBox.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {

				switch (BGColorSelectBox.getSelectedIndex()) {

				case 0: 
					beforeText.setBackground(new Color(240, 248, 255));
					afterText.setBackground(new Color(240, 248, 255));
					break;
				case 1: 
					beforeText.setBackground(new Color(255, 255, 255));
					afterText.setBackground(new Color(255, 255, 255));
					break;
				case 2:
					beforeText.setBackground(new Color(0, 0, 0));
					afterText.setBackground(new Color(0, 0, 0));
					break;
				}
			}
		});

		// Add a split panel to hold the text areas
		textPanel = new JSplitPane();
		textPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		textPanel.setForeground(new Color(0, 0, 128));
		textPanel.setContinuousLayout(true);
		textPanel.setOneTouchExpandable(true);
		textPanel.setBackground(new Color(0, 102, 204));
		textPanel.setDividerSize(12);
		textPanel.setResizeWeight(0.5);
		mainWindow.getContentPane().add(textPanel, BorderLayout.CENTER);


		// Before text
		beforeText = new JTextArea();
		beforeText.setToolTipText("Original Text");
		beforeText.setWrapStyleWord(true);
		beforeText.setLineWrap(true);
		beforeText.setTabSize(4);
		beforeText.setText("Original Text");
		beforeText.setForeground(new Color(0, 0, 0));
		beforeText.setFont(new Font("Arial", Font.PLAIN, 14));
		beforeText.setBackground(new Color(240, 248, 255));

		// Mouse click over text area
		beforeText.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if (beforeText.getText().equals("Original Text") && afterText.getText().equals("Processed Text")){
					beforeText.setText("");
					afterText.setText("");
				}
			}
			public void mouseReleased(MouseEvent e) {}

			public void mousePressed(MouseEvent e){}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}
		});

		// Mouse click elsewhere in the window
		mainWindow.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if (beforeText.getText().equals("")) {
					beforeText.setText("Original Text");
					afterText.setText("Processed Text");
				}
			}
			public void mouseReleased(MouseEvent e) {}

			public void mousePressed(MouseEvent e){}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}
		});

		textPanel.setLeftComponent(beforeText);

		final JScrollPane scrollBeforeText = new JScrollPane(beforeText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		final JScrollPane temporaryScrollBar = new JScrollPane();

		temporaryScrollBar.getVerticalScrollBar().setModel(scrollBeforeText.getVerticalScrollBar().getModel());

		textPanel.add(scrollBeforeText);

		// After Text
		afterText = new JTextArea();
		afterText.setToolTipText("Processed Text");
		afterText.setWrapStyleWord(true);
		afterText.setLineWrap(true);
		afterText.setEditable(false);
		afterText.setTabSize(4);
		afterText.setFont(new Font("Arial", Font.PLAIN, 14));
		afterText.setForeground(new Color(0, 0, 0));
		afterText.setText("Processed Text");
		afterText.setBackground(new Color(240, 248, 255));

		textPanel.setRightComponent(afterText);

		final JScrollPane scrollAfterText = new JScrollPane(afterText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textPanel.add(scrollAfterText);	

		// Crypto panel
		JPanel cryptoPanel = new JPanel();
		cryptoPanel.setBackground(new Color(0, 102, 204));
		optionsPanel.add(cryptoPanel);
		cryptoPanel.setLayout(new GridLayout(9, 1, 0, 0));


		// Crypto label
		JLabel cryptolabel = new JLabel("Cryptography Type:");
		cryptolabel.setBackground(new Color(0, 102, 204));
		cryptolabel.setForeground(new Color(240, 255, 255));
		cryptoPanel.add(cryptolabel);

		// Select crypto
		String[] cryptoArray =  {"Select type...","ROT5", "ROT7", "ROT13", "ROT17"};

		final JComboBox cryptoBox = new JComboBox(cryptoArray);

		cryptoBox.setSelectedIndex(0);
		cryptoBox.setForeground(new Color(0, 0, 128));
		cryptoBox.setBackground(new Color(240, 248, 255));
		cryptoBox.setMaximumRowCount(5);
		cryptoBox.setToolTipText("Set Crypto type");
		cryptoPanel.add(cryptoBox);

		/**
		 * This method takes a method of an anonymous calss to perform the action
		 */
		cryptoBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Logic.isPressed())
					Logic.appLogic(scrollBeforeText, scrollAfterText, afterText, beforeText, bg1, cryptoBox, digitsCheck);
			}
		});

		// author label
		JLabel author = new JLabel("\n \n \n by Elias Haroun  ");
		author.setFont(new Font("Impact", Font.PLAIN, 10));
		author.setForeground(new Color(255, 222, 0));
		cryptoPanel.add(author, BorderLayout.SOUTH);

		// Footer Panel
		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(new Color(0, 102, 204));
		mainWindow.getContentPane().add(footerPanel, BorderLayout.SOUTH);

		// Process text button
		processButton = new JButton("Go");
		processButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Logic.appLogic(scrollBeforeText, scrollAfterText, afterText, beforeText, bg1, cryptoBox, digitsCheck);
			}
		});

		footerPanel.add(processButton);

		//Clear Button
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				beforeText.setText("Original Text");	
				afterText.setText("Processed Text");
				encryptRadioButton.setSelected(true);
				final int width = mainWindow.getWidth();
				textPanel.setDividerLocation(548);

				// Un-Sync Scroll bars
				scrollBeforeText.getVerticalScrollBar().setModel(temporaryScrollBar.getVerticalScrollBar().getModel());

				Logic.setPressed(false);
			}
		});
		footerPanel.add(clearButton);

		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  
		mainWindow.setSize(xSize,ySize);  
		mainWindow.setExtendedState(Frame.MAXIMIZED_BOTH); 
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
