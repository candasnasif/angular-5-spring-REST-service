package controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	private SessionFactory sessionFactory = new Configuration().configure("controller/hibernate.cfg.xml")
			.addAnnotatedClass(Product.class).addAnnotatedClass(Orders.class).addAnnotatedClass(Role.class)
			.addAnnotatedClass(User.class).addAnnotatedClass(Owner.class).addAnnotatedClass(Customer.class)
			.buildSessionFactory();

	ProductDAO() {

	}

	public void addProduct(Product product, int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Owner owner = (Owner) session.get(Owner.class, id);
		product.setOwner(owner);
		session.save(product);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	public void deleteProduct(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query1 = session.createSQLQuery("delete from 	owner_products  where product_id = :id");
		query1.setParameter("id", id);
		query1.executeUpdate();
		Query query2 = session.createSQLQuery("select order_id from order_products where product_id = :id");
		query2.setParameter("id", id);
		List<Integer> orderid = query2.list();
		Query query3 = session.createSQLQuery("delete from order_products  where product_id = :id");
		query3.setParameter("id", id);
		query3.executeUpdate();	
		for (int i = 0; i < orderid.size(); i++) {	
			Query query4 = session.createSQLQuery("delete from customer_orders where order_id = :id");
			query4.setParameter("id", orderid.get(i));
			query4.executeUpdate();
			Query query5 = session.createSQLQuery("delete from orders where orderid = :id");
			query5.setParameter("id", orderid.get(i));
			query5.executeUpdate();
		}
		
		Query query6 = session.createSQLQuery("delete from products  where id = :id");
		query6.setParameter("id", id);
		query6.executeUpdate();
		

		session.getTransaction().commit();
		session.close();
	}

	public void updateProduct(String newProductName, int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = (Product) session.get(Product.class, id);
		product.setProductName(newProductName);
		session.update(product);
		session.getTransaction().commit();
		session.close();
	}

	public ArrayList<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> productList = new ArrayList<Product>();
		Query query = session.createQuery("from Product ");

		productList = query.list();
		session.close();
		return new ArrayList<Product>(productList);

	}

	public Product getProductById(int id) {
		Session session = sessionFactory.openSession();
		List<Product> productList = new ArrayList<Product>();
		Query query = session.createQuery("from Product p where p.id = :id");
		query.setParameter("id", id);
		productList = query.list();
		session.close();
		return productList.get(0);
	}

}
