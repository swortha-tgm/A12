package kritzlmalikwortha.test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import kritzlmalikwortha.Controller;
import kritzlmalikwortha.GUI;

import org.junit.Test;

public class TestGUI {

	@Test
	public void testButtonVerPressed() {
		GUI g = new GUI(new Controller());
		JButton bVer = new JButton("Verschlüsseln");
		ActionEvent a = new ActionEvent(bVer,1,null);
		assertTrue(g.buttonVerPressed(a));
		
	}

}
