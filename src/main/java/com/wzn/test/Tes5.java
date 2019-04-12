package com.wzn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.wzn.myBeans.AuthorInfo;

public class Tes5 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//数据查询
		AuthorInfo authorInfo = session.get(AuthorInfo.class, 2);
		System.out.println(authorInfo);
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
