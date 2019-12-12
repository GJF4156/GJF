package com.itguo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itguo.entity.Student;

public class testSpring {
	public static void main(String[] args) {
		//传统方式获取对象并赋值
//		Student student=new Student();
//		student.setStuNo(2);
//		student.setAtuName("ls");
//		student.setStuAge(24);
//		System.out.println(student);
		
		
		//通过spring方式获取对象，避免了new关键字创建对象，统一交给spring管理
		
		//spring上下文对象
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		//从Ioc容器中回去对象
		Student student=(Student)applicationContext.getBean("student");
		
		System.out.println(student);
	}
}
