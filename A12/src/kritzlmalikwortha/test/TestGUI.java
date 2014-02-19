package kritzlmalikwortha.test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import kritzlmalikwortha.Controller;
import kritzlmalikwortha.GUI;

import org.junit.Test;

public class TestGUI{

	@Test
	public void testgetEingabe() {
		GUI g = new GUI(new Controller());
		assertEquals("Hier den zu Ver/Ent-schlüsselten Text angeben",g.getEingabe());
		
	}
	
	@Test
	public void testgetSelected(){
		GUI g = new GUI(new Controller());
		assertEquals(0,g.getSelected());
	}
	
	@Test
	public void testgetVersch(){
		GUI g = new GUI(new Controller());
		assertEquals("",g.getVerSch());
	}
	
	

}
