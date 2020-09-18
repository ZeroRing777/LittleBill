package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class CategoryTableModel implements TableModel{

	
	String [] Names=new String[] {"分类名称","消费次数"};
	List<String> cs=new ArrayList<String>();

	
	public  CategoryTableModel(){
		cs.add("餐饮");
		cs.add("交通");
		cs.add("住宿");
		cs.add("娱乐");
		
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
		 if(0==columnIndex)
	            return cs.get(rowIndex);
	        if(1==columnIndex)
	            return 0;
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
