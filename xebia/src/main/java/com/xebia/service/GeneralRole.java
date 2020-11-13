package com.xebia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xebia.bean.BillDetail;
import com.xebia.bean.Item;

@Service
public class GeneralRole implements BillService {

	@Override
	public BillDetail getBill(List<Item> itemList, String role) {
		Double total=0.00;
		Double discountApplicableAmount=0.00;
		Double subTotal=0.00;
		for(Item item:itemList){
			if(item.getItemType().equals("groceries")){
				total=total+item.getAmount();
			}else {
				total=total+item.getAmount();
				discountApplicableAmount=discountApplicableAmount+item.getAmount();
			}
		}
		Integer discAmount=(((int) (discountApplicableAmount/100))*5);
		subTotal=total-(double)discAmount;
		
		
		BillDetail billDetail=new BillDetail();
		billDetail.setDiscount(discAmount+"$");
		billDetail.setDiscountAmount(discountApplicableAmount);
		billDetail.setTotal(total);
		billDetail.setSubTotal(subTotal);
		return billDetail;
	}
	

}
