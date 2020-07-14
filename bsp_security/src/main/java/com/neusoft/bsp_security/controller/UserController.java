package com.neusoft.bsp_security.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.neusoft.bsp_security.common.base.BaseController;
import com.neusoft.bsp_security.common.base.BaseModel;
import com.neusoft.bsp_security.common.base.BaseModelJson;
import com.neusoft.bsp_security.common.base.BaseModelTokenJson;
import com.neusoft.bsp_security.common.exception.BusinessException;
import com.neusoft.bsp_security.common.validationGroup.DeleteGroup;
import com.neusoft.bsp_security.common.validationGroup.InsertGroup;
import com.neusoft.bsp_security.common.validationGroup.UpdateGroup;
import com.neusoft.bsp_security.user.entity.Permission;
import com.neusoft.bsp_security.user.entity.Role;
import com.neusoft.bsp_security.user.entity.User;
import com.neusoft.bsp_security.user.service.PermissionService;
import com.neusoft.bsp_security.user.service.UserService;
import com.neusoft.bsp_security.utils.jwt.CheckToken;
import com.neusoft.bsp_security.utils.jwt.JwtTokenUtil;
import com.neusoft.bsp_security.utils.jwt.LoginToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public BaseModel addUser(@Validated({InsertGroup.class}) @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{user.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = userService.insert(user);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

//    @PostMapping("/checkUser")
//    public BaseModel getAllByFilter(@RequestBody User user) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("username", user.getUsername());
//        map.put("password", user.getPassword());
//        List<User> users = userService.getAllByFilter(map);
//        if (users.size() == 0) {
//            throw BusinessException.NOT_EXISTS;
//        } else {
//            BaseModel result = new BaseModel();
//            result.code = 200;
//            return result;
//        }
//    }

    @PostMapping("/checkUser")
    @LoginToken
    public BaseModelJson<User> getAllByFilter(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        try {
            subject.login(token);
            System.out.println(subject.getPrincipal());
            user = (User)subject.getPrincipal();
            BaseModelTokenJson<User> result = new BaseModelTokenJson<>();
            result.code = 200;
            result.data = user;
            String resultToken = JwtTokenUtil.createJWT(6000000, user);
            System.out.println(resultToken);
            result.token = resultToken;
            return result;
        } catch (UnknownAccountException e) {
            throw BusinessException.USERID_NULL_ERROR;
        } catch (IncorrectCredentialsException e) {
            throw BusinessException.PASSWORD_WRONG;
        }
    }

    @RequiresPermissions("admin")
    @PostMapping("/deleteUser")
    public BaseModel deleteUser(@Validated({DeleteGroup.class}) @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{user.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = userService.delete(user.getId());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }


    @PostMapping("/updateUser")
    public BaseModel updateUser(@Validated({UpdateGroup.class}) @RequestBody User user, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{user.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =userService.update(user);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }

    @PostMapping("getAllUser")
    public BaseModelJson<List<User>> getAllUser() {
        BaseModelJson<List<User>> result = new BaseModelJson<>();
        List<User> userList = userService.getAll();
        result.code = 200;
        result.data = userList;
        return result;
    }

    @GetMapping("relogin")
    public BaseModel relogin() {
        throw  BusinessException.NO_LOGIN;
    }

    @PostMapping("logout")
    public BaseModel logout() {
        BaseModel result = new BaseModel();
        result.code = 200;
        return result;
    }

    @GetMapping("getInfo")
    public BaseModelJson<User> getInfo(HttpServletRequest httpServletRequest) {
        String rToken = httpServletRequest.getHeader("token");
        System.out.println(rToken);
        if (rToken == null) {
            throw BusinessException.PERMISSION_TOKEN_INVALID;
        }
        String username;
        String password;
        try {
            username = JWT.decode(rToken).getClaim("username").asString();
            password = JWT.decode(rToken).getClaim("password").asString();
        } catch (JWTDecodeException j) {
            throw BusinessException.PERMISSION_TOKEN_INVALID;
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            System.out.println(subject.getPrincipal());
            User user = (User)subject.getPrincipal();
            BaseModelTokenJson<User> result = new BaseModelTokenJson<>();
            result.code = 200;
            result.data = user;
            String resultToken = JwtTokenUtil.createJWT(6000000, user);
            result.token = resultToken;
            return result;
        } catch (UnknownAccountException e) {
            throw BusinessException.USERID_NULL_ERROR;
        } catch (IncorrectCredentialsException e) {
            throw BusinessException.PASSWORD_WRONG;
        }
    }


}
