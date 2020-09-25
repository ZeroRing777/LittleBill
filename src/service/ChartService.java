package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

public class ChartService {

	public float getDaySpend(Date d, List<Record> MonthData) {
		
		float daySpend=0;
		
		for(Record record: MonthData) {
			
			if(record.getDate().equals(d)) {
				
				daySpend+=record.getSpend();
			}
			
		}		
		return daySpend;
	}
	
	public List<Record> MonthRecords(){
		
		RecordDAO dao=new RecordDAO();
		List<Record> monthData=dao.listThisMonth();
		List<Record> result=new ArrayList<>();
		Date monthBegin=DateUtil.monthBegin();
		int totalDay=DateUtil.thisMonthTotalDay();
		Calendar c=Calendar.getInstance();
		for(int i=0;i<totalDay;i++) {
			Record r=new Record();
			c.setTime(monthBegin);
			c.add(Calendar.DATE, i);
			Date eachDay=c.getTime();
			float daySpend=getDaySpend(eachDay,monthData);
			r.setSpend(daySpend);
			result.add(r);
			
		}
		
		return result;
		
		
	}
}
