package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by xiaopo on 2017/7/2.
 */
@Component
public class HystrixClientFallback implements UserFeignClient{

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
