package gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Category;
import gui.listener.CategoryListener;
import gui.listener.ReturnListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class categoryPanel extends WorkingPanel {
	
	
	
	public static categoryPanel instance=new categoryPanel();
	
	 public JButton bAdd = new JButton("新增");
	    public JButton bEdit = new JButton("编辑");
	    public  JButton bDelete = new JButton("删除");
	    public  JButton bReturn=new JButton("返回主页");
	    String Names[] = new String[]{"分类名称","消费次数"};
	    public CategoryTableModel ctm = new CategoryTableModel();
	    public JTable t =new JTable(ctm);
	     
	    private categoryPanel() {
	    	GUIUtil.setColor(ColorUtil.blue, bAdd,bEdit,bDelete,bReturn);
	    	this.setLayout(new BorderLayout(100,100));
	    	this.add(South(),BorderLayout.SOUTH);
           
            this.add(Center(),BorderLayout.CENTER);
            this.add(North(),BorderLayout.NORTH);
            addListener();
            updateData();
	    	
	    }
	    
	    
	    private  JPanel South() {
	    	Font font=new Font("微软雅黑", Font.PLAIN, 20);
	    	JPanel p=new JPanel();
	    	bAdd.setPreferredSize(new Dimension(100,50));
	    	bAdd.setFont(font);
	     	bEdit.setPreferredSize(new Dimension(100,50));
	    	bEdit.setFont(font);
	     	bDelete.setPreferredSize(new Dimension(100,50));
	    	bDelete.setFont(font);
	    	p.add(bAdd);
	    	p.add(bEdit);
	    	p.add(bDelete);
	    	//p.add(bReturn);
	    	FlowLayout fl=new FlowLayout();
			  fl.setHgap(100);
			  p.setLayout(fl);
	    	 GUIUtil.showPanel(p,1,true);
	    	return p;
	    }
	    
	    private JPanel Center() {
	    	JPanel p=new JPanel();
	    	 JScrollPane sp =new JScrollPane(t);
	    	sp.setAlignmentX(100);
	    	sp.setAlignmentY(100);
	    	sp.setBounds(sp.getX(), sp.getY(), sp.getWidth()*2, sp.getHeight()*2);
	    	 p.add(sp);
	    	 GUIUtil.showPanel(p,1,true);
	    	return p;
	    }
	
	    private JPanel North() {
	    	JPanel p=new JPanel();
	    	Font font=new Font("微软雅黑", Font.PLAIN, 20);
	    	bReturn.setPreferredSize(new Dimension(200,50));
	    	bReturn.setFont(font);
	    	p.add(bReturn);
	    	GUIUtil.showPanel(p,1,true);
	    	return p;
	    	
	    }
	    
	    public void addListener() {
	    	ReturnListener listener = new ReturnListener();
	    	bReturn.addActionListener(listener);
	    	CategoryListener l=new CategoryListener();
	    	bAdd.addActionListener(l);
	    	bEdit.addActionListener(l);
	    	bDelete.addActionListener(l);
	   }
	    
	    public Category getSelectedItem() {
	    	int index=t.getSelectedRow();
	    	Category c=ctm.cs.get(index);
	    	return c;
	    	
	    }
	    
	    public void updateData() {
	    	
	    	ctm.cs=new CategoryService().list();
	    	t.updateUI();
	    	t.getSelectionModel().setSelectionInterval(0, 0);
	    	
	    	if(0==ctm.cs.size()) {
	    		Category c=new Category();
				c.setName("暂无分类");
			    ctm.cs.add(c);
	    		bEdit.setEnabled(false);
	    		bDelete.setEnabled(false);
	    		
	    	}
	    
	    	else
	    	{
	    		bEdit.setEnabled(true);
	    		bDelete.setEnabled(true);
	    	}
	    	recordPanel.instance.updateData();
	    }
	    
	    public static void main(String[] args) {
	         
	      //  GUIUtil.showPanel(categoryPanel.instance,1);
	    }


	
}
