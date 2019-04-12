package com.wzn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wzn.myBeans.CustomerInfo;
import com.wzn.myBeans.OrderInfo;

public class Tes3 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//开启事务功能
		Transaction beginTransaction = session.beginTransaction();
		//创建订单
		OrderInfo orderInfo1 = new OrderInfo("苹果", 4300, 2);
		OrderInfo orderInfo2 = new OrderInfo("三星", 7300, 3);
		//创建用户
		CustomerInfo customerInfo = new CustomerInfo("吴宗宁", 18, "男", 99999);
		//将订单放进用户的集合中    让两者产生关系
		customerInfo.getOrders().add(orderInfo1);
		customerInfo.getOrders().add(orderInfo2);
		//当我们对customerInfo进行反转(在哪里设置反转哪里的对象就对外键失去控制)后  必须要进行双向关联   否则外键空值
		orderInfo1.setCustomer(customerInfo);
		orderInfo2.setCustomer(customerInfo);
		//保存数据
		session.save(customerInfo);
		//提交事务
		beginTransaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
