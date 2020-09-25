package gui.panel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.BackUpListener;
import gui.listener.RecoverListener;
import gui.listener.ToolBarListener;

import javax.swing.JLabel;

import util.CenterPanel;
import util.ColorUtil;
import util.GUIUtil;
import java.awt.Font;

public class MainPanel extends JPanel{
	
	
	
	public static MainPanel instance=new MainPanel();
	
	    public JToolBar tb = new JToolBar();
	    public JButton bSpend = new JButton();
	    public JButton bRecord = new JButton();
	    public JButton bCategory = new JButton();
	    public JButton bReport = new JButton();
	    public JButton bConfig = new JButton();
	    public JButton bBackup = new JButton();
	    public JButton bRecover = new JButton();
	    public JLabel  lWelcome=new JLabel();  
	   // public CenterPanel WorkingPanel=new CenterPanel(0.8);
	    public JLabel lName=new JLabel();
		public void paint(Graphics g) { 
			super.paint(g);
			
		
		}

		@Override  
        public void paintComponent(Graphics g) {  
		 super.paintComponent(g);
        }  
		 
	    
       
	
	    private MainPanel() {
	    	
	    /*	this.getRootPane().add(MainPanel.instance);
	    	MainPanel.instance.setBackground(ColorUtil.blue);*/
	    	
	    	  GUIUtil.setColor(ColorUtil.blue, tb);
	    	  GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
	          GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
	          GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
	          GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
	          GUIUtil.setImageIcon(bConfig, "config.png", "设置");
	          GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
	          GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
	   
	          JPanel p=new JPanel();
	          tb.add(bSpend);
	      
	          tb.add(bRecord);
	          tb.add(bCategory);
	          tb.add(bReport);
	          tb.add(bConfig);
	          tb.add(bBackup);
	          tb.add(bRecover);
	          tb.setFloatable(false);
	         
	          ImageIcon ibook=new ImageIcon("/Users/zeroring/ab/book.jpg");
	          lWelcome.setIcon(ibook);
	         lWelcome.setBounds(400, 400, 400, 400);
	         lName.setText("    一本小账单    ");
	         lName.setFont(new Font("宋体", Font.PLAIN, 32));
	         GUIUtil.setColor(ColorUtil.blue, lName);
	          setLayout(new BorderLayout());
	          add(tb, BorderLayout.SOUTH);
	          add(lWelcome,BorderLayout.CENTER);
	          add(lName,BorderLayout.WEST);
	     //   add(WorkingPanel, BorderLayout.CENTER); 
	          addListener();
	    }
	  /*  public static void main(String[] args) {
	    	
	     //   GUIUtil.showPanel(MainPanel.instance, 1);
	        
	    }*/
	    
	    public void addListener() {
	    	ToolBarListener listener = new ToolBarListener();
	    	bReport.addActionListener(listener);
	    	bSpend.addActionListener(listener);
	    	bCategory.addActionListener(listener);
	    	bConfig.addActionListener(listener);
	    	bRecord.addActionListener(listener);
	    	BackUpListener b=new BackUpListener();
	    	bBackup.addActionListener(b);
	    	RecoverListener r=new RecoverListener();
	    	bRecover.addActionListener(r);
	    }

}
