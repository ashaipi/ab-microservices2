package com.ashaipi.service;


import com.ashaipi.model.User;
import com.ashaipi.repository.UserRegistrationDto;

import java.util.List;

public interface UserService {
   User findByEmail(String email);
   User save(UserRegistrationDto registration);
   User userUpdate(User user);
   List<User> allUsers();
}
