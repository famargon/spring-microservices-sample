package com.fapps.micro;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @RequestMapping("/userInfo")
    public Principal user(Principal user) {
        return user;
    }
	
}
