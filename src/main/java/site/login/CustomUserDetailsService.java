package site.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.users.Users;
import site.users.UsersRepository;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoginAttemptService loginAttemptService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String ip = getClientIp();
		if (loginAttemptService.isBlocked(ip)) {
			throw new RuntimeException("blocked");
		}
		
		try {
			final Users users = usersRepository.findByEmail(username);
			if (users == null) {
				throw new UsernameNotFoundException("No user found with username: " + username);
			}
			
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(), true, true, true, true, authorities);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private String getClientIp() {
	    String xfHeader = request.getHeader("X-Forwarded-For");
	    if (xfHeader == null){
	        return request.getRemoteAddr();
	    }
	    return xfHeader.split(",")[0];
	}
}
