package com.itguo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itguo.entity.Student;

public class testSpring {
	public static void main(String[] args) {
		//��ͳ��ʽ��ȡ���󲢸�ֵ
//		Student student=new Student();
//		student.setStuNo(2);
//		student.setAtuName("ls");
//		student.setStuAge(24);
//		System.out.println(student);
		
		
		//ͨ��spring��ʽ��ȡ���󣬱�����new�ؼ��ִ�������ͳһ����spring����
		
		//spring�����Ķ���
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		//��Ioc�����л�ȥ����
		Student student=(Student)applicationContext.getBean("student");
		
		System.out.println(student);
	}
}
