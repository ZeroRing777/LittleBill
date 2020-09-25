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
		MainPanel mp=MainPanel.instance;
		chartPanel chp =chartPanel.instance;
		categoryPanel cap=categoryPanel.instance;
		configPanel cop=configPanel.instance;
		spendPanel sp=spendPanel.instance;
		recordPanel rp=recordPanel.instance;
	       JButton b = (JButton) e.getSource();
	       if (b == mp.bReport)   {
	       GUIUtil.showPanel(mp, 1,false);
	       chp.updateData();
	       GUIUtil.showPanel(chp,1 ,true);
	      
	             }
	        if (b == mp.bCategory)   {
	 	       GUIUtil.showPanel(mp, 1,false);
	 	      cap.updateData();
	 	       GUIUtil.showPanel(cap,1 ,true);
	 	       
	 	         }
	        if (b == mp.bConfig)   {
		 	       GUIUtil.showPanel(mp, 1,false);
		 	      cop.updateData();
		 	       GUIUtil.showPanel(cop,1 ,true);
		 	     }
	        if (b == mp.bSpend)   {
		 	       GUIUtil.showPanel(mp, 1,false);
		 	       sp.updateData();
		 	       GUIUtil.showPanel(sp,1 ,true);
		 	     }
	   
	        if (b == mp.bRecord)   {
		 	       GUIUtil.showPanel(mp, 1,false);
		 	       rp.updateData();
		 	       GUIUtil.showPanel(rp,1 ,true);
		 	     }
		   
		
	}

}
