package kimiko.demo.security.services;

import kimiko.demo.entity.User;
import kimiko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userService.findUserByEmail(username);
        return  buildUserForAuthentication(user);
    }

    public UserDetails buildUserForAuthentication(User user){
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), new HashSet<GrantedAuthority>());
    }
}
