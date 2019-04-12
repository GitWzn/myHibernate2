package com.wzn.qbcTest;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import com.wzn.myBeans.CustomerInfo;

public class test6 {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取SessionFactory对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取Session对象
		Session session = sessionFactory.openSession();
		//使用标准查询(HBC)     查询所有数据
		//获取QBC操作对象Criteria                    操作哪个类的数据
		Criteria criteria = session.createCriteria(CustomerInfo.class);
		//分页查询    设置最大的查询数量   和  起始索引
		criteria.setMaxResults(2);
		criteria.setFirstResult(1);
		//以id来降序查询
		criteria.addOrder(Order.desc("id"));
		//获取所有该对象的数据
		List<CustomerInfo> list = criteria.list();
		//遍历数据
		for (CustomerInfo customerInfo : list) {
			System.out.println(customerInfo);
		}
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
