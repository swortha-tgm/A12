package kritzlmalikwortha;

import javax.swing.*;

/**
 * Die GUI f�r das Verschl�sselungsprogramm wid hier erstellt!
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
	private JLabel label;
	private JButton bVer;
	private JButton bEnt;
	private JComboBox<String> dropdown;
	private Controller controller;
	/**
	 * @param c 
	 * 
	 */
	public GUI(Controller c) {
		super("Das sneaky Verschl�sselungsprogramm");
		this.controller = c;
		
		
		
	}
}
