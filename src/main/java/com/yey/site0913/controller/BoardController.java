package com.yey.site0913.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class BoardController {

    @GetMapping("/board/insertProd")
    public String insertProd(Model model){
        return "/board/in_products";
    }

}
