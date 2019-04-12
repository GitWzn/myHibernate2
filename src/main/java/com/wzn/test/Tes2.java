package com.wzn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wzn.myBeans.CustomerInfo;

public class Tes2 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//开启事务功能
		Transaction beginTransaction = session.beginTransaction();
		//数据删除
		CustomerInfo customerInfo = new CustomerInfo("", 1, "", 1);
		//设置删除的数据的主键值
		customerInfo.setId(2);
		session.delete(customerInfo);
		//提交事务
		beginTransaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
