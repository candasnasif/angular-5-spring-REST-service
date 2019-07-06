package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {
		private UserDAO userDao = new UserDAO();
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			controller.User user = userDao.getUserByUsername(username);
	        if(user==null){
	            System.out.println("User not found");
	            throw new UsernameNotFoundException("Username not found");
	        }
	            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
	                 true, true, true, true, getGrantedAuthorities(user));
	    }
	 
	     
	    private List<GrantedAuthority> getGrantedAuthorities(User user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	            
	            authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().getRole()));
	       
	        System.out.print("authorities :"+authorities);
	        return authorities;
	    }
	     
}
