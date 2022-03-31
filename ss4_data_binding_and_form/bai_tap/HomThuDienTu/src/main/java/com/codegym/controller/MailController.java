package com.codegym.controller;

import com.codegym.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {

    @GetMapping(value = "create")
    public String goCreateMail(ModelMap modelMap){
        Mail mail = new Mail();
        modelMap.addAttribute("mail", new Mail());
        return "create";
    }

    @PostMapping(value = "info")
    public String submit(@ModelAttribute("mail") Mail mail, ModelMap modelMap){
        modelMap.addAttribute("mail", mail);
        return "info";
    }

    @PostMapping(value = "edit")
    public String save(@ModelAttribute("mail") Mail mail, ModelMap modelMap){
        mail.setLanguages(mail.getLanguages());
        mail.setPageSize(mail.getPageSize());
        mail.setSpams(mail.getSpams());
        mail.setSignature(mail.getSignature());

        modelMap.addAttribute("mail", mail);
        return "create";
    }
}
