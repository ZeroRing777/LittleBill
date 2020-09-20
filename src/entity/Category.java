package entity;

public class Category {
	
	private int id;
	private String name;
	private int recordNumber;
	
	public void setId(int id) {
		
		this.id=id;
	}
	public int getId() {
		
		return id;
	}
	
	public void seRecordNumber(int recordNumber) {
		
		this.recordNumber=recordNumber;
	}
	public int getRecordNumber() {
		
		return recordNumber;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}


}
