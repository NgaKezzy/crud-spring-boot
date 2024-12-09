package com.testmysql.test_mysql.service;

import com.testmysql.test_mysql.dto.request.UserCreationRequest;
import com.testmysql.test_mysql.dto.request.UserUpdateRequest;
import com.testmysql.test_mysql.entity.User;
import com.testmysql.test_mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createRequest(UserCreationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);



    }

    public  User updateUser(String userId , UserUpdateRequest request){
        User user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
      return   userRepository.save(user);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public  User getUser(String id){

        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public  void deleteUser(String userId){
         userRepository.deleteById(userId);
    }
}
