package com.wzn.qbcTest;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.wzn.myBeans.CustomerInfo;

public class test4 {
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
		//获取到操作对象后设置查询条件    就是添加条件      添加多条件     OR  条件的使用方法
		criteria.add(
					//or方法是告诉系统   这是or方法   后面添加的方法都是or条件
					//当or方法是自己时   此时的or方法相当于一个条件使用
					Restrictions.or(Restrictions.eq("id", 3))
					.add(Restrictions.eq("age", 18))
			);      //次语句的意思是添加and条件    相当于   WHERE id = 3 OR age = 18
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
