package com.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * Created by 其昌 on 2016/3/18.
 */
@RestController
@RequestMapping("/demo")
public class Demo {

    @Autowired
    private HttpServletRequest request;

    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    @RequestMapping(value = "/demo1" , method = RequestMethod.GET )
    public String hello(){
        return "Demo1";
    }

    @RequestMapping(value = "/demo2" , method = RequestMethod.GET)
    public void getRequestParam(@RequestParam("a") String a,
                                @RequestParam("b") String b){
        logger.info("a = " + a);
        logger.warn("b = " + b);
    }

    @RequestMapping(value = "demo3" , method = RequestMethod.GET)
    public void getRequestMap(@RequestParam Map<String,String> requestMap){
        for(Map.Entry entry:requestMap.entrySet()){
            logger.info(entry.getKey().toString() + " = " + entry.getValue().toString());
        }
    }

}
