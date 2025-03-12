package com.motoshkin.apptrack.services;

import com.motoshkin.apptrack.models.User;
import com.motoshkin.apptrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loadUserById(String id) {
        return userRepository.findById(Integer.valueOf(id));
    }

    public String getAllUsers() {
        List<User> users = this.userRepository.findAll();
        String res = "";
        for (int i = 0; i < users.size(); i++) {
            res = res + users.get(i).toString() + "       ";
        }
        return res;
    }

    public void save(User user) {
        user.setPassword("{noop}" + user.getPassword());
        user.setRole("USER");
        this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Failed to get user: " + username));
    }

    public Integer getDeptId(Long userId) {
        return userRepository.findDeptByUserId(userId);
    }
}
