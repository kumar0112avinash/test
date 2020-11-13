package com.xebia.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Item {
	private String itemName;
	private String itemType;
	private Double amount;
}
