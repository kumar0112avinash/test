package com.xebia;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xebia.util.BillUtility;

@SpringBootApplication
public class Billing {
	
	@Autowired
	private static BillCreate billCreate;
	
	public static void main(String[] args) throws ParseException {
		
		SpringApplication.run(Billing.class, args);
		BillUtility.init();
		System.out.println("---------User Detail------------ ");
		BillUtility.getUserDetail().forEach(action->{
			System.out.println(action.getUserId()+ "  "+action.getUserName() +"  "+action.getRole() +"  "+action.getCreatedDate());
		});
		System.out.println();
		System.out.println("---------Item Detail------------ ");
		BillUtility.getItemDetail().forEach(action->{
			System.out.println(action.getItemName()+"  "+action.getItemType()+"  "+action.getAmount() );
		});
		System.out.println();
		System.out.println("-----------Output 0----------");
		System.out.println(billCreate.printBill(null,BillUtility.getItemDetail().subList(0, 0)));
		System.out.println("-----------Output 1----------");
		System.out.println(billCreate.printBill(100,null));
		System.out.println("-----------Output 2----------");
		System.out.println(billCreate.printBill(100,BillUtility.getItemDetail().subList(0, 1)));
		System.out.println("-----------Output 3----------");
		System.out.println(billCreate.printBill(101,BillUtility.getItemDetail().subList(0, 2)));
		System.out.println("-----------Output 4----------");
		System.out.println(billCreate.printBill(104,BillUtility.getItemDetail().subList(0, 3)));
		System.out.println("-----------Output 5 ----------");
		System.out.println(billCreate.printBill(102,BillUtility.getItemDetail().subList(0, 4)));
	}
	
}
