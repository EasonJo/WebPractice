package cn.eason.query.lazy;

import cn.eason.domain.Customer;
import cn.eason.domain.LinkMan;
import cn.eason.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Set;

//关联级别 延迟加载 & 抓取策略
@SuppressWarnings("ALL")
public class Demo {
	
	//集合级别的关联
	//fetch:select 单表查询
	//lazy:true 使用时才加载集合数据.
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Customer c = session.get(Customer.class, 2l);
		
		Set<LinkMan> linkMens = c.getLinkMans();//关联级别
		
		System.out.println(linkMens);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	//集合级别的关联
		//fetch:select 单表查询
		//lazy:false 立即记载集合数据
		@Test
		public void fun2(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
			
			Customer c = session.get(Customer.class, 2l);
			
			Set<LinkMan> linkMens = c.getLinkMans();//关联级别
			
			System.out.println(linkMens);
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		//集合级别的关联
		//fetch:select 单表查询
		//lazy:extra 极其懒惰.与懒加载效果基本一致. 如果只获得集合的size.只查询集合的size(count语句)
		@Test
		public void fun3(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
			
			Customer c = session.get(Customer.class, 2l);
			
			Set<LinkMan> linkMens = c.getLinkMans();//关联级别
			
			System.out.println(linkMens.size());
			
			System.out.println(linkMens);
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		//集合级别的关联
		//fetch:join	多表查询
		//lazy:true|false|extra 失效.立即加载.
		@Test
		public void fun4(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
			
			Customer c = session.get(Customer.class, 2l);
			
			Set<LinkMan> linkMens = c.getLinkMans();//关联级别
			
			System.out.println(linkMens.size());
			
			System.out.println(linkMens);
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		
		@Test
		//fetch: subselect 子查询
		//lazy: true 懒加载
		public void fun5(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
				
			String  hql = "from Customer";
			
			Query query = session.createQuery(hql);
			
			List<Customer> list = query.list();
			
			for(Customer c:list){
				System.out.println(c);
				System.out.println(c.getLinkMans().size());
				System.out.println(c.getLinkMans());
			}
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		@Test
		//fetch: subselect 子查询
		//lazy: false 立即加载
		public void fun6(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
				
			String  hql = "from Customer";
			
			Query query = session.createQuery(hql);
			
			List<Customer> list = query.list();
			
			for(Customer c:list){
				System.out.println(c);
				System.out.println(c.getLinkMans().size());
				System.out.println(c.getLinkMans());
			}
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		@Test
		//fetch: subselect 子查询
		//lazy: extra 极其懒惰
		public void fun7(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
				
			String  hql = "from Customer";
			
			Query query = session.createQuery(hql);
			
			List<Customer> list = query.list();
			
			for(Customer c:list){
				System.out.println(c);
				System.out.println(c.getLinkMans().size());
				System.out.println(c.getLinkMans());
			}
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
	
}
