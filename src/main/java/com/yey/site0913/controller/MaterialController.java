package com.yey.site0913.controller;

import com.yey.site0913.dto.*;
import com.yey.site0913.service.TblMaterialGroupService;
import com.yey.site0913.service.TblMaterialItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MaterialController {

    private final TblMaterialGroupService tblMaterialGroupService;
    private final TblMaterialItemService tblMaterialItemService;

    //자재그룹
    @GetMapping("/material/reg_material_group")
    public void reg_mat(){

    }

    @PostMapping("/material/reg_material_group")
    public String reg_mat_POST(@Valid TblMaterialGroupDTO tblMaterialGroupDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("reg_mat Controller..............................");
        if(bindingResult.hasErrors()){
            log.info("has errors...............................");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/material/reg_material_group";
        }

        log.info(tblMaterialGroupDTO);
        String matGupID = tblMaterialGroupService.register(tblMaterialGroupDTO);
        redirectAttributes.addFlashAttribute("result", matGupID);

        return "redirect:/material/list_material_group";
    }

    @GetMapping("/material/list_material_group")
    public void list_material_group(Model model, PageRequestDTO pageRequestDTO){
//        List<BoardDTO> boardDTOList = boardService.list();
        PageResponseDTO<TblMaterialGroupDTO> responseDTO = tblMaterialGroupService.list(pageRequestDTO);
        log.info("list Controller............................list  : >>> " + responseDTO);
        model.addAttribute("matList", responseDTO);
    }

    //자재품목
    @GetMapping("/material/reg_material_item")
    public void reg_mat_item(){

    }
    @PostMapping("/material/reg_material_item")
    public String reg_mat_item_POST(@Valid TblMaterialItemDTO tblMaterialItemDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("reg_mat_item POST Controller..............................");
        if(bindingResult.hasErrors()){
            log.info("has errors..............................."+ bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/material/reg_material_item";
        }

        log.info(tblMaterialItemDTO);
        String matGupID = tblMaterialItemService.register(tblMaterialItemDTO);
        redirectAttributes.addFlashAttribute("result", matGupID);

        return "redirect:/material/list_material_item";
    }

    @GetMapping("/material/list_material_item")
    public void list_material_item(Model model, PageRequestDTO pageRequestDTO){
//        List<BoardDTO> boardDTOList = boardService.list();
        PageResponseDTO<TblMaterialItemDTO> responseDTO = tblMaterialItemService.list(pageRequestDTO);
        log.info("list Controller............................list  : >>> " + responseDTO);
        model.addAttribute("matList", responseDTO);
    }

}
