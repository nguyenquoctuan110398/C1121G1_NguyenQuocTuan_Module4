package com.directory.controller;

import com.directory.service.IDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DirectoryController {

    @Autowired
    private IDirectoryService iDirectoryService;

    @GetMapping("/directory")
    public String goIndexForm(){
        return "formDirectory";
    }

    @PostMapping("/directory")
    public String result(@RequestParam String englishWord, Model model){
        String vietnamese = iDirectoryService.result(englishWord);
        model.addAttribute("englishWord", englishWord);
        model.addAttribute("vietnameseWord", vietnamese);
        return "formDirectory";
    }

}
