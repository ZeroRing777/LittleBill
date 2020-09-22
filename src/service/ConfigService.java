package service;

import dao.ConfigDAO;
import entity.Config;

public class ConfigService {
	
	    public static final String budget = "budget";
	    public static final String mysqlPath = "mysqlPath";
	    public static final String default_budget = "1500";
	    static ConfigDAO dao=new ConfigDAO();
	    static {init();
	   
	    }
	    
	    
	    public static void init() {
	    	
	    	init(budget,default_budget);
	    	init(mysqlPath,"");
	    	
	    }
	    private static void init(String key,String value) {
	    	
	    	
	    	Config config=dao.getByKey(key);
	    	if(config==null) {
	    		
	    		Config c=new Config();
	    		c.setKey(key);
	    		c.setValue(value);
	    		dao.add(c);
	    	}
	    	 //System.out.println("初始值是： "+config.getValue());
			 // System.out.println("初始键是： " +config.getKey());
	    }
	    
	  public String get(String key){
		  Config config=dao.getByKey(key);
		  return config.getValue();
		  
	  }
	  
	  public Config update(String key, String value) {
		  
		  Config config=dao.getByKey(key);
		  config.setValue(value);
		  dao.update(config);
		 // System.out.println("更新值是： "+config.getValue());
		 // System.out.println("更新键是： " +config.getKey());
		  return config;
	  }
	  
	    public float getFloatBudget() {
	        return Float.parseFloat(get(budget));
	    }
	

}
