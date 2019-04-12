package com.wzn.qbcTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class testb16 {
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取SessionFactory对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取Session对象
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction beginTransaction = session.beginTransaction();
		//使用标准查询(HBC)     查询所有数据
		//通过本地的SQL语句来查询数据
		String sql = "UPDATE `user` SET username = ?,age = ? WHERE id = ?";
		//获取SQL语句执行对象     绑定SQL语句
		NativeQuery createSQLQuery = session.createSQLQuery(sql);
		createSQLQuery.setParameter(1, "詹姆斯");
		createSQLQuery.setParameter(2, 100);
		createSQLQuery.setParameter(3, 6);
		//执行SQL语句
		int result = createSQLQuery.executeUpdate();
		System.out.println(result);
		//关闭事务
		beginTransaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
