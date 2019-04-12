package com.wzn.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wzn.myBeans.CustomerInfo;

//延时加载   就是在数据没有使用的时候会出现加载的情况   当我们使用数据的时候又加载   使数据库操作次数增加
//get() 是没有延时加载的
//load() 默认是有延时加载   可以在需要延时加载的类的映射文件中添加  lazy:true;  即可
public class LazyTest {
	public static void main(String[] args) {
		//加载配置文件
		Configuration configure = new Configuration().configure();
		//获取SessionFactory对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取Session对象
		Session session1 = sessionFactory.openSession();
//		CustomerInfo customerInfo = session1.get(CustomerInfo.class, 3);
		CustomerInfo customerInfo = session1.load(CustomerInfo.class, 3);
		System.out.println("未使用数据之前~");
		System.out.println("=====================================");
		System.out.println("使用数据：");
		System.out.println(customerInfo);
		session1.close();
	}
}
