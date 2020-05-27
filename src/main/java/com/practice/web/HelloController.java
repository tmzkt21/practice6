package com.practice.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import com.practice.web.proxy.Crawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    Crawler crawler;

    @GetMapping("/")
    public String home(){
        return "안녕크롤링";
    }

    @GetMapping("/crawler")
    public ArrayList<HashMap<String,String>> crawler(){
        return crawler.bugsMusic();
    }










//    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
//
//    /**
//     * Simply selects the home view to render by returning its name.
//     */
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home(Locale locale, Model model) {
//        logger.info("Welcome home! The client locale is {}.", locale);
//
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//        String formattedDate = dateFormat.format(date);
//
//        model.addAttribute("serverTime", formattedDate );
//
//        return "index";
//    }
}
