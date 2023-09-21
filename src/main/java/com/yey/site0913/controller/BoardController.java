package com.yey.site0913.controller;

import com.yey.site0913.dto.BoardDTO;
import com.yey.site0913.dto.PageRequestDTO;
import com.yey.site0913.dto.PageResponseDTO;
import com.yey.site0913.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/board/in_products")
    public void insertProdGET(){

    }

    @PostMapping("/board/in_products")
    public String insertProdPOST(@Valid BoardDTO boardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("board POST register.......................................");
        if(bindingResult.hasErrors()){
            log.info("has errors...............................");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/in_products";
        }

        log.info(boardDTO);
        Long bno = boardService.register(boardDTO);
        redirectAttributes.addFlashAttribute("result", bno);

        return "redirect:/board/list_products";
    }

    @GetMapping("/board/list_products")
    public void listProducts(Model model){
        log.info("list Controller............................list");
        List<BoardDTO> boardDTOList = boardService.list();
        model.addAttribute("boardList", boardDTOList);
    }


    @GetMapping("/board/View_products")
    public void View_products(Long bno, Model model, PageRequestDTO pageRequestDTO){
        BoardDTO boardDTO = boardService.readOne(bno);
        log.info(boardDTO);

        model.addAttribute("dto", boardDTO);

    }
//    public void read_products(){
//
//    }

}
