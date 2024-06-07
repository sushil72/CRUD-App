package com.crudapp.crudApplication.Controller;

import com.crudapp.crudApplication.Services.UserService;
import com.crudapp.crudApplication.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class Usercontroller {

    @Autowired
    UserService service ;
    @GetMapping({"/","hello"})
    public String hello() {
        return "Hello World";
    }

    @PostMapping("adduser")
    public void  createUser(@RequestBody  Users user)
    {
        service.addUser(user);
    }

    @GetMapping("getalluser")
    public List<Users> getAllUsers()
    {
        return service.getAllUsers();
    }

    @GetMapping("getUser/{user_id}")
    public Users getUserbyId(@PathVariable Long user_id)
    {
        return service.getUserByID(user_id);
    }

    @PutMapping("adduser/{id}")
    public Users UpdateUser(@RequestBody Users newUser,@PathVariable Long id )
    {
        return service.updateUser(newUser,id);
    }

    @DeleteMapping("deleteuser/{user_id}")
    public String deleteUser(@PathVariable Long user_id){
        service.deleteUser(user_id);
        return "User deleted";
    }

}
