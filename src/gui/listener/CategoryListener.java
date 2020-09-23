package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.categoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		List<Category> cs= new CategoryService().list();
	    categoryPanel p = categoryPanel.instance;
	    
        JButton b = (JButton) e.getSource();
        
        if(b==p.bAdd) {
        	
        	 String name = JOptionPane.showInputDialog(null);
             if (0 == name.length()) {
                 JOptionPane.showMessageDialog(p, "分类名称不能为空");
                 return;
             }
             for(Category c:cs) {
            	 if(c.getName().contentEquals(name)) {
            		 JOptionPane.showMessageDialog(p, "该分类名称已经存在");
                     return;
            	 }
             }
  
             new CategoryService().add(name);
            // System.out.println("输入的名称是: "+name);
             p.updateData();
  
        }
      
        
       if(b==p.bDelete) {
    	   Category c=p.getSelectedItem();
    	   if(0!=c.getRecordNumber()) {
    		   JOptionPane.showMessageDialog(p, "本分类下有消费记录存在，不能删除");
    		   return;
    	   }
    	   if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确认要删除？"))
               return;

           int id = c.getId();
           new CategoryService().delete(id);
           p.updateData();
    	   
       }
       if(b==p.bEdit) {
    	   
    	   Category c=p.getSelectedItem();
    	   int id=c.getId();
    	   String name = JOptionPane.showInputDialog("修改分类名称", c.getName());
           if (0 == name.length()) {
               JOptionPane.showMessageDialog(p, "分类名称不能为空");
               return;
           }
           for(Category ca:cs) {
          	 if(ca.getName().contentEquals(name)) {
          		 JOptionPane.showMessageDialog(p, "该分类名称已经存在");
                   return;
          	 }
           }
           new CategoryService().update(id, name);
           p.updateData(); 
    	   
       }
        
       
	}

}
