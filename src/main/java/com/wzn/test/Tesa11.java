package com.wzn.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wzn.myBeans.IDCard;
import com.wzn.myBeans.Persion;

public class Tesa11 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//指定属性查询也叫投影查询    和   别名查询    指定查询对象的数据    返回的是实体类
		//设置hql语句    是用这种方法时候必须类中要有符合的构造方法   否则报错
		String hql = "SELECT new Persion(p.name,p.age,c.number) FROM Persion AS p,IDCard AS c";
		Query<Persion> query = session.createQuery(hql, Persion.class);
		List<Persion> list = query.list();
		//遍历
		for (Persion persion : list) {
			System.out.println(persion);
		}
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
