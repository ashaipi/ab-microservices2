package com.ashaipi.service;

import com.ashaipi.model.Role;
import com.ashaipi.model.User;
import com.ashaipi.repository.UserRegistrationDto;
import com.ashaipi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

   @Autowired
   public UserServiceImpl(UserRepository userRepository){
       this.userRepository = userRepository;
   }

   @Override
   public User findByEmail(String email){
       return userRepository.findByEmail(email);
   }

    @Override
    public User save(UserRegistrationDto registration){
       User user = new User();
       user.setFirstName(registration.getFirstName());
       user.setLastName(registration.getLastName());
       user.setEmail(registration.getEmail());
       user.setPassword(registration.getPassword());
       user.setRoles(Arrays.asList(new Role("ROLE_USER")));
       return userRepository.save(user);
    }

   public List<User> allUsers(){
       return userRepository.findAll();
   }

   @Override
    public User userUpdate(User user){
        return userRepository.save(user);
    }

}