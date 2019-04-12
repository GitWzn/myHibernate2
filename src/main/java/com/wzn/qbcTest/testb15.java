package com.wzn.qbcTest;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class testb15 {
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
		String sql = "SELECT * FROM customerInfo WHERE id > ?";
		//获取SQL语句执行对象     绑定SQL语句
		NativeQuery createSQLQuery = session.createSQLQuery(sql);
		//执行SQL语句之前给占位符设置数值
		createSQLQuery.setParameter(1, 4);
		//查询到的数据是以数组的形式返回的
		List<Object[]> list = createSQLQuery.list();
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
