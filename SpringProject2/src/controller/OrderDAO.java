package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
@Repository
public class OrderDAO {
	private SessionFactory sessionFactory = new Configuration().configure("controller/hibernate.cfg.xml").
			addAnnotatedClass(Product.class).
			addAnnotatedClass(Orders.class).
			addAnnotatedClass(Role.class).
			addAnnotatedClass(User.class).
			addAnnotatedClass(Owner.class).
			addAnnotatedClass(Customer.class).buildSessionFactory();
	
	public OrderDAO() {
		
	}
	public  Set<Orders> getOrders(Set<Product> products){
		Set<Orders> orders = new HashSet<Orders>();
		for (Product product : products) {
			orders.addAll(product.getOrders());
		}
		return orders;
	}
	public void UpdateOrderStatus(String newStatus, int orderid) {
		Session session = sessionFactory.openSession();
        List<Orders> orderList = new ArrayList<Orders>();
        Query query = session.createQuery("from Orders ");
        orderList = query.list();
        Orders order = null;
        for (Orders orders : orderList) {
			if(orders.getOrderID() == orderid) {
				order = orders;
			}
		}
   
		 session.beginTransaction();
		
		
		order.setStatus(newStatus);
		session.update(order);
		session.getTransaction().commit();
	     session.close();

	}
	public void createOrder(Orders order, int customer_id, int product_id) {
		
	  Session session = sessionFactory.openSession();        
	  session.beginTransaction();
	  Customer customer = (Customer) session.get(Customer.class, customer_id);
	  Product product = (Product) session.get(Product.class, product_id);
	  order.setCustomer(customer);
	  order.setProduct(product);
      session.save(order);
      session.getTransaction().commit();
      session.close();

	}
	
	public Orders getOrderByID(int order_id)
	{
		Session session = sessionFactory.openSession();        
        List<Orders> orderList = new ArrayList<Orders>();
        Query query = session.createQuery("from Orders ");
        orderList = query.list();
        for (Orders orders : orderList) {
			if(orders.getOrderID() == order_id) {
				return orders;
			}
		}
        return null;
        
		
	}
	


}
