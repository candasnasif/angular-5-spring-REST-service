package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/owner" })
public class OwnerRestService {
	UserDAO userdao = new UserDAO();
	ProductDAO productdao = new ProductDAO();
	OrderDAO orderdao = new OrderDAO();
	
	@RequestMapping(path = "/listCustomers", method = RequestMethod.GET)
	public List<Customer> listCustomers() {
		return userdao.getAllCustomers();
		
	}
	@RequestMapping(path = "/editCustomer", method = RequestMethod.POST)
	public void updateCustomer(@RequestBody Customer customer) {
		userdao.updateCustomer(customer.getUsername(), customer.getPassword(), customer.getName(), customer.getSurname(), customer.getAddress());
	}
	@RequestMapping(path = "/getOwner", method = RequestMethod.POST)
	public Owner getOwner(@RequestBody String username) {
		return userdao.getOwnerByUsername(username);
	}
	@RequestMapping(path = "/createProduct", method = RequestMethod.POST)
	public void createProdut(@RequestBody String product) {
		String token[] = product.split(" ");
		Product newProduct = new Product();
		newProduct.setProductName(token[0]);
		productdao.addProduct(newProduct, Integer.valueOf(token[1]));
	}
	@RequestMapping(path = "/updateProduct", method = RequestMethod.POST)
	public void updateProduct(@RequestBody String product) {
		String token[] = product.split(" ");
		productdao.updateProduct(token[0], Integer.valueOf(token[1]));
	}
	@RequestMapping(path = "/deleteProduct", method = RequestMethod.POST)
	public void deleteProduct(@RequestBody String product) {
		productdao.deleteProduct(Integer.valueOf(product));
	}
	@RequestMapping(path = "/listProducts", method = RequestMethod.GET)
	public List<Product> listProducts(){
		return productdao.getAllProducts();
	}
	
	@RequestMapping(path = "/viewOrders", method = RequestMethod.POST)
	public List<Orders> viewOrders(@RequestBody String username){
		Set<Orders> orders = new HashSet<Orders>();
		for (Owner o : userdao.getAllOwners()) {
			orders.addAll(orderdao.getOrders(o.getProducts()));
		}
		
		return new ArrayList<Orders>(orders);
	}
	
	@RequestMapping(path = "/updateOrder", method = RequestMethod.POST)
	public void updateOrder(@RequestBody String order) {
		String token[] = order.split(" ");
		orderdao.UpdateOrderStatus(token[0],Integer.valueOf(token[1]));
	}
	@RequestMapping(path = "/viewCustomerOrderHistory", method = RequestMethod.POST)
	public List<Orders> viewCustomerOrderHistory(@RequestBody String username){
		Customer customer = userdao.getCustomerByUsername(username);
		return new ArrayList<Orders>(customer.getOrders()); 
	}
	
	
	
}
