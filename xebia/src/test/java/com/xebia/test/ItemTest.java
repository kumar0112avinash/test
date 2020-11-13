package com.xebia.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.xebia.bean.Item;

@JsonTest
@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemTest {
    
	@Autowired 
	private JacksonTester < Item > json;
	private static final String itemName = "abc";
	private static final String itemType = "cloth";
	private static final Double amount = 7.00;
	private Item item;
	@Before
	public void setup() throws ParseException {
		item = new Item(itemName, itemType, amount);
	}
	
	@Test
	public void attributeNameSerializes() throws IOException {
		assertThat(this.json.write(item)).extractingJsonPathStringValue("@.itemName")
				.isEqualTo(itemName);
	}

	@Test
	public void userIdSerializes() throws IOException {
		assertThat(this.json.write(item)).extractingJsonPathStringValue("@.itemType")
				.isEqualTo(itemType);
	}

	@Test
	public void valueSerializes() throws IOException {
		assertThat(this.json.write(item)).extractingJsonPathNumberValue("@.amount")
				.isEqualTo(amount);
	}
}
