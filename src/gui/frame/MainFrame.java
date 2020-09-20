package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;
import util.GUIUtil;

public class MainFrame extends JFrame{
	
	
	public static MainFrame instance=new MainFrame();
	
	
	private MainFrame() {
		
		this.setSize(800,800);
		this.setTitle("一本小账单");
		this.setContentPane(MainPanel.instance);
		//this.add(MainPanel.instance);
		this.setLocationRelativeTo(null);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		instance.setVisible(true);
		 GUIUtil.showPanel(MainPanel.instance, 1);
	
	}

}
