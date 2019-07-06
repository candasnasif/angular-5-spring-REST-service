package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/customer" })
public class CustomerRestService {
	
	UserDAO userdao = new UserDAO();
	OrderDAO orderdao = new OrderDAO();
	ProductDAO productdao = new ProductDAO();
	@RequestMapping(path = "/getCustomer", method = RequestMethod.POST)
	public Customer getCustomer(@RequestBody String username) {
		return userdao.getCustomerByUsername(username);
	}
	
	@RequestMapping(path = "/createOrder", method = RequestMethod.POST)
	public void createOrder(@RequestBody String order) {
		System.out.println("girdi");
		String token[] = order.split(" ");
		Customer customer = userdao.getCustomerByUsername(token[0]);
		Orders newOrder = new Orders("new", token[1]);
		orderdao.createOrder(newOrder, customer.getId(),  Integer.valueOf(token[2]));
		
	}
	
	@RequestMapping(path = "/checkStatus", method = RequestMethod.POST)
	public Orders checkStatus(@RequestBody String input) {
		String token[] = input.split(" ");
		Customer customer = userdao.getCustomerByUsername(token[0]);
		ArrayList<Orders> orders = new ArrayList<Orders>();
		for (Orders order : customer.getOrders()) {
			if(order.getOrderID() == Integer.valueOf(token[1])) {
				orders.add(order);
				break;
				
			}
		}
		return orders.get(0);
	}
	
	@RequestMapping(path = "/listProducts", method = RequestMethod.GET)
	public List<Product> listProducts(){
		return productdao.getAllProducts();
	}
	@RequestMapping(path = "/listOrders", method = RequestMethod.POST)
	public List<Orders> listOrders(@RequestBody String username){
		Customer customer = userdao.getCustomerByUsername(username);
		List<Orders> orders = new ArrayList<Orders>(customer.getOrders());
		return orders;
		
	}
	@RequestMapping(path = "/updateInformation", method = RequestMethod.POST)
	public void updateInformation(@RequestBody Customer customer) {
		userdao.updateCustomer(customer.getUsername(), customer.getPassword(), customer.getName(), customer.getSurname(), customer.getAddress());
	}
}
