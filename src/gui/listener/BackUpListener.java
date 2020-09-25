package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import gui.panel.MainPanel;
import gui.panel.configPanel;
import service.ConfigService;
import util.GUIUtil;
import util.MysqlUtil;

public class BackUpListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
        String mysqlPath= new ConfigService().get(ConfigService.mysqlPath);
        if(0==mysqlPath.length()){
        	   JOptionPane.showMessageDialog(MainPanel.instance, "备份前请事先配置mysql的路径");
        	   GUIUtil.showPanel(MainPanel.instance, 1,false);
        	   GUIUtil.showPanel(configPanel.instance, 1,true);
        	   return; 
        }
        JFileChooser fc=new JFileChooser();
        fc.setSelectedFile(new File("bill.sql"));
    /*    fc.setFileFilter(new FileFilter() {
             
        	 @Override
            public String getDescription() {
                return ".sql";
            }
             
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".sql");
            }
        });*/
        int returnVal =  fc.showSaveDialog(MainPanel.instance);
        File file = fc.getSelectedFile();
       // System.out.println(file);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
          //  System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql"))
                file = new File(file.getParent(),file.getName()+".sql");
          //  System.out.println(file);
             
           try {
               MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
               JOptionPane.showMessageDialog(MainPanel.instance, "备份成功,备份文件位于:\r\n"+file.getAbsolutePath());
           } catch (Exception e1) {
               e1.printStackTrace();
               JOptionPane.showMessageDialog(MainPanel.instance, "备份失败\r\n,错误:\r\n"+e1.getMessage());  
           }
             

	}
	}}


