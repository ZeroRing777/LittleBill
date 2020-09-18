package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class spendPanel extends JPanel{
	
	public static spendPanel instance=new spendPanel();
	
	public JLabel lMonthSpend=new JLabel("本月消费");
	public JLabel lDaySpend=new JLabel("当日消费");
	public JLabel lAllSpend=new JLabel("累计消费");
	//public JLabel lMonthAvgSpend=new JLabel("月均消费");
	//public JLabel lDayAvgSpend=new JLabel("日均消费");
	public JLabel lMDayAvgSpend=new JLabel("本月日均消费");
	public JLabel lMonthLeft=new JLabel("本月剩余");
	//public JLabel lAllLeft=new JLabel("总共剩余");
	public JLabel lMonthLeftDay=new JLabel("距离月末天数");
	public  JLabel lDayAvgLeft=new JLabel("本月日均可用");
	
	public JLabel vMonthSpend=new JLabel("￥2500");
	public JLabel vDaySpend=new JLabel("￥25");
	public JLabel vAllSpend=new JLabel("￥25000");
	//public JLabel vMonthAvgSpend=new JLabel("￥2500");
	//public JLabel vDayAvgSpend=new JLabel("￥75");
	public JLabel vMDayAvgSpend=new JLabel("￥105");
	public JLabel vMonthLeft=new JLabel("￥3000");
	//public JLabel vAllLeft=new JLabel("￥10000");
	public JLabel vMonthLeftDay=new JLabel("30天");
	public  JLabel vDayAvgLeft=new JLabel("￥100");
	
	  CircleProgressBar bar=new CircleProgressBar();;
	  
	  private spendPanel() {
		  this.setLayout(new BorderLayout());
		  bar.setBackgroundColor(ColorUtil.blue);
		  
	        GUIUtil.setColor(ColorUtil.gray, lMonthSpend, lDaySpend,lAllSpend,lMDayAvgSpend,lMonthLeft,lMonthLeftDay,lDayAvgLeft);
	        		
	        GUIUtil.setColor(ColorUtil.blue, vMonthSpend, vDaySpend,vAllSpend,vMDayAvgSpend,vMonthLeft,vMonthLeftDay,vDayAvgLeft);

	}
	
	  public static void main(String[] args) {
	         
	        GUIUtil.showPanel(spendPanel.instance,1);
	    }

}
