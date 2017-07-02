package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Created by xiaopo on 2017/7/1.
 */
@RestController
public class MovieController {

    @Autowired
    public MovieController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @RequestMapping(value = "/movie/findById",method = {RequestMethod.GET,RequestMethod.POST})
    public User findById(Long id){
        return this.restTemplate.getForObject(this.userServicePath + id,User.class);
    }

}
