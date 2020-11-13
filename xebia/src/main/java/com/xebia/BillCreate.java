package com.xebia;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xebia.bean.BillDetail;
import com.xebia.bean.Item;
import com.xebia.bean.UserDetail;
import com.xebia.service.BillService;
import com.xebia.util.BillUtility;

@Service
public class BillCreate {
	
	private static BillService billService;
	
	public static Object printBill(Integer userId, List<Item> itemList) {
		UserDetail user=BillUtility.getUserDetail().stream()
		.filter(UserDetail->userId!=null && userId.equals(UserDetail.getUserId()))
		.findAny()
		.orElse(null);
		BillDetail billDetail;
		if(user==null) {
			return "User not found";
		}else if(itemList==null || itemList.isEmpty()){
			return "Please add item";
		}else {
			billService=BillUtility.objectFactory(user);
			billDetail=billService.getBill(itemList,user.getRole());
		}
		return billDetail;
	}
	
}
