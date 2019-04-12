package com.wzn.qbcTest;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.transform.Transformers;

import com.wzn.myBeans.CustomerInfo;

public class test8 {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		//加载Hibernate配置文件
		Configuration configure = new Configuration().configure();
		//获取SessionFactory对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//获取Session对象
		Session session = sessionFactory.openSession();
		//使用标准查询(HBC)     查询所有数据
		//获取QBC操作对象Criteria                    操作哪个类的数据
		Criteria criteria = session.createCriteria(CustomerInfo.class);
		//进行指定属性的查询    就是聚合查询
		//通过Projections接口 获取 ProjectionList对象 
		ProjectionList projectionList = Projections.projectionList();
		//添加指定查询的属性名   就是绑定要查询的属性        //第二个参数是告诉系统是用来转换的   将这个属性映射到对相应类的属性上
		projectionList.add(Property.forName("username"),"username")
					  .add(Property.forName("age"),"age");
		//设置投影函数
		criteria.setProjection(projectionList);
		//使用Criteria提供的转换器，将查询到的指定属性的数据映射到响应的类中
		criteria.setResultTransformer(Transformers.aliasToBean(CustomerInfo.class));
		//获取指定的属性的数据      默认返回是数组
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
