package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.panel.configPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener {

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		configPanel p = configPanel.instance;
        if(!GUIUtil.checkNumber(p.tfBudget, "本月预算"))
            return;
        String mysqlPath =p.tfMysqlPath.getText();
        if(0!=mysqlPath.length()){
            File commandFileForMac = new File(mysqlPath,"bin/mysql");
            File commandFileForWin=new File(mysqlPath,"mysql.exe");
            if(!commandFileForMac.exists()&&!commandFileForWin.exists()){
                JOptionPane.showMessageDialog(p, "Mysql路径不正确");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }
         
        ConfigService cs= new ConfigService();
        cs.update(ConfigService.budget,p.tfBudget.getText());
        cs.update(ConfigService.mysqlPath,mysqlPath);
         
        JOptionPane.showMessageDialog(p, "设置修改成功");
		
		
	}

}
