package com.example.details.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.config.ConfigData.Option;
import org.springframework.stereotype.Service;

import com.example.details.Model.User;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class UserService {
    
    private List<User> userlist;

    public UserService() {
        userlist = new ArrayList<>();
        
        User user1 = new User(1,"Abdulla", "Sadulla", 6, 2);
        User user2 = new User(2,"Gayazuddin", "Rizwan", 21, 15);
        User user3 = new User(5,"Akram", "Yaseen", 15, 12);
        User user4 = new User(7,"Nizmauddin", "Rizwan", 18, 143);

        userlist.addAll(Arrays.asList(user1,user2,user3,user4));
    }

    // get User data  
    public Optional<User> getUser(Integer id){
        Optional optional = Optional.empty();
        for(User user : userlist){
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }

        return optional;
    }


    // get All User data  
    public Optional<User> getAll(){
        Optional optional = Optional.of(userlist);
        return optional;
    }


    // delete user id and they details 
    public Optional<User> removeUser(Integer id){
        Optional<User> optional = userlist.stream()
                                .filter(user -> id.equals(user.getId())).
                                findFirst();

        if(optional.isPresent()){
            userlist.remove(optional.get());
            System.out.println("Deleted user successfully");
        }
        else{
            System.out.println("User details not found");
        }
        return optional;
    }

    //add new data
    public User addUser(User user) {
        userlist.add(user);
        return user; 
    }

    // update the existing data 
    public User updateUser(User user) {
        Optional<User> optional = userlist.stream()
                                .filter(userlist -> user.equals(userlist.getId())).
                                findFirst();

        if(optional.isPresent()){
            User existingUser = optional.get();
            existingUser.setId(user.getId());
            existingUser.setName(user.getName());
            existingUser.setFather_name(user.getFather_name());
            existingUser.setAge(user.getAge());
            existingUser.setSession(user.getSession());
            return existingUser;
        }
        else{
            return null;
        }
    }

}