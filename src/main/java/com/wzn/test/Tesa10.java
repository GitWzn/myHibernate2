package com.wzn.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wzn.myBeans.IDCard;
import com.wzn.myBeans.Persion;

public class Tesa10 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//指定属性查询也叫投影查询    和   别名查询    指定属性查询到的数据不再是实体类   而是数组
		//设置hql语句
		String hql = "SELECT p.name,p.age,c.number FROM Persion AS p,IDCard AS c WHERE p.pid = c.cid";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.list();
		//双重遍历
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.print(object + "\t");
			}
			System.out.println();
		}
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
