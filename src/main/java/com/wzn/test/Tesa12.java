package com.wzn.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wzn.myBeans.IDCard;
import com.wzn.myBeans.Persion;

public class Tesa12 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//聚合查询    就是使用一些数学函数来查询数据      
//		String hql = "SELECT COUNT(pid) FROM Persion";   
//		Query<Long> query = session.createQuery(hql, Long.class);
		String hql = "SELECT MAX(pid) FROM Persion";   
		Query<Integer> query = session.createQuery(hql, Integer.class);
		//当查询的数据只有一条的时候可以使用此方法
		Integer result = query.uniqueResult();
		System.out.println(result);
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
