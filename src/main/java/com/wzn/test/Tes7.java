package com.wzn.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.wzn.myBeans.IDCard;
import com.wzn.myBeans.Persion;

public class Tes7 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//设置HQL语句   
//		String hql = "FROM Persion";    //查询所有数据   相当于遍历每一个对象
//		String hql = "FROM Persion WHERE pid IN(?,?)";   //加上条件   相当于查询pid为...的数据
		String hql = "FROM Persion WHERE name = :name OR pid = :pid";
		//获取hql语句的执行对象   和   绑定hql语句
		Query<Persion> persions = session.createQuery(hql, Persion.class);
		//设置占位符
//		persions.setParameter(0, 1);
//		persions.setParameter(1, 4);
		//设置命名参数
		persions.setParameter("name", "h华盛顿");
		persions.setParameter("pid", 2);
		//执行sql语句      将所有的数据放入集合中
		List<Persion> list = persions.list();
		for (Persion persion : list) {
			System.out.println(persion);
		}
		
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
