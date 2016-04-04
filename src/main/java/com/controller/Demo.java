package com.controller;

import com.util.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Yang Chi-Chang on 2016/3/18.
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

    @RequestMapping(value = "demo4" , method = RequestMethod.POST)
    public User getPeople(){
        logger.info("demo4");
        return new User(1,"Matthew");
    }

    @RequestMapping(value = "demo5" , method = RequestMethod.GET)
    public Map<String,ArrayList<String>> getMap(){
        Map<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("ABC");
        arr.add("DEF");
        arr.add("GHI");
        map.put("first",arr);

        ArrayList<String> arr2 = new ArrayList<String>();
        arr2.add("A");
        arr2.add("B");
        arr2.add("C");
        arr2.add("D");
        arr2.add("F");
        map.put("second",arr2);

        return map;

    }


}
