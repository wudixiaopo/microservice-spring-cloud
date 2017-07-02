package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/movie/findById",method = {RequestMethod.GET,RequestMethod.POST})
    public User findById(Long id){

        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println(serviceInstance.getServiceId() + "---" + serviceInstance.getHost() + "---" + serviceInstance.getPort());

        return this.restTemplate.getForObject("http://microservice-provider-user:7900/simple/findById?id=" + id,User.class);
    }

}
