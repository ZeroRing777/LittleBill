package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import gui.panel.MainPanel;
import gui.panel.configPanel;
import service.ConfigService;
import util.GUIUtil;
import util.MysqlUtil;

public class RecoverListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainPanel p=MainPanel.instance;
		String mysqlPath= new ConfigService().get(ConfigService.mysqlPath);
		   if(0==mysqlPath.length()){
        	   JOptionPane.showMessageDialog(MainPanel.instance, "恢复前请事先配置mysql的路径");
        	   GUIUtil.showPanel(p, 1,false);
        	   GUIUtil.showPanel(configPanel.instance, 1,true);
        	   return; 
        }
		   JFileChooser fc = new JFileChooser();
	       fc.setSelectedFile(new File("bill.sql"));
	       int returnVal =  fc.showOpenDialog(p);
	         File file = fc.getSelectedFile();
	        // System.out.println(file);
	         if (returnVal == JFileChooser.APPROVE_OPTION) {
	            try {
	                MysqlUtil.recover(mysqlPath,file.getAbsolutePath());
//	              MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
	                JOptionPane.showMessageDialog(p, "恢复成功");
	            } catch (Exception e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(p, "恢复失败\r\n,错误:\r\n"+e1.getMessage());  
	            }
	              
	         }     
	}

}
