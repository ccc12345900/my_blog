package com.zuo.blog.Service;

import com.zuo.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    User checkUser(String username,String password);
}
