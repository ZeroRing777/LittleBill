package gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.listener.ReturnListener;
import gui.listener.ToolBarListener;
import util.ChartUtil;
import util.ColorUtil;
import util.GUIUtil;

public class chartPanel extends JPanel {

	public static chartPanel instance=new chartPanel();
	
	public JButton Breturn=new JButton("返回主页");

	public JLabel l=new JLabel();
	
	private chartPanel() {
		GUIUtil.setColor(ColorUtil.blue,Breturn);
		JLabel lEmpty=new JLabel("    ");
		this.setLayout(new BorderLayout(20,20));
		this.add(Center(),BorderLayout.CENTER);
		this.add(South(),BorderLayout.SOUTH);
		this.add(lEmpty,BorderLayout.NORTH);
		addListener();
	}
	
	private JPanel South() {
		JPanel p=new JPanel();
		Font font=new Font("微软雅黑", Font.PLAIN, 20);
		Breturn.setFont(font);
		Breturn.setPreferredSize(new Dimension(200,50));
		p.add(Breturn);
		GUIUtil.showPanel(p,1,true);
		return p;
		
		
	}
	private JPanel Center() {
		
		JPanel p=new JPanel();
		Image i=ChartUtil.getImage(650,650);
		  ImageIcon icon= new ImageIcon(i);
	        l.setIcon(icon);
	        p.add(l);
	        GUIUtil.showPanel(p,1,true);
		return p; 
		
	}
	
	   private void addListener() {
	    	ReturnListener listener = new ReturnListener();
	    	Breturn.addActionListener(listener);
	   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// GUIUtil.showPanel(chartPanel.instance,1);
	}

}
