package gui.panel;

public class SpendPage {
	
	public String MonthSpend;
	
	public String TodaySpend;
	
	public String AllSpend;
	
	public String MonthAvgSpend;
	
	public String MDayAvgSpend;
	
	public String MonthLeft;
	
	public String MonthLeftDay;
	
	public String DayAvgLeft;
	
	

	public int Percentage;
	
	public boolean IsOverSpend=false;
	
	public SpendPage(float MonthSpend, float TodaySpend, float  AllSpend, 
			float MonthAvgSpend, float MDayAvgSpend, float MonthLeft, int MonthLeftDay, float DayAvgLeft, int Percentage)
	 {
        this.MonthSpend = "￥" + MonthSpend;
        this.TodaySpend = "￥" + TodaySpend;
        this.AllSpend="￥" + AllSpend;
        this.MonthAvgSpend="￥" + MonthAvgSpend;
        this.MDayAvgSpend="￥" + MDayAvgSpend;
        if(MonthLeft<0) { 
        	
        	IsOverSpend=true;
        }
        
        if(!IsOverSpend) {
        	
        	this.MonthLeft="￥"+MonthLeft;
        	this.DayAvgLeft="￥"+DayAvgLeft;
        	
        }
        else {

        	this.MonthLeft="超支"+(0-MonthLeft);
        	this.DayAvgLeft = "￥0";
        }
        this.MonthLeftDay=MonthLeftDay+"天";
        this.Percentage=Percentage;
        
	}
	
	
	
}
