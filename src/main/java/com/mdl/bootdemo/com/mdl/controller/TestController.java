package com.mdl.bootdemo.com.mdl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：madongliang
 * @date ：Created in 2019/8/11 1:43
 * @description： 格言：每天生活工作都要全力以赴，绝不偷懒！（尽量吧） 决定一个人的一生以及整个命运的，是日积月累的努力！
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }
}
