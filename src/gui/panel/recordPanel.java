package gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
import gui.listener.RecordListener;
import gui.listener.ReturnListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class recordPanel extends WorkingPanel {
	
	public static recordPanel instance=new recordPanel();
	  JLabel lSpend=new JLabel("                花费(￥)");
	  JLabel lCategory = new JLabel("                分类");
	  JLabel lComment = new JLabel("                备注");
	  JLabel lDate = new JLabel("                日期");
	  public JButton bReturn=new JButton("返回");
	  JButton bSubmit=new JButton("提交");
	  JLabel lTitle=new JLabel("                ");
	  
	  public JTextField tfSpend = new JTextField("0");
	  public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	  public JComboBox<Category> cb=new JComboBox<>(cbModel);
	  public JTextField tfComment = new JTextField();
	  public JXDatePicker datepick = new JXDatePicker(new Date());
	  
	  private recordPanel() {
		  GUIUtil.setColor(ColorUtil.blue, lSpend,lCategory,lComment,lDate,bSubmit,bReturn,lTitle);
		  
		  Font font=new Font("微软雅黑", Font.PLAIN, 20);
		  lTitle.setFont(font);
		  JLabel lEast=new JLabel("   ");
		  this.setLayout(new BorderLayout(70,70));
		  this.add(Center(),BorderLayout.CENTER);
		  this.add(South(),BorderLayout.SOUTH);
		  this.add(lTitle,BorderLayout.NORTH);
		  this.add(lEast,BorderLayout.EAST);
		  addListener();
		  updateData();
	  }
	  
	  private JPanel South() {
		  Font font=new Font("微软雅黑", Font.PLAIN, 20);
		  JPanel p=new JPanel();
		  bReturn.setPreferredSize(new Dimension(100,50));
		  bSubmit.setPreferredSize(new Dimension(100,50));
		  bReturn.setFont(font);
		  bSubmit.setFont(font);
		  p.add(bReturn);
		  p.add(bSubmit);
		  FlowLayout fl=new FlowLayout();
		  fl.setHgap(100);
		  p.setLayout(fl);
		  GUIUtil.showPanel(p,1,true);
		  return p; 
		  
	  }
	  
	  private JPanel Center() {
		  
		  Font font=new Font("微软雅黑", Font.PLAIN, 20);
		  Dimension d=new Dimension(50,50);
		  lSpend.setFont(font);
		  lCategory.setFont(font);
		  lComment.setFont(font);
		  lDate.setFont(font);
		  tfSpend.setBounds(10, 10, 10, 10);
		  JPanel p=new JPanel();
		  p.setLayout(new GridLayout(4,2,40,100));
		   p.add(lSpend);
	       p.add(tfSpend);
	       p.add(lCategory);
	       p.add(cb);
	       p.add(lComment);
	       p.add(tfComment);
	       p.add(lDate);
	       p.add(datepick);
	      GUIUtil.showPanel(p,0.8,true);
		  return p;
		  
		  
	  }
	  
	  public void addListener() {
	    	ReturnListener listener = new ReturnListener();
	    	bReturn.addActionListener(listener);
	    	RecordListener l=new RecordListener();
	    	bSubmit.addActionListener(l);
	   }

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		cbModel.cs = new CategoryService().list();
        cb.updateUI();
        resetInput();
        tfSpend.grabFocus();
	}

	private void resetInput() {
		// TODO Auto-generated method stub
		 tfSpend.setText("0");
	        tfComment.setText("");
	        if(0!=cbModel.cs.size())
	            cb.setSelectedIndex(0);
	        datepick.setDate(new Date());
	}
	
	   public Category getSelectedCategory(){
	        return (Category) cb.getSelectedItem();
	    }
	 
	  
	/*  public static void main(String[] args) {
	         
	     //   GUIUtil.showPanel(recordPanel.instance,1);
	    }*/

	  
	

}
