package com.kh.test.customer.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {
	
	private int customerNo;
	private String customerName;
	private String customerTel;
	private String customerAddress;
	
}
