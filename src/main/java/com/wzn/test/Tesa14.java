package com.wzn.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wzn.myBeans.IDCard;
import com.wzn.myBeans.Persion;

public class Tesa14 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction beginTransaction = session.beginTransaction();
		//修改数据
		String hql = "UPDATE Persion SET name = ?,age = ? WHERE id = ?";
		Query query = session.createQuery(hql);
		//设置占位符
		query.setParameter(0, "哈哈哈");
		query.setParameter(1, 20);
		query.setParameter(2, 2);
		//执行删除的方法是下面的这个    而且需要事务
		int result = query.executeUpdate();
		System.out.println(result);
		//提交事务
		beginTransaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
