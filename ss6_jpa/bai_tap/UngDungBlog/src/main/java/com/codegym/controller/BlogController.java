package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String showList(Model model) {
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogs", blogList);

        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blog.setCountLike(0);
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/delete";
    }

    @PostMapping("delete")
    public String delete(Blog blog) {
        iBlogService.delete(blog.getId());
        return "redirect:/blog";
    }

    @GetMapping(value = "/like")
    public String like(@RequestParam Integer id) {
        Blog blog = iBlogService.findById(id);
        iBlogService.like(blog);
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/view";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam String author, Model model) {
//        List<Blog> blogs = iBlogService.searchByNameAuthor(author);
//        model.addAttribute("blogs", blogs);
//        return "/list";
//    }
}
