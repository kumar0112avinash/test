package com.xebia.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xebia.SpringContext;
import com.xebia.bean.Item;
import com.xebia.bean.UserDetail;
import com.xebia.service.AffiliateRole;
import com.xebia.service.BillService;
import com.xebia.service.CustomerRole;
import com.xebia.service.EmployeeRole;
import com.xebia.service.GeneralRole;

public class BillUtility {

	private static List<UserDetail> userDetail=new ArrayList<>();
	private static List<Item> itemDetail=new ArrayList<>();
	private static Map<String,Double> discountDetail=new HashMap<>();
	public static BillService objectFactory(UserDetail userDetail) {
		return (userDetail.getRole().equals("employee"))?SpringContext.getBean(EmployeeRole.class):
			   (userDetail.getRole().equals("affiliate"))?SpringContext.getBean(AffiliateRole.class):
			   (userDetail.getRole().equals("customer") && checkDate(userDetail.getCreatedDate()))?SpringContext.getBean(CustomerRole.class):
				   SpringContext.getBean(GeneralRole.class);
	}
	
	public static void init() throws ParseException {
		userDetail.add(new UserDetail().setUserId(100).setUserName("Avinash").setRole("employee").setCreatedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2020")));
		userDetail.add(new UserDetail().setUserId(101).setUserName("Sejal").setRole("affiliate").setCreatedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2020")));
		userDetail.add(new UserDetail().setUserId(102).setUserName("Rakesh").setRole("customer").setCreatedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2020")));
		userDetail.add(new UserDetail().setUserId(103).setUserName("Alok").setRole("customer").setCreatedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/10/2019")));
		userDetail.add(new UserDetail().setUserId(104).setUserName("Anshul").setRole("customer").setCreatedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2018")));
		userDetail.add(new UserDetail().setUserId(105).setUserName("Kapil").setRole("customer").setCreatedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2018")));
		
		itemDetail.add(new Item("Pen","stationary",100.00));
		itemDetail.add(new Item("Suger","groceries",200.00));
		itemDetail.add(new Item("Shirt","cloth",300.00));
		itemDetail.add(new Item("t-Shirt","cloth",500.00));
		
		discountDetail.put("customer",5.00);
		discountDetail.put("affiliate",10.00);
		discountDetail.put("employee",30.00);
	}
	public static List<UserDetail> getUserDetail() {
		return userDetail;
	}
	public static List<Item> getItemDetail() {
		return itemDetail;
	}
	public static Map<String, Double> getDiscountDetail() {
		return discountDetail;
	}
	
	public static Double getAmount(Double total,Double disc,Double percent) {
		return total-(disc*percent)/100;
	}

	private static boolean checkDate(Date date) {
        LocalDate twoYearAgo = LocalDate.now().plusMonths(-24);  
        LocalDate newDate = LocalDate.of(date.getYear()+1900, date.getMinutes()+1, date.getDate());            
        return newDate.isBefore(twoYearAgo);
    }
	
}
