package service;

import java.util.Date;
import java.util.List;

import dao.RecordDAO;
import entity.Record;
import gui.panel.SpendPage;
import util.DateUtil;

public class SpendService {

	
	public SpendPage getSpendPage() {
		
		SpendPage sp=null;
			
	    RecordDAO dao=new RecordDAO();
	    
		List<Record> TodayRecords=dao.listToday();
		
		List<Record> MonthRecords=dao.listThisMonth();
		
		List<Record> AllRecords=dao.list();
		
		Date MaxDate=new Date();
		Date MinDate=new Date();
		Date tmp=new Date();
		if(!AllRecords.isEmpty()) {
			 for(Record record:AllRecords) {
				 Date date=record.getDate();
				 if(date.before(MinDate)) {
					 
					 tmp=date;
					 date=MinDate;
					 MinDate=tmp;
				 }
				 
				 if(date.after(MaxDate)) {
					 tmp=date;
					 date=MaxDate;
					 MaxDate=tmp;
				 }
			 }
				 

		}
		
		int MonthTotalDay= DateUtil.thisMonthTotalDay();
		System.out.println("本月一共有 "+MonthTotalDay);
		float MonthSpend = 0, TodaySpend = 0, AllSpend = 0, MonthAvgSpend = 0,MDayAvgSpend=0, MonthLeft = 0,DayAvgLeft=0;
		 int MonthLeftDay = 0, Percentage=0;
		
		 float budget= new ConfigService().getFloatBudget();
		 
		 for(Record record: MonthRecords) {
			 
			 MonthSpend+=record.getSpend();
		 }
		 
		 for(Record record:TodayRecords) {
			 
			 TodaySpend+= record.getSpend();
		 }
		 
		 for(Record record:AllRecords) {
			 AllSpend+=record.getSpend();
		 }
		 
		 
		
		 sp=new SpendPage(MonthSpend,TodaySpend, AllSpend,MonthAvgSpend,MDayAvgSpend,MonthLeft,MonthLeftDay,DayAvgLeft,Percentage);
		return sp;
		
	}
}
