package io.github.ramajd.SpringSecurityDemo.service;

import io.github.ramajd.SpringSecurityDemo.model.UserPrincipal;
import io.github.ramajd.SpringSecurityDemo.model.Users;
import io.github.ramajd.SpringSecurityDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("user not found.  " + username) ;
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(user);
    }
}
