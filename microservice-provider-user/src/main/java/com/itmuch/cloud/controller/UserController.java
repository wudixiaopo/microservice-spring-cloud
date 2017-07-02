package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by xiaopo on 2017/7/1.
 */
@RestController
public class UserController {

    @Autowired
    public UserController(UserRepository userRepository, EurekaClient eurekaClient){
        this.userRepository = userRepository;
        this.eurekaClient = eurekaClient;
    }

    private final UserRepository userRepository;

    private final EurekaClient eurekaClient;

    @RequestMapping(value="/simple/findById", method = {RequestMethod.GET, RequestMethod.POST })
    public User findById(@RequestParam (value = "id", required = true)Long id){
        return this.userRepository.findOne(id);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @RequestMapping(value="/postUser", method = {RequestMethod.POST })
    public User postUser(@RequestBody User user){
        System.out.println(user.getUsername());
        return user;
    }
}
