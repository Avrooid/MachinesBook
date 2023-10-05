package ru.Burakov.MachinesBook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.Burakov.MachinesBook.models.MyUser;
import ru.Burakov.MachinesBook.models.MyUserDetails;
import ru.Burakov.MachinesBook.repositories.MyUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Cant find user");
        return new MyUserDetails(user);
    }
}
