package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(HystrixDashboardApplication.class,args);
    }
}
