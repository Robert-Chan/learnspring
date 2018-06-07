package com.cxx.test.controller;

import com.alibaba.fastjson.JSON;
import com.cxx.test.model.UserModel;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by Xiaoxu on 2018/6/6
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        Map map = new HashMap();
        map.put("exception", ex.getMessage());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String sStackTrace = sw.toString();
        map.put("desc", sStackTrace);
        mv.addObject("map",map);
        return mv;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/date")
    public String date(Date date) {
        System.out.println(date);
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/user")
    public UserModel user(UserModel userModel) {
        userModel = new UserModel();
        userModel.setId(1);
        userModel.setAge(18);
        userModel.setName("Curry");
        return userModel;
    }

    @ResponseBody
    @RequestMapping("/user1")
    public String user1(UserModel userModel) {
        if (userModel == null) {
            userModel = new UserModel();
            userModel.setId(1);
            userModel.setAge(18);
            userModel.setName("Curry");
        }
        return JSON.toJSONString(userModel);
    }

    @RequestMapping("terror")
    public String error() {
        int i = 5 / 0;
        return "hello";
    }
}
