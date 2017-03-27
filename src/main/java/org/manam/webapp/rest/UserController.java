package org.manam.webapp.rest;

import org.manam.webapp.business.UserInfoTransformer;
import org.manam.webapp.business.UserService;
import org.manam.webapp.dao.domain.UserInfo;
import org.manam.webapp.rest.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {
    private UserService userService;
    private UserInfoTransformer userInfoTransformer;

    public UserController(UserService userService, UserInfoTransformer userInfoTransformer) {
        this.userService = userService;
        this.userInfoTransformer = userInfoTransformer;
    }

    @RequestMapping("/api/admin/user")
    public List<UserDTO> getUsers() {
        Iterable<UserInfo> users = userService.getUsers();
        return userInfoTransformer.transform(users);
    }

    @RequestMapping(value = "/api/admin/user", method = POST)
    public Long createUser(@RequestBody UserDTO userDTO) {
        UserInfo userInfo = userInfoTransformer.transform(userDTO);
        Long userId = userService.createUser(userInfo);
        return userId;
    }
}
