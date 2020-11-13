package com.xebia.test;

import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.xebia.BillCreate;
import com.xebia.bean.BillDetail;
import com.xebia.util.BillUtility;



@SpringBootTest
@RunWith(SpringRunner.class)
public class BillingTest {

	@InjectMocks
	BillCreate billCreate;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws URISyntaxException, ParseException {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.billCreate).build();
		BillUtility.init();
	}
	
	@Test
	public void test1() throws Exception {
		BillDetail billDetail=(BillDetail) billCreate.printBill(100,BillUtility.getItemDetail().subList(0, 1));
		assertTrue(billDetail.getDiscount().equals("30.0%"));
	}
	
	@Test
	public void test2() throws Exception {
		BillDetail billDetail=(BillDetail) billCreate.printBill(101,BillUtility.getItemDetail().subList(0, 2));
		assertTrue(billDetail.getDiscount().equals("10.0%"));
	}
	@Test
	public void test3() throws Exception {
		BillDetail billDetail=(BillDetail) billCreate.printBill(104,BillUtility.getItemDetail().subList(0, 3));
		assertTrue(billDetail.getDiscount().equals("5.0%"));
	}
	@Test
	public void test4() throws Exception {
		BillDetail billDetail=(BillDetail) billCreate.printBill(102,BillUtility.getItemDetail().subList(0, 4));
		assertTrue(billDetail.getDiscount().equals("45$"));
	}

	
}
