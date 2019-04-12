package com.wzn.qbcTest;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class testb14 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取SessionFactory对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取Session对象
		Session session = sessionFactory.openSession();
		//使用标准查询(HBC)     查询所有数据
		//通过本地的SQL语句来查询数据
		String sql = "SELECT COUNT(*) AS '数量' FROM user";
		//获取SQL语句执行对象     绑定SQL语句
		NativeQuery createSQLQuery = session.createSQLQuery(sql);
		//当返回的数据只有一条时
		Object result = createSQLQuery.uniqueResult();
		System.out.println(result);
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
