package com.example.StudentResult.Controller;

import com.example.StudentResult.Model.User;
import com.example.StudentResult.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class DeptController {

    private UserService userService;

    @Autowired
    public DeptController(UserService userService){
        this.userService = userService;
    }

//    get the details of student of year
    @GetMapping("/user/year/{year}")
    public ResponseEntity<Object> getYear(@PathVariable Integer year) {
    List<User> users = userService.getUsersByYear(year);
    if (users.isEmpty()) {
        return ResponseEntity.notFound().build();
    } else {
        Map<String, List<User>> usersByDepartment = users.stream()
                .collect(Collectors.groupingBy(User::getDept));
        return ResponseEntity.ok(usersByDepartment);
    }
    }


    @GetMapping("/user/dept/physics")
    public List<User> getPhysics() {
        List<User> users = userService.getAll(); // assuming you have a userRepository to fetch all users from the database
        List<User> physicsUsers = users.stream()
                .filter(user -> "physics".equals(user.getDept())) // assuming User class has a getSubject() method
                .collect(Collectors.toList());
        return !physicsUsers.isEmpty() ? physicsUsers : null;
    }

    @GetMapping("/user/dept/chemistry")
    public List<User> getChemistry() {
        List<User> users = userService.getAll(); // assuming you have a userRepository to fetch all users from the database
        List<User> chemistryUsers = users.stream()
                .filter(user -> "chemistry".equals(user.getDept())) // assuming User class has a getSubject() method
                .collect(Collectors.toList());
        return !chemistryUsers.isEmpty() ? chemistryUsers : null;
    }

    @GetMapping("/user/dept/arts")
    public List<User> getArts() {
        List<User> users = userService.getAll(); // assuming you have a userRepository to fetch all users from the database
        List<User> chemistryUsers = users.stream()
                .filter(user -> "arts".equals(user.getDept())) // assuming User class has a getSubject() method
                .collect(Collectors.toList());
        return !chemistryUsers.isEmpty() ? chemistryUsers : null;
    }

    @GetMapping("/user/dept/maths")
    public List<User> getMaths() {
        List<User> users = userService.getAll(); // assuming you have a userRepository to fetch all users from the database
        List<User> chemistryUsers = users.stream()
                .filter(user -> "maths".equals(user.getDept())) // assuming User class has a getSubject() method
                .collect(Collectors.toList());
        return !chemistryUsers.isEmpty() ? chemistryUsers : null;
    }

    @GetMapping("/user/dept/statisics")
    public List<User> getStatisics() {
        List<User> users = userService.getAll(); // assuming you have a userRepository to fetch all users from the database
        List<User> chemistryUsers = users.stream()
                .filter(user -> "statisics".equals(user.getDept())) // assuming User class has a getSubject() method
                .collect(Collectors.toList());
        return !chemistryUsers.isEmpty() ? chemistryUsers : null;
    }

    @GetMapping("/user/dept/botany")
    public List<User> getBotany() {
        List<User> users = userService.getAll(); // assuming you have a userRepository to fetch all users from the database
        List<User> chemistryUsers = users.stream()
                .filter(user -> "botany".equals(user.getDept())) // assuming User class has a getSubject() method
                .collect(Collectors.toList());
        return !chemistryUsers.isEmpty() ? chemistryUsers : null;
    }
}
