package com.itmuch.cloud.repository;

import com.itmuch.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserDao
 * Created by xiaopo on 2017/7/1.
 */
public interface UserRepository extends JpaRepository<User,Long>{
}
