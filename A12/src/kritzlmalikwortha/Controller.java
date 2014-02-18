package kritzlmalikwortha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * ActionListener
 * @author Simon Wortha
 *@version 17.02.2014
 */
public class Controller implements ActionListener {
	private GUI g;
	private Cipher c;
	private String s;
	/**
	 * 
	 */
	public Controller() {
		g = new GUI(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(g.dropdownPressed(e)) {
			g.setLabel();
		}
		try {
		if(g.buttonVerPressed(e)){
			switch(g.getSelected()){
			case 0:
				c = new SubstitutionCipher(g.getVerSch());
				s = c.encrypt(g.getEingabe());
				g.setAusgabe(s);
				break;
			case 1:
				c = new ShiftCipher(Integer.parseInt(g.getVerSch()));
				s = c.encrypt(g.getEingabe());
				g.setAusgabe(s);
				break;
			case 2: 
				c = new KeywordCipher(g.getVerSch());
				s = c.encrypt(g.getEingabe());
				g.setAusgabe(s);
			}
		}
		if(g.buttonEntPressed(e)){
			switch(g.getSelected()){
			case 0:
				c = new SubstitutionCipher(g.getVerSch());
				s = c.decrypt(g.getEingabe());
				g.setAusgabe(s);
				break;
			case 1:
				c = new ShiftCipher(Integer.parseInt(g.getVerSch()));
				s = c.decrypt(g.getEingabe());
				g.setAusgabe(s);
				break;
			case 2: 
				c = new KeywordCipher(g.getVerSch());
				s = c.decrypt(g.getEingabe());
				g.setAusgabe(s);
			}
		}
		} catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

}
