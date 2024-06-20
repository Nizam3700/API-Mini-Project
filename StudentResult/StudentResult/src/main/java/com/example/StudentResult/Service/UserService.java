package com.example.StudentResult.Service;

import com.example.StudentResult.DataBase.UserRepo;
import com.example.StudentResult.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepo repo;

    // get User data  
    public Optional<User> getUser(Integer id){
        return repo.findById(id);
    }

    // get All User data  
    public List<User> getAll(){
        return repo.findAll();
    }

    // delete user id and they details 
    public void removeUser(Integer id){
        repo.deleteById(id);
        System.out.println("Deleted user successfully");
    }

    //add new data
    public User addUser(User user) {
        return repo.save(user);
    }

    // update the existing data 
    public User updateUser(User user) {
        Optional<User> optional = repo.findById(user.getId());
        if(optional.isPresent()){
            User existingUser = optional.get();
            existingUser.setName(user.getName());
            existingUser.setFather_name(user.getFather_name());
            existingUser.setAge(user.getAge());
            existingUser.setCourse(user.getCourse());
            existingUser.setDept(user.getDept());
            existingUser.setYear(user.getYear());
            return repo.save(existingUser);
        }
        else{
            return null;
        }
    }

    public List<User> getUsersByYear(Integer year) {
        return repo.findByYear(year);
    }

}