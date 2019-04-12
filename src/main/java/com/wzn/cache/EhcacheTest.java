package com.wzn.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wzn.myBeans.CustomerInfo;

public class EhcacheTest {
	public static void main(String[] args) {
		//加载配置文件
		Configuration configure = new Configuration().configure();
		//获取SessionFactory对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取Session对象
		Session session1 = sessionFactory.openSession();
		System.out.println("第一次查询~");
		CustomerInfo customerInfo = session1.get(CustomerInfo.class, 3);
		System.out.println(customerInfo);
		session1.close();
		System.out.println("===========================================");
		System.out.println("第二次查询~");
		Session session2 = sessionFactory.openSession();
		CustomerInfo customerInfo2 = session2.get(CustomerInfo.class, 3);
		System.out.println(customerInfo2);
		session2.close();
	}
}
