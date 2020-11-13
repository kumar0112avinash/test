package com.xebia.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.xebia.bean.BillDetail;

@JsonTest
@SpringBootTest
@RunWith(SpringRunner.class)
public class BillDetailTest {
    
	@Autowired 
	private JacksonTester < BillDetail > json;
	private static final Double total = 10.00;
	private static final Double discountAmount = 10.00;
	private static final String discount = "30.00%";
	private static final Double SubTotal = 7.00;
	private static final String JSON_TO_DESERIALIZE = "{"
			+ "\"total\":\""+total+"\","
			+ "\"discountAmount\":\""+discountAmount+"\","
			+ "\"discount\":\""+discount+"\","
			+ "\"subTotal\":\"" +SubTotal+"\"}";
	    
	    @Test
	    public void getTotal() throws IOException {
	        assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getTotal()).isEqualTo(total);
	    }
	    @Test
	    public void getDiscountAmount() throws IOException {
	        assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getDiscountAmount()).isEqualTo(discountAmount);
	    }
	    
	    @Test
	    public void getDiscount() throws IOException {
	        assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getDiscount()).isEqualTo(discount);
	    }
	    @Test
	    public void getSubTotal() throws IOException {
	        assertThat(this.json.parseObject(JSON_TO_DESERIALIZE).getSubTotal()).isEqualTo(SubTotal);
	    }
}
