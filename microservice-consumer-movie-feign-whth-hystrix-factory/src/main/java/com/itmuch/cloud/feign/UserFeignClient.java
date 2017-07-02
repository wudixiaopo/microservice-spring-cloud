package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * Created by xiaopo on 2017/7/1.
 */
@FeignClient(name = "microservice-provider-user",fallbackFactory = HystrixClientFactory.class)
public interface UserFeignClient {

    @RequestMapping(value="/simple/findById", method = {RequestMethod.POST })
    public User findById(@RequestParam(value = "id", required = true)Long id);

//    @RequestMapping(value="/postUser", method = {RequestMethod.POST })
//    public User postUser(@RequestBody User user);

}
