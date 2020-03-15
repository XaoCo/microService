package com.cpllz.the16th.controller;

import com.cpllz.the16th.pojo.User;
import com.cpllz.the16th.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther CPP
 * @date 2020/2/26 18:09
 * 　　　　　　　 ┏┓       ┏┓+ +
 * 　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 █████━█████  ┃+
 * 　　　　　　　┃　　　　　　 ┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　 ┃ + +
 * 　　　　　　　┗━━┓　　　 ┏━┛
 * ┃　　  ┃
 * 　　　　　　　　　┃　　  ┃ + + + +
 * 　　　　　　　　　┃　　　┃　Code is far away from     bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　 ┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 * 　　　　　　　　　 ┃┫┫　 ┃┫┫
 * 　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 */

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    List<User> getAllUser() {
        List<User> allUser = userService.getAllUser();
        System.out.println(allUser.size());
        return allUser;
}


    @RequestMapping(value = "/getUserByname")
    List<User> getUserByname(@RequestParam String name) {
//         name = "llz";
        System.out.println("name="+name);
        List<User> userByName = userService.getUserByName(name);
        return userByName;
    }

    @RequestMapping(value = "/getUserById")
    List<User> getUserById(@RequestParam int id) {
//         name = "llz";
        System.out.println("id="+id);
        List<User> userByName = userService.getUserById(id);
        return userByName;
    }

//    @RequestMapping(value = "/getUserByname")
//    @ResponseBody
//    List<User> getUserByname() {
//        String name = "llz";
//        List<User> userByName = userService.getUserByName(name);
//        System.out.println(userByName.size());
//        return userByName;
//    }
}
