package com.qing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/12/29.
 */
@Controller
@RequestMapping(value="test")
public class TestController {

    @RequestMapping(value="codegong")
    public ModelAndView codegong(){
        ModelAndView mav = new ModelAndView("index.html");
        return mav;
    }
}
