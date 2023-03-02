package com.study.study_springboot_security.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.study_springboot_security.services.MemberWithAuthorityService;

@Controller
public class MemberWithAuthorityController {

  @Autowired
  MemberWithAuthorityService memberWithAuthorityService;

  @GetMapping("/joinForm")
  public ModelAndView joinForm(ModelAndView modelAndView) {
    String viewName = "/WEB-INF/views/member/joinForm.jsp";

    modelAndView.setViewName(viewName);
    return modelAndView;
  }

  @PostMapping("/joinProc")
  public String joinProc(@RequestParam Map params, ModelAndView modelAndView) {
    Object result = memberWithAuthorityService.insert(params);
    return "redirect:/";
  }
}
