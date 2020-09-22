package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import gui.panel.categoryPanel;
import gui.panel.configPanel;
import gui.panel.spendPanel;
import util.GUIUtil;
import gui.panel.MainPanel;
import gui.panel.recordPanel;
import gui.panel.chartPanel;
 



public class ToolBarListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		   MainPanel p = MainPanel.instance;
	        JButton b = (JButton) e.getSource();
	        if (b == p.bReport)   {
	       GUIUtil.showPanel(p, 1,false);
	       GUIUtil.showPanel(chartPanel.instance, 1,true);
	   
	       
	         }
	     
		   
		
	}

}
