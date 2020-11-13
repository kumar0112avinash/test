package com.xebia.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xebia.bean.BillDetail;
import com.xebia.bean.Item;
import com.xebia.util.BillUtility;

@Service
public class AffiliateRole implements BillService {

	@Override
	public BillDetail getBill(List<Item> itemList, String role) {
		Double total=0.00;
		Double discountApplicableAmount=0.00;
		for(Item item:itemList){
			if(item.getItemType().equals("groceries")){
				total=total+item.getAmount();
			}else {
				total=total+item.getAmount();
				discountApplicableAmount=discountApplicableAmount+item.getAmount();
			}
		}
		Map<String, Double> discounts=BillUtility.getDiscountDetail();
		Double subTotal=BillUtility.getAmount(total,discountApplicableAmount, discounts.get(role));
		BillDetail billDetail=new BillDetail();
		billDetail.setDiscount(discounts.get(role)+"%");
		billDetail.setDiscountAmount(discountApplicableAmount);
		billDetail.setTotal(total);
		billDetail.setSubTotal(subTotal);
		return billDetail;
	}
	

}
