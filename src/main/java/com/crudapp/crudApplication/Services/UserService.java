package com.crudapp.crudApplication.Services;

import com.crudapp.crudApplication.Exception.UserNotFoundException;
import com.crudapp.crudApplication.Repository.UserRepo;
import com.crudapp.crudApplication.model.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    public List<Users> getAllUsers() {
        return repo.findAll();
    }


    public void addUser(Users user) {
        repo.save(user);
    }

    public Users getUserByID(Long id) {
        return repo.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }



    public Users updateUser(Users newUser,Long id ) {
        Users ExitingUser =   repo.findById(id).orElseThrow(()->new UserNotFoundException(id));
//        newUser.setId(ExitingUser.getId());
//        newUser.setName(ExitingUser.getName());
//        newUser.setEmail(ExitingUser.getEmail());
        ExitingUser.setName(newUser.getName());
        ExitingUser.setEmail(newUser.getEmail());
        ExitingUser.setId(newUser.getId());
        return repo.save(ExitingUser);
    }

    public String deleteUser(Long id) {
        repo.deleteById(id);
        return "User deleted";
    }
}
