package com.codegym.controller;

import com.codegym.model.PictureComment;
import com.codegym.service.IPictureCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("comment")
public class PictureCommentController {

    @Autowired
    IPictureCommentService iPictureCommentService;

    @GetMapping("")
    public String showPictureComment(Model model){
        PictureComment pictureComment = new PictureComment();
        model.addAttribute("pictureComment", pictureComment);
        List<PictureComment> pictureComments = iPictureCommentService.findAll();
        model.addAttribute("pictureComments", pictureComments);
        return "/home";
    }

    @PostMapping("/cmt")
    public String createComment(PictureComment pictureComment){
        pictureComment.setCommentLike(0);
        iPictureCommentService.save(pictureComment);
        return "redirect:/comment";
    }

    @GetMapping(value = "/like")
    public String like(@RequestParam Integer id) {
        PictureComment pictureComment = iPictureCommentService.findById(id);
        iPictureCommentService.like(pictureComment);
        return "redirect:/comment/";
    }
}
