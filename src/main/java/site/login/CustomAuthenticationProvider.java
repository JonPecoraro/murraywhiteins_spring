package site.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import site.users.Users;
import site.users.UsersRepository;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
	@Autowired
    private UsersRepository usersRepository;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        final Users users = usersRepository.findByEmail(auth.getName());
        if ((users == null)) {
            throw new BadCredentialsException("Invalid username or password");
        }

        final Authentication result = super.authenticate(auth);
        return new UsernamePasswordAuthenticationToken(users, result.getCredentials(), result.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
