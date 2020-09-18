package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class spendPanel extends JPanel{
	
	public static spendPanel instance=new spendPanel();
	
	public JLabel lMonthSpend=new JLabel("        本月消费");
	public JLabel lDaySpend=new JLabel("        当日消费");
	public JLabel lAllSpend=new JLabel("        累计消费");
	public JLabel lMonthAvgSpend=new JLabel("        月均消费");
	//public JLabel lDayAvgSpend=new JLabel("日均消费");
	public JLabel lMDayAvgSpend=new JLabel("    本月日均消费");
	public JLabel lMonthLeft=new JLabel("本月剩余");
	//public JLabel lAllLeft=new JLabel("总共剩余");
	public JLabel lMonthLeftDay=new JLabel("距离月末天数");
	public  JLabel lDayAvgLeft=new JLabel("本月日均可用");
	
	public JLabel vMonthSpend=new JLabel("        ￥2500\n");
	public JLabel vDaySpend=new JLabel("        ￥25\n");
	public JLabel vAllSpend=new JLabel("        ￥25000\n");
	public JLabel vMonthAvgSpend=new JLabel("        ￥2500");
	//public JLabel vDayAvgSpend=new JLabel("￥75");
	public JLabel vMDayAvgSpend=new JLabel("    ￥105\n");
	public JLabel vMonthLeft=new JLabel("￥3000\n");
	//public JLabel vAllLeft=new JLabel("￥10000");
	public JLabel vMonthLeftDay=new JLabel("30天\n");
	public  JLabel vDayAvgLeft=new JLabel("￥100\n");
	public JButton bReturn=new JButton("返回主页");
	
	  CircleProgressBar bar=new CircleProgressBar();;
	  
		public void paint(Graphics g) { 
			super.paint(g);
			
		
		}

		@Override  
        public void paintComponent(Graphics g) {  
		 super.paintComponent(g);
        }  
	  
	  
	  private spendPanel() {
		  this.setLayout(new BorderLayout());
		  bar.setBackgroundColor(ColorUtil.blue);
		  GUIUtil.showPanel(bar,0.8);
		  
	        GUIUtil.setColor(ColorUtil.gray, lMonthSpend, lDaySpend,lAllSpend,lMDayAvgSpend,lMonthLeft,lMonthLeftDay,lDayAvgLeft,lMonthAvgSpend);
	        		
	        GUIUtil.setColor(ColorUtil.blue, vMonthSpend, vDaySpend,vAllSpend,vMDayAvgSpend,vMonthLeft,vMonthLeftDay,vDayAvgLeft,bReturn,vMonthAvgSpend);
	        
	        this.add(South(),BorderLayout.SOUTH);
	        this.add(Center(),BorderLayout.CENTER);
	        bReturn.setPreferredSize(new Dimension(50,50));
	        bReturn.setFont(new Font("宋体", Font.PLAIN, 23));
	        this.add(bReturn,BorderLayout.NORTH);

	}
	  
	  
	
	  private JPanel South() {
		
		  JPanel p=new JPanel();
		  p.setLayout(new GridLayout(2,4));//行数之后可能增加
		  Font font=new Font("微软雅黑", Font.PLAIN, 20);
		  lMDayAvgSpend.setFont(font);
		  lMonthLeft.setFont(font);
		  lMonthLeftDay.setFont(font);
		  lDayAvgLeft.setFont(font);
		  vMDayAvgSpend.setFont(font);
		  vMonthLeft.setFont(font);
		  vMonthLeftDay.setFont(font);
		  vDayAvgLeft.setFont(font);
		  p.add(lMDayAvgSpend);
		  p.add(lMonthLeft);
		  p.add(lMonthLeftDay);
		  p.add(lDayAvgLeft);
		  p.add(vMDayAvgSpend);
		  p.add(vMonthLeft);
		  p.add(vMonthLeftDay);
		  p.add(vDayAvgLeft);
		//  GUIUtil.setColor(ColorUtil.backgroundColor,p);
	
		  
		  p.setPreferredSize(new Dimension(50,100));
		  GUIUtil.showPanel(p,1);
		  return p;
		  
	  }
	  
	  private JPanel Center() {
		  JPanel p=new JPanel();
		//  bar.setPreferredSize(new Dimension(100,50));
		  p.setLayout(new BorderLayout());
		  p.add(bar,BorderLayout.CENTER);
		 p.add(West(),BorderLayout.WEST);
		  GUIUtil.showPanel(p,1);
		  return p;
		  
		  
		  
	  }
	  
	  private JPanel West() {
		  Font font=new Font("微软雅黑", Font.PLAIN, 18);
		  JPanel p=new JPanel();
		  p.setLayout(new GridLayout(8,1));
		  //p.add(bReturn);
		  lMonthSpend.setFont(font);
		  vMonthSpend.setFont(font);
		  lDaySpend.setFont(font);
		  vDaySpend.setFont(font);
		  lAllSpend.setFont(font);
		  vAllSpend.setFont(font);
		  lMonthAvgSpend.setFont(font);
		  vMonthAvgSpend.setFont(font);
		  p.add(lMonthSpend);
		  p.add(vMonthSpend);
		  p.add(lDaySpend);
		  p.add(vDaySpend);
		  p.add(lAllSpend);
		  p.add(vAllSpend);
		  p.add(lMonthAvgSpend);
		  p.add(vMonthAvgSpend);
		  p.setPreferredSize(new Dimension(200,200));
		  GUIUtil.showPanel(p,1);
		  return p;
		  
	  }
	 

	  
	  public static void main(String[] args) {
	         
	        GUIUtil.showPanel(spendPanel.instance,1);
	    }

}
