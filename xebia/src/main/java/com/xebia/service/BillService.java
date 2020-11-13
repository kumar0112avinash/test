package com.xebia.service;

import java.util.List;

import com.xebia.bean.BillDetail;
import com.xebia.bean.Item;

public interface BillService {
	
	BillDetail getBill(List<Item> itemList, String role);
	

}
