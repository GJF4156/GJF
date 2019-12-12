package com.lin.lostandfound.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lin.lostandfound.domain.LostThings;
import com.lin.lostandfound.service.ILostThingsService;

public class LostThingsTest extends BaseJunitTest {
	
	@Autowired
	@Qualifier("lostThingsService")
	private ILostThingsService lostThingsService;

	@Test
	public void lostThingsService() {
		LostThings lostThings = null;
		System.out.println("test...");
		for (int i = 1; i <= 10; i++) {
			System.out.println("test..." + i);
			lostThings = new LostThings("饭卡" + i, "教学楼" + i * 3, new Date(),
					"card", "145", "static\\upload\find\2013143218\2017\03\20161130151920.jpg", "一张饭卡" + i,
					new Date(), 0, "2013143218", 1);
			lostThingsService.add(lostThings);
		}
	}

}
