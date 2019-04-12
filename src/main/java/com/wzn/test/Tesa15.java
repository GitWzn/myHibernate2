package com.wzn.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wzn.myBeans.IDCard;
import com.wzn.myBeans.Persion;

public class Tesa15 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction beginTransaction = session.beginTransaction();
		//联表查询   就是多表查询    左，右连接查询
//		String hql = "FROM Persion AS p LEFT JOIN IDCard AS c ON p.pid = c.cid";
		String hql = "FROM Persion AS p RIGHT JOIN IDCard AS c ON p.pid = c.cid";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		//执行删除的方法是下面的这个    而且需要事务
		List<Object[]> list = query.list();
		//遍历
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
		//提交事务
		beginTransaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
