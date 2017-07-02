package com.itmuch.cloud.controller;

import com.itmuch.cloud.feign.UserFeignClient;
import com.itmuch.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by xiaopo on 2017/7/1.
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/movie/findById",method = {RequestMethod.GET,RequestMethod.POST})
    public User findById(Long id){
        return userFeignClient.findById(id);
    }

    @RequestMapping(value="/postUser", method = {RequestMethod.POST })
    public User postUser(User user){
        System.out.println(user.getUsername());
        return userFeignClient.postUser(user);
    }

}
