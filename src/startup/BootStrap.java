package startup;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import util.GUIUtil;

public class BootStrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        try {
			SwingUtilities.invokeAndWait(new Runnable() {
			    @Override
			    public void run() {
			    	 
			        MainFrame.instance.setVisible(false);
			        GUIUtil.showPanel(MainPanel.instance, 1,true);
			    }
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
