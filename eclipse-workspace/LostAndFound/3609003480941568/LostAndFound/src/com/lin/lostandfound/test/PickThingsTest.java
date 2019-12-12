package com.lin.lostandfound.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lin.lostandfound.domain.PickThings;
import com.lin.lostandfound.service.IPickThingsService;

public class PickThingsTest extends BaseJunitTest {
	
	@Autowired
	@Qualifier("pickThingsService")
	private IPickThingsService pickThingsService;

	@Test
	public void pickThingsService() {
		PickThings pickThings = null;
		System.out.println("test...");
		for (int i = 1; i <= 10; i++) {
			System.out.println("test..." + i);
			pickThings = new PickThings("饭卡" + i, "教学楼" + i * 3, new Date(),
					"card", "144", "static\\upload\find\2013143218\2017\03\20161130151920.jpg",
					"一张饭卡" + i, null, null, new Date(), 0, "2013143218", 1);
			pickThingsService.add(pickThings);
		}
	}

}
