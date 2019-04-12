package com.wzn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wzn.myBeans.IDCard;
import com.wzn.myBeans.Persion;

public class Tes6 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//启动事务
		Transaction beginTransaction = session.beginTransaction();
		//创建Persion对象
		Persion persion = new Persion("宗宁", 18, "男");
		//创建IDCard对象
		IDCard card = new IDCard("12345678987654332456", "钦州旧州");
		//单向关联
		persion.setIdCard(card);
		card.setPersion(persion);
		//保存数据
		session.save(persion);
		//提交事务
		beginTransaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
