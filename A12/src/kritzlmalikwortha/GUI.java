package kritzlmalikwortha;

import javax.swing.*;

/**
 * Die GUI für das Verschlüsselungsprogramm wid hier erstellt!
 * @author Simon Wortha
 * @version 17.02.2014
 *
 */
public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea eingText;
	private JTextArea ausgText;
	private JTextField verSch;
	private JLabel label1;
	private JLabel label2;
	private JButton bVer;
	private JButton bEnt;
	private JComboBox<String> dropdown;
	private Controller controller;
	/**
	 * @param c 
	 * 
	 */
	public GUI(Controller c) {
		super("Das sneaky Verschlüsselungsprogramm");
		this.controller = c;
		
		this.eingText = new JTextArea();
		this.ausgText = new JTextArea();
		
		this.verSch = new JTextField();
		
		this.label1 = new JLabel();
		this.label2 = new JLabel();
		
		this.bVer = new JButton();
		this.bEnt = new JButton();
		
		
		
	}
}
