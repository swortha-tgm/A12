package kritzlmalikwortha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener
 * @author Simon Wortha
 *@version 17.02.2014
 */
public class Controller implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	private GUI g;
	/**
	 * 
	 */
	public Controller() {
		g = new GUI(this);
	}
	
	public static void main(String[] args) {
		Controller c = new Controller();
	}

}
