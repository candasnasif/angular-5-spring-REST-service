package controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
		public UserDAO() {
			
		}
		private SessionFactory sessionFactory = new Configuration().configure("controller/hibernate.cfg.xml").
		addAnnotatedClass(Product.class).
		addAnnotatedClass(Orders.class).
		addAnnotatedClass(Role.class).
		addAnnotatedClass(User.class).
		addAnnotatedClass(Owner.class).
		addAnnotatedClass(Customer.class).buildSessionFactory();
	     
	   
	   public void addUser(User user, int roleID) {
		   Session session = sessionFactory.openSession();        
	 		 session.beginTransaction();
	 		Role role = (Role) session.get(Role.class, roleID);
	 		user.setRole(role);
	        session.save(user);
	        session.getTransaction().commit();
	        session.close();
	   }
	   public void addCustomer(Customer customer) {
		   User user = new User(customer.getUsername(),customer.getPassword());
		   addUser(user, 2);
		   Session session = sessionFactory.openSession();        
	 		 session.beginTransaction();
	 		session.save(customer);
	        session.getTransaction().commit();
	        session.close();
	   }
	   public void updateCustomer(String username, String password, String name, String surname, String address) {
		  
		   Session session = sessionFactory.openSession();
		   List<Customer> customerList = new ArrayList<Customer>();
	        Query query = session.createQuery("from Customer u where u.username = :username");
	        query.setParameter("username", username);
	        customerList = query.list();
	      
	            Customer customer = customerList.get(0);
			 session.beginTransaction();
			customer.setPassword(password);
			customer.setName(name);
			customer.setSurname(surname);
			customer.setAddress(address);
			session.update(customer);
			session.getTransaction().commit();
		     session.close();
	   }
	   public ArrayList<Customer> getAllCustomers(){
		   Session session = sessionFactory.openSession();        
	        List<Customer> customers = new ArrayList<Customer>();
	        Query query = session.createQuery("from Customer");
	        customers = query.list();
	        return new ArrayList<Customer>(customers);
	   }
	   public ArrayList<Owner> getAllOwners(){
		   Session session = sessionFactory.openSession();        
	        List<Owner> owners = new ArrayList<Owner>();
	        Query query = session.createQuery("from Owner");
	        owners = query.list();
	        return new ArrayList<Owner>(owners);
	   }
	   public void addOwner(Owner owner) {
		   User user = new User(owner.getUsername(),owner.getPassword());
		   addUser(user, 1);
		   Session session = sessionFactory.openSession();        
	 		 session.beginTransaction();
	 		session.save(owner);
	        session.getTransaction().commit();
	        session.close();
	   }
	    public User getUserByUsername(String username) {
	    	Session session = sessionFactory.openSession();        
	        List<User> userList = new ArrayList<User>();
	        Query query = session.createQuery("from User u where u.username = :username");
	        query.setParameter("username", username);
	        userList = query.list();
	        if (userList.size() > 0)
	            return userList.get(0);
	        else
	            return null;
	    }
	    public Customer getCustomerByUsername(String username) {
	    	Session session = sessionFactory.openSession();        
	        List<Customer> customerList = new ArrayList<Customer>();
	        Query query = session.createQuery("from Customer u where u.username = :username");
	        query.setParameter("username", username);
	        customerList = query.list();
	        if (customerList.size() > 0)
	            return customerList.get(0);
	        else
	            return null;
	    }
	    public Owner getOwnerByUsername(String username) {
	    	Session session = sessionFactory.openSession();        
	        List<Owner> ownerList = new ArrayList<Owner>();
	        Query query = session.createQuery("from Owner u where u.username = :username");
	        query.setParameter("username", username);
	        ownerList = query.list();
	        
	        if (ownerList.size() > 0)
	            return ownerList.get(0);
	        else
	            return null;
	    }
	    public Set<Orders> getOrdersByUsername(String username){
	    	Customer c = getCustomerByUsername(username);
	    	return c.getOrders();
	    }
	    public Set<Product> getProductsByUsername(String username){
	    	Owner o = getOwnerByUsername(username);
	    	return o.getProducts();
	    }
	     
}
