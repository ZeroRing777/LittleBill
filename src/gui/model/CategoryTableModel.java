package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Category;
import gui.panel.categoryPanel;
import service.CategoryService;

public class CategoryTableModel implements TableModel{

	
	String [] Names=new String[] {"分类名称","消费次数"};

	 public List<Category> cs = new CategoryService().list();

	
	public  CategoryTableModel(){
	/*	if(cs.isEmpty()) { 

			Category c=new Category();
			c.setName("暂无分类");
		    cs.add(c);

    	
    		
		}*/
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return cs.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Names.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return Names[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Category c=cs.get(rowIndex);
		 if(0==columnIndex)
	            return c.getName();
	        if(1==columnIndex)
	            return c.getRecordNumber();
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
