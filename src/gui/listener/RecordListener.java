package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.categoryPanel;
import gui.panel.recordPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		recordPanel p=recordPanel.instance;
		if(0==p.cbModel.cs.size()) {
			  JOptionPane.showMessageDialog(p, "暂无消费分类，无法添加，请先增加消费分类");
			  GUIUtil.showPanel(recordPanel.instance,1,false);
			  GUIUtil.showPanel(categoryPanel.instance, 1,true);
				 return;
			
		}
		
		if(!GUIUtil.checkZero(p.tfSpend,"花费金额"))
		
          return;
		
		 float spend = Float.parseFloat(p.tfSpend.getText());
	        Category c = p.getSelectedCategory();
	        String comment = p.tfComment.getText();
	        Date d = p.datepick.getDate();
	        new RecordService().add(spend, c, comment, d);
	        JOptionPane.showMessageDialog(p, "添加成功");
		
	}

}
