package com.lin.lostandfound.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/resource/spring-config.xml",
		"classpath:/resource/spring-mvc.xml" })
public abstract class BaseJunitTest extends AbstractJUnit4SpringContextTests {

}