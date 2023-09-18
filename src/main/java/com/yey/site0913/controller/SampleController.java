package com.yey.site0913.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/ex/ex01")
    public void ex01(){

    }

    @GetMapping("/ex/ex02")
    public void ex02(Model model){
        List<String> list = Arrays.asList("AAA", "BBB", "CCC", "DDD");
        model.addAttribute("lists", list);
        model.addAttribute("message", "나는 바보다");
    }

    @GetMapping("/ex/thymeleafEx")
    public void thymeleafEx(){
        
    }

}
