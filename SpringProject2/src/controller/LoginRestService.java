package controller;




import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/login" })
public class LoginRestService {


	@RequestMapping(path = "/auth", method = RequestMethod.POST)
	public User login(@RequestBody User user)  {
		UserDAO userDao = new UserDAO();
		User auth = userDao.getUserByUsername(user.getUsername());

		return auth;

	}
}
