package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * Created by xiaopo on 2017/7/2.
 */
@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        HystrixClientFactory.LOGGER.info("---------------" + throwable.getMessage());
        HystrixClientFactory.LOGGER.info("---------------" + throwable);
        return (UserFeignClientWithFactory) id -> {
            User user = new User();
            user.setId(-1l);
            return user;
        };
//        return new UserFeignClientWithFactory() {
//            @Override
//            public User findById(Long id) {
//                User user = new User();
//                user.setId(-1l);
//                return user;
//            }
//        };
    }
}
