package com.dmooc.controller.android;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by KunLiu on 2017/2/14.
 */

@Controller
@RequestMapping("/android/teacher")
public class TeacherDispatcherController {
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    @ResponseBody
    public String GetTeacherList() {
        System.out.println("verify");
        return "SUCCESS";
    }
}
