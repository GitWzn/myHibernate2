package com.wzn.qbcTest;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.wzn.myBeans.CustomerInfo;
import com.wzn.myBeans.Persion;

public class testa11 {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取SessionFactory对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取Session对象
		Session session = sessionFactory.openSession();
		//使用标准查询(HBC)     查询所有数据
		//离线查询    就是不需要Session对象去创建执行查询的对下那个
		//获取离线查询的对象
		//DetachedCriteria forClass = DetachedCriteria.forClass(CustomerInfo.class);
		//给类设置别名
		DetachedCriteria forClass = DetachedCriteria.forClass(CustomerInfo.class,"c");
		//添加查询条件
		//forClass.add(Restrictions.eq("username", "詹姆斯"));
		//添加排序
		forClass.addOrder(Order.asc("c.age"));
		//获取Criteria对象执行操作
		Criteria criteria = forClass.getExecutableCriteria(session);
		//获取到查询到的数据
		List<CustomerInfo> list = criteria.list();
		//遍历
		for (CustomerInfo customerInfo : list) {
			System.out.println(customerInfo);
		}
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
