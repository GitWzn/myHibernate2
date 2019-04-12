package com.wzn.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wzn.myBeans.IDCard;
import com.wzn.myBeans.Persion;

public class Tes9 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//设置hql语句      分页查询
		String hql = "FROM Persion GROUP BY name,pid ORDER BY pid DESC";
		Query<Persion> persions = session.createQuery(hql, Persion.class);
		//设置分页查询
		persions.setMaxResults(2);   //设置查看的数据条数
		persions.setFirstResult(1);	 //设置一开始的索引
		//执行hql语句
		List<Persion> list = persions.list();
		//遍历
		for (Persion persion : list) {
			System.out.println(persion);
		}
		
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
