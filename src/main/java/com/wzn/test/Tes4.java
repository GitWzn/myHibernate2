package com.wzn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wzn.myBeans.AuthorInfo;
import com.wzn.myBeans.BookInfo;

public class Tes4 {
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取Session的工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//开启事务功能
		Transaction beginTransaction = session.beginTransaction();
		//创建作者
		AuthorInfo authorInfo1 = new AuthorInfo("吴宗宁", 18);
		AuthorInfo authorInfo2 = new AuthorInfo("卫星", 22);
		//创建书籍
		BookInfo bookInfo1 = new BookInfo("语文", 11);
		BookInfo bookInfo2 = new BookInfo("数学", 33);
		//进行双向关联
		authorInfo1.getBooks().add(bookInfo1);
		authorInfo1.getBooks().add(bookInfo2);
		
		authorInfo2.getBooks().add(bookInfo1);
		//数据保存
		session.save(authorInfo1);
		session.save(authorInfo2);
		//提交事务
		beginTransaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
