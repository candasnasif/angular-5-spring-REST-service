package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/register" })
public class RegistrationRestService {
	
	UserDAO userdao = new UserDAO();
	
	@RequestMapping(path = "/customerRegister", method = RequestMethod.POST)
	public void customerRegister(@RequestBody Customer customer) {
		
		userdao.addCustomer(customer);
	}
	@RequestMapping(path = "/ownerRegister", method = RequestMethod.POST)
	public void ownerRegister(@RequestBody Owner owner) {
		userdao.addOwner(owner);
	}
}
