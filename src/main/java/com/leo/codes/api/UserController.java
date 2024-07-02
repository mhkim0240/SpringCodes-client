package com.leo.codes.api;


import com.leo.codes.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    //private final UserService userService;
    @GetMapping("/users")
    public void getUsers(){
        System.out.println("getUsers");
    }

    @GetMapping("/users/{id}")
    public void getUser(@PathVariable String id){
        System.out.println("getUser : " + id);
    }

    @PostMapping("/users")
    public void registUser(@RequestBody User user){
        System.out.println("registUser");
    }

    @PutMapping("/users")
    public void modifyUser(@RequestBody User user){
        System.out.println("modifyUser");
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable String id){
        System.out.println("removeUser : " + id);
    }

}
