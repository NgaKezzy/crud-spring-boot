package com.testmysql.test_mysql.controller;

import com.testmysql.test_mysql.dto.request.UserCreationRequest;
import com.testmysql.test_mysql.dto.request.UserUpdateRequest;
import com.testmysql.test_mysql.entity.User;
import com.testmysql.test_mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createRequest(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUser();
    }

    @GetMapping("/{userId}")
    User getUses(@PathVariable("userId") String userId) {

        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return  "Xóa user thành công!";
    }

}
