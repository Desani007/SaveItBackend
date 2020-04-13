package com.passion.saveit.app.service;

import com.passion.saveit.app.model.User;
import com.passion.saveit.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(long id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public User updateUser(long id, User newUser){
        User updateUser = userRepository.findById(id).get();
        updateUser.setName(newUser.getName());
        return userRepository.save(updateUser);

    }
}
