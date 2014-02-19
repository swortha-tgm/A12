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
	private ShiftCipher sic;
	private KeywordCipher kc;
	private SubstitutionCipher suc;
	private String s; 
	/**
	 * 
	 */
	public Controller() {
		sic = new ShiftCipher(0);
		kc = new KeywordCipher("Default");
		suc= new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		//die GUI wird als letztes erstellt damit keine Buttons gedrückt werden können bevor die Cipher erstellet wurden
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
				this.suc.setSecretAlphabet(g.getVerSch());
				s = suc.encrypt(g.getEingabe());
				g.setAusgabe(s);
				break;
			case 1:
				this.sic.setShiftAmount(Integer.parseInt(g.getVerSch()));
				s = sic.encrypt(g.getEingabe());
				g.setAusgabe(s);
				break;
			case 2: 
				this.kc.setKeyword(g.getVerSch());
				s = kc.encrypt(g.getEingabe());
				g.setAusgabe(s);
			}
		}
		if(g.buttonEntPressed(e)){
			switch(g.getSelected()){
			case 0:
				this.suc.setSecretAlphabet(g.getVerSch());
				s = suc.decrypt(g.getEingabe());
				g.setAusgabe(s);
				break;
			case 1:
				this.sic.setShiftAmount(Integer.parseInt(g.getVerSch()));
				s = sic.decrypt(g.getEingabe());
				g.setAusgabe(s);
				break;
			case 2: 
				this.kc.setKeyword(g.getVerSch());
				s = kc.decrypt(g.getEingabe());
				g.setAusgabe(s);
			}
		}
		} catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

}
