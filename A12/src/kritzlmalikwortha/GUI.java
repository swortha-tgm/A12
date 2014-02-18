package kritzlmalikwortha;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Die GUI für das Verschlüsselungsprogramm wid hier erstellt!
 * @author Simon Wortha
 * @version 18.02.2014
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
	private JPanel pTop;
	private JPanel pBot;
	private JPanel pCenter;
	private Border border;
	private Controller controller;
	/**
	 * @param c 
	 * 
	 */
	public GUI(Controller c) {
		super("Das sneaky Verschlüsselungsprogramm");
		this.controller = c;
		
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 400);
		
		this.eingText = new JTextArea("Hier den zu Ver/Ent-schlüsselten Text angeben");
		this.ausgText = new JTextArea("Ausgabefeld");
		this.border = LineBorder.createBlackLineBorder();
		eingText.setBorder(border);
		ausgText.setBorder(border);
		
		this.verSch = new JTextField();
		
		this.label1 = new JLabel("Verschlüsselungsmethode:");
		this.label2 = new JLabel("Geheimalphabet:");
		
		this.bVer = new JButton("Verschlüsseln");
		this.bEnt = new JButton("Entschlüsseln");
		
		String ddWerte[] = {"Substitution", "Shift", "Keyword"};
		this.dropdown = new JComboBox<String>(ddWerte);
		
		this.pTop = new JPanel();
		this.pBot = new JPanel();
		this.pCenter = new JPanel();
		
		pTop.setLayout(new GridLayout(2, 2));
		pTop.add(label1);
		pTop.add(dropdown);
		pTop.add(label2);
		pTop.add(verSch);
		
		pBot.setLayout(new GridLayout(1, 2));
		pBot.add(bVer);
		pBot.add(bEnt);
		
		pCenter.setLayout(new GridLayout(1, 2));
		pCenter.add(eingText);
		pCenter.add(ausgText);
		
		this.add(pTop, BorderLayout.NORTH);
		this.add(pCenter, BorderLayout.CENTER);
		this.add(pBot, BorderLayout.SOUTH);
		
		bVer.addActionListener(controller);
		bEnt.addActionListener(controller);
		dropdown.addActionListener(controller);
		
		this.setVisible(true);
	}
	/**
	 * ActionListener
	 * @param e
	 * @return on gedrückt
	 */
	public boolean buttonVerPressed(ActionEvent e) {
		if (e.getSource() == this.bVer) return true;
		return false;
	}
	/**
	 * ActionListener
	 * @param e
	 * @return ob gedrückt
	 */
	public boolean buttonEntPressed(ActionEvent e) {
		if (e.getSource() == this.bEnt) return true;
		return false;
	}
	/**
	 * @param e
	 * @return ob Werte verändert
	 */
	public boolean dropdownPressed(ActionEvent e) {
		if (e.getSource() == this.dropdown) return true;
		return false;
	}
	/**
	 * @return gibt die Verschiebung bzw wie Verschlüsselt werden soll an
	 */
	public String getVerSch() {
		return this.verSch.getText();
	}
	/**
	 * @return gibt den Text zurück der sich in der Textarea befindet
	 */
	public String getEingabe() {
		return this.eingText.getText();
	}
	/**
	 * @param neu Es soll der neue bzw. der verschlüsselte oder entschlüsselte Text übergeben werden  
	 */
	public void setAusgabe(String neu) {
		this.ausgText.setText(neu);
	}
	/**
	 * @return gibt den Ausgewählten Wert der Dropdown-Liste an
	 */
	public int getSelected() {
		return this.dropdown.getSelectedIndex();
	}
	/**
	 * 
	 */
	public void setLabel() {
		//String s = this.getSelected();
		if(this.getSelected() == 0) this.label2.setText("Geheimalphabet:");
		if(this.getSelected() == 1) this.label2.setText("Shiftvalue:");
		if(this.getSelected() == 2) this.label2.setText("Keyword:");
	}
}