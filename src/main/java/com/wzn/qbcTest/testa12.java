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

public class testa12 {
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
		//给类设置别名
		DetachedCriteria forClass = DetachedCriteria.forClass(Persion.class,"p");
		//给从表设置别名
		forClass.createAlias("idCard", "c");
		//通过Projections接口 获取  ProjectionList对象
		ProjectionList projectionList = Projections.projectionList();
		//添加指定查询的属性名     就是绑定指定属性      和设置绑定属性的别名   为后面的转换提供别名
		projectionList.add(Property.forName("p.name"), "name")
					  .add(Property.forName("p.age"), "age");
//					  .add(Property.forName("c.number"), "number");
		//设置投影查询函数
		forClass.setProjection(projectionList);
		//将指定查询的属性   映射到指定类中的属性中
		forClass.setResultTransformer(Transformers.aliasToBean(Persion.class));
		//获取Criteria对象执行操作
		Criteria criteria = forClass.getExecutableCriteria(session);
		//获取到查询到的数据
		List<Persion> list = criteria.list();
		//遍历
		for (Persion persion : list) {
			System.out.println(persion);
		}
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
