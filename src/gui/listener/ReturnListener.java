package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import gui.panel.categoryPanel;
import gui.panel.configPanel;
import gui.panel.spendPanel;
import util.GUIUtil;
import gui.panel.MainPanel;
import gui.panel.recordPanel;
import gui.panel.chartPanel;
 

public class ReturnListener implements ActionListener {

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
		 if(b==chp.Breturn)  
			 {
			 GUIUtil.showPanel(chp,1,false);
			 GUIUtil.showPanel(mp, 1,true);
			 }
		 if(b==cap.bReturn)  
		 {
		 GUIUtil.showPanel(cap,1,false);
		 GUIUtil.showPanel(mp, 1,true);
		 }
		 if(b==cop.bReturn)  
		 {
		 GUIUtil.showPanel(cop,1,false);
		 GUIUtil.showPanel(mp, 1,true);
		 }
		 if(b==sp.bReturn)  
		 {
		 GUIUtil.showPanel(sp,1,false);
		 GUIUtil.showPanel(mp, 1,true);
		 }
		 if(b==rp.bReturn)  
		 {
		 GUIUtil.showPanel(rp,1,false);
		 GUIUtil.showPanel(mp, 1,true);
		 }
	}
	
	
	
	
}