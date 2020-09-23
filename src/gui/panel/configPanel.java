package gui.panel;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigListener;
import gui.listener.ReturnListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;
import entity.Config;
import dao.ConfigDAO;
public class configPanel extends WorkingPanel{
	
	
	Config config=new Config();
	ConfigDAO dao= new ConfigDAO();
	public static configPanel instance=new configPanel();
	
	JLabel lBudget = new JLabel("本月预算(￥)");
    public JTextField tfBudget = new JTextField(ConfigService.default_budget);
     
    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath = new JTextField("");
 
    JButton bSubmit = new JButton("确认");
    
    public JButton bReturn=new JButton("返回");
	
	private configPanel() {
		
		   GUIUtil.setColor(ColorUtil.blue, bSubmit,lBudget, lMysql,bReturn);
			this.setLayout(new BorderLayout(40,40));
			this.add(South(),BorderLayout.SOUTH);
			this.add(Center(),BorderLayout.CENTER);
			JLabel lNorth=new JLabel("   ");
			JLabel lWest=new JLabel("   ");
			JLabel lEast=new JLabel("   ");
			this.add(lNorth,BorderLayout.NORTH);
			this.add(lWest,BorderLayout.WEST);
			this.add(lEast,BorderLayout.EAST);
			addListener();
			updateData();
			/*config=dao.getByKey("budget");
			tfBudget.setText(config.getValue());
			config=dao.getByKey("mysqlPath");
			tfMysqlPath.setText(config.getValue());*/
		
		
	}
	
	
	private JPanel Center() {
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(4,1,40,40));
		Font font=new Font("微软雅黑", Font.PLAIN, 20);
		lBudget.setFont(font);
		lMysql.setFont(font);
		p.add(lBudget);
		p.add(tfBudget);
		p.add(lMysql);
		p.add(tfMysqlPath);
		p.add(tfMysqlPath);
		GUIUtil.showPanel(p,1,true);
		return p;
		
	}
	
	private JPanel South() {
		
		JPanel p=new JPanel();
		FlowLayout fl=new FlowLayout();
		  fl.setHgap(100);
		  p.setLayout(fl);
		Font font=new Font("微软雅黑", Font.PLAIN, 20);
		bSubmit.setFont(font);
		bReturn.setFont(font);
		bReturn.setPreferredSize(new Dimension(100,50));
		bSubmit.setPreferredSize(new Dimension(100,50));
		p.add(bReturn);
		p.add(bSubmit);
		GUIUtil.showPanel(p,1,true);
		
		
		return p;
	}
	
	 public void addListener() {
	    	ReturnListener listener = new ReturnListener();
	    	bReturn.addActionListener(listener);
	        ConfigListener l =new ConfigListener();
		    bSubmit.addActionListener(l);
		    
	   }
	 
	
	
	/*   public static void main(String[] args) {
	    //    GUIUtil.showPanel(configPanel.instance,1);
	    }*/


	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		   String budget = new ConfigService().get(ConfigService.budget);
	        String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
	        tfBudget.setText(budget);
	        tfMysqlPath.setText(mysqlPath);
	        tfBudget.grabFocus();
		
	}


	
}
