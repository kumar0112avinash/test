package com.xebia.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BillDetail {

	private Double total;
	private Double discountAmount;
	private String discount;
	private Double SubTotal;


}
